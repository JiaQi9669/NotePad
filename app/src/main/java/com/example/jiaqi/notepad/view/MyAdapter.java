package com.example.jiaqi.notepad.view;

/**
 * Created by JiaQi on 2018/6/12.
 */

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.example.jiaqi.notepad.R;

public class MyAdapter extends BaseAdapter implements View.OnClickListener
{
    /**
     * 这个用来填充list
     */
    private List<Integer> colors;
    /**
     * context上下文,用来获得convertView
     */
    private Context mContext;
    /**
     * 屏幕宽度,由于我们用的是HorizontalScrollView,所以按钮选项应该在屏幕外
     */
    private int mScreentWidth;

    /**
     * 构造方法
     * @param context
     * @param screenWidth
     */
    public MyAdapter(Context context, int screenWidth)
    {
        //初始化
        mContext = context;
        mScreentWidth = screenWidth;

        //填充list的内容
        colors = new ArrayList<Integer>();

//      防测试数据
        for (int i = 0; i < 25; i++)
        {
            if(i == 3){
                colors.add(R.color.red);
            }else{
                colors.add(R.color.mediumaquamarine);
            }
//            colors.add(R.color.blue);
//            colors.add(000);
        }
    }

    @Override
    public int getCount()
    {
        return colors.size();
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final ViewHolder holder;
        //如果没有设置过,初始化convertView
        if (convertView == null)
        {
            //获得设置的view
            convertView = LayoutInflater.from(mContext).inflate(R.layout.activity_mainitem_list, parent, false);

            //初始化holder
            holder = new ViewHolder();

            /**
             * 整个item的水平滚动层
             */
            holder.itemHorizontalScrollView = (HorizontalScrollView) convertView.findViewById(R.id.hsv);

            /**
             * 操作按钮层
             */
            holder.actionLayout = convertView.findViewById(R.id.ll_action);
            holder.btOne = (Button) convertView.findViewById(R.id.button1);
            holder.btTwo = (Button) convertView.findViewById(R.id.button2);

            //把位置放到view中,这样点击事件就可以知道点击的是哪一条item
            holder.btOne.setTag(position);
            holder.btTwo.setTag(position);

            holder.tvContent = (TextView) convertView.findViewById(R.id.tv);

            //设置内容view的大小为屏幕宽度,这样按钮就正好被挤出屏幕外
            holder.normalItemContentLayout = convertView.findViewById(R.id.ll_content);
            LayoutParams lp = holder.normalItemContentLayout.getLayoutParams();
            lp.width = mScreentWidth;

            convertView.setTag(holder);
        }
        else//有直接获得ViewHolder
        {
            holder = (ViewHolder) convertView.getTag();
        }

        //设置监听事件
        convertView.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_UP:

                        //获得ViewHolder
                        ViewHolder viewHolder = (ViewHolder) v.getTag();

                        //获得HorizontalScrollView滑动的水平方向值.
                        int scrollX = viewHolder.itemHorizontalScrollView.getScrollX();

                        //获得操作区域的长度
                        int actionW = viewHolder.actionLayout.getWidth();

                        //注意使用smoothScrollTo,这样效果看起来比较圆滑,不生硬
                        //如果水平方向的移动值<操作区域的长度的一半,就复原
                        if (scrollX < actionW / 2)
                        {
                            viewHolder.itemHorizontalScrollView.smoothScrollTo(0, 0);
                        }
                        else//否则的话显示操作区域
                        {
                            viewHolder.itemHorizontalScrollView.smoothScrollTo(actionW, 0);
                        }
                        return true;
                }
                return false;
            }
        });

        //这里防止删除一条item后,ListView处于操作状态,直接还原
        if (holder.itemHorizontalScrollView.getScrollX() != 0)
        {
            holder.itemHorizontalScrollView.scrollTo(0, 0);
        }

        //设置背景颜色,设置填充内容.
//        holder.normalItemContentLayout.setBackgroundResource(colors.get(position));
        holder.tvContent.setText("" + position);

        //设置监听事件
        holder.btOne.setOnClickListener(this);
        holder.btTwo.setOnClickListener(this);

        return convertView;
    }

    /**
     * ViewHolder
     *@Title:
     *@Description:主要是避免了不断的view获取初始化.
     *@Author:justlcw
     *@Since:2013-11-22
     *@Version:
     */
    class ViewHolder
    {
        public HorizontalScrollView itemHorizontalScrollView;

        /**
         * 正常（没左侧滑）情况的item内容布局
         */
        public View normalItemContentLayout;
        public TextView tvContent;

        /**
         * 删除，添加，变色操作按钮层
         */
        public View actionLayout;
        public Button btOne;
        public Button btTwo;
    }

    @Override
    public void onClick(View v)
    {
        int position = (Integer) v.getTag();
        switch (v.getId())
        {
            case R.id.button1:
                //详情
                break;
            case R.id.button2:
//                删除
                colors.remove(position);
                break;
            default:
                break;
        }
        //刷新ListView内容
        notifyDataSetChanged();
    }
}