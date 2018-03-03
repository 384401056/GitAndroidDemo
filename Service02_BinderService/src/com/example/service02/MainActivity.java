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

	
	/* 建立连接对象 */
    private ServiceConnection conn = new ServiceConnection() {
		/**
		 * 当断开连接后要执行的操作。
		 */
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
		/**
		 * 当连接后要执行的操作。
		 */
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
			/* 调用服务端IBinder接口中的方法。这里的参数 service 就是我们服务端onBind()方法返回的对象引用.*/
			String str = ((MyBinder)service).helloWorld("GaoYanbin");
			Log.i("MyLog", str);
			Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
			
			/* 调用服务端的getService方法，返回一个MyBinderService对象，这样就可以便用服务端的所有公共方法。注意转型*/
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
				/* 建立Intent */
				Intent _Intent = new Intent(MainActivity.this,MyBinderService.class);

				bindService(_Intent, conn, Service.BIND_AUTO_CREATE);
			}
		});
		
		
		/*
		 * 解除绑定。
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

















