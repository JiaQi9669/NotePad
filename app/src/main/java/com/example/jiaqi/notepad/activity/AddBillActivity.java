package com.example.jiaqi.notepad.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.jiaqi.notepad.R;

/**
 * Created by JiaQi on 2018/6/12.
 */

public class AddBillActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);

/**     获取其他activity中的 textview
        LayoutInflater factory = LayoutInflater.from(AddBillActivity.this);
        View layout = factory.inflate(R.layout.nav_header_main, null);
        TextView textview = (TextView) layout.findViewById(R.id.side_money);
        textview.setText("1111");
 */
    }
}
