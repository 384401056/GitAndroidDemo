package com.blueice.emchatdemo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.hyphenate.easeui.ui.EaseChatFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        EaseChatFragment chatFragment = new EaseChatFragment();

        //接收传递过来的参数。
        chatFragment.setArguments(getIntent().getExtras());

        //加载EaseUI的聊天界面。
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, chatFragment).commit();


    }
}
