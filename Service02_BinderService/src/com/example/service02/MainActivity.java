package com.example.service02;

import com.example.service02.MyBinderService.MyBinder;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btnStartBS;
	private Button btnUnBind;

	
	/* �������Ӷ��� */
    private ServiceConnection conn = new ServiceConnection() {
		/**
		 * ���Ͽ����Ӻ�Ҫִ�еĲ�����
		 */
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
		/**
		 * �����Ӻ�Ҫִ�еĲ�����
		 */
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
			/* ���÷����IBinder�ӿ��еķ���������Ĳ��� service �������Ƿ����onBind()�������صĶ�������.*/
			String str = ((MyBinder)service).helloWorld("GaoYanbin");
			Log.i("MyLog", str);
			Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
			
			/* ���÷���˵�getService����������һ��MyBinderService���������Ϳ��Ա��÷���˵����й���������ע��ת��*/
			((MyBinderService) ((MyBinder)service).getService()).helloWorld();
		}
	};
	 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btnStartBS = (Button) findViewById(R.id.button1);
		btnStartBS.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				/* ����Intent */
				Intent _Intent = new Intent(MainActivity.this,MyBinderService.class);

				bindService(_Intent, conn, Service.BIND_AUTO_CREATE);
			}
		});
		
		
		/*
		 * ����󶨡�
		 */
		btnUnBind = (Button)findViewById(R.id.button2);
		btnUnBind.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				unbindService(conn);
			}
		});

	}

}

















