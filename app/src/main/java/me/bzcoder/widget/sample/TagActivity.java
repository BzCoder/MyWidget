package me.bzcoder.widget.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import me.bzcoder.widget.R;
import me.bzcoder.widget.textview.BorderTextView;

/**
 * @author : BaoZhou
 * @date : 2019/7/23 10:46
 */
public class TagActivity extends AppCompatActivity {
    private BorderTextView tv1;
    private BorderTextView tv2;
    private BorderTextView tv3;
    private BorderTextView tv4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag);
        initView();
    }

    private void initView() {
        tv1 = (BorderTextView) findViewById(R.id.tv_1);
        tv2 = (BorderTextView) findViewById(R.id.tv_2);
        tv3 = (BorderTextView) findViewById(R.id.tv_3);
        tv4 = (BorderTextView) findViewById(R.id.tv_4);
        tv1.setBorderColor(Color.parseColor("#D81B60"));
    }
}
