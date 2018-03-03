package com.example.service01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btnStarS;
	private Button btnStopS;
	private Button btnStarIs;
	private Intent mIntent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//��������
		btnStarS = (Button)findViewById(R.id.button1);
		btnStarS.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				 mIntent = new Intent(MainActivity.this,HelloService.class);
				 startService(mIntent);
			}
		});
		
		
		//�رշ��񡣵������ַ���ֻ��Destory���񣬲���ֹͣ�̵߳Ķ���ִ�С�
		btnStopS = (Button)findViewById(R.id.button2);
		btnStopS.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				stopService(mIntent);
			}
		});
		
		
		//����IntentService
		btnStarIs = (Button)findViewById(R.id.button3);
		btnStarIs.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent _intent = new Intent(MainActivity.this,HelloIntentService.class);
				startService(_intent);
			}
		});
	}

}
