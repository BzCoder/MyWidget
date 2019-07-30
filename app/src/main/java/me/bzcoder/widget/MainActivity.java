package me.bzcoder.widget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import me.bzcoder.widget.sample.DownloadButtonActivity;
import me.bzcoder.widget.sample.TagActivity;

/**
 * @author : BaoZhou
 * @date : 2019/7/23 9:20
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btTags;
    private Button btDownloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btTags = findViewById(R.id.bt_tags);
        btTags.setOnClickListener(this);
        btDownloadButton = findViewById(R.id.bt_downloading_button);
        btDownloadButton.setOnClickListener(this);
        EventBus.getDefault();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_tags:
                Intent intent = new Intent(this, TagActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_downloading_button:
                startActivity( new Intent(this, DownloadButtonActivity.class));
                break;
            default:
                break;

        }
    }
}
