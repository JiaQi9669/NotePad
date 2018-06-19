package com.example.jiaqi.notepad.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiaqi.notepad.R;
import com.example.jiaqi.notepad.entity.PassWord;

/**
 * Created by JiaQi on 2018/6/12.
 * 密码输入界面
 */

public class PassWordActivity extends Activity {
    private PassWord passWord = new PassWord();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
//        监听器
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.password_num0:
                        addNumber(0);
                        addTextView();
                        break;
                    case R.id.password_num1:
                        addNumber(1);
                        addTextView();
                        break;
                    case R.id.password_num2:
                        addNumber(2);
                        addTextView();
                        break;
                    case R.id.password_num3:
                        addNumber(3);
                        addTextView();
                        break;
                    case R.id.password_num4:
                        addNumber(4);
                        addTextView();
                        break;
                    case R.id.password_num5:
                        addNumber(5);
                        addTextView();
                        break;
                    case R.id.password_num6:
                        addNumber(6);
                        addTextView();
                        break;
                    case R.id.password_num7:
                        addNumber(7);
                        addTextView();
                        break;
                    case R.id.password_num8:
                        addNumber(8);
                        addTextView();
                        break;
                    case R.id.password_num9:
                        addNumber(9);
                        addTextView();
                        break;
                    case R.id.password_del:
                        passWord.delNumber();
                        delTextView();
                        break;
                    default:
                        break;
                }
            }
        };

        ((Button) findViewById(R.id.password_num0)).setOnClickListener(clickListener);
        ((Button) findViewById(R.id.password_num1)).setOnClickListener(clickListener);
        ((Button) findViewById(R.id.password_num2)).setOnClickListener(clickListener);
        ((Button) findViewById(R.id.password_num3)).setOnClickListener(clickListener);
        ((Button) findViewById(R.id.password_num4)).setOnClickListener(clickListener);
        ((Button) findViewById(R.id.password_num5)).setOnClickListener(clickListener);
        ((Button) findViewById(R.id.password_num6)).setOnClickListener(clickListener);
        ((Button) findViewById(R.id.password_num7)).setOnClickListener(clickListener);
        ((Button) findViewById(R.id.password_num8)).setOnClickListener(clickListener);
        ((Button) findViewById(R.id.password_num9)).setOnClickListener(clickListener);
        ((Button) findViewById(R.id.password_del)).setOnClickListener(clickListener);
    }

    /**
     * 添加数字
     * @param number
     */
    public void addNumber(int number){
        passWord.addNumber(number);
        if(passWord.isDoen()){
            Toast.makeText(PassWordActivity.this,"1",Toast.LENGTH_SHORT).show();
        }
    }

    public void addTextView(){
        switch (passWord.getNownumber()){
            case 1:
                ((TextView) findViewById(R.id.password_text1)).setText("*");
                break;
            case 2:
                ((TextView) findViewById(R.id.password_text2)).setText("*");
                break;
            case 3:
                ((TextView) findViewById(R.id.password_text3)).setText("*");
                break;
            case 4:
                ((TextView) findViewById(R.id.password_text4)).setText("*");
                break;
            default:
                break;
        }
    }

    public void delTextView(){
        switch (passWord.getNownumber()+1){
            case 1:
                ((TextView) findViewById(R.id.password_text1)).setText("-");
                break;
            case 2:
                ((TextView) findViewById(R.id.password_text2)).setText("-");
                break;
            case 3:
                ((TextView) findViewById(R.id.password_text3)).setText("-");
                break;
            case 4:
                ((TextView) findViewById(R.id.password_text4)).setText("-");
                break;
            default:
                break;
        }
    }
}
