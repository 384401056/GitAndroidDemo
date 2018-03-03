package com.example.service02;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBinderService extends Service {

	/* �����ӿڶ���*/
	IBinder mBinder = new MyBinder();
	
 
	@Override
	public IBinder onBind(Intent intent) {
		/* ��¶���ǵ�Binder�ӿڸ��ͻ��ˡ�*/
		Log.i("MyLog","onBind");
		return mBinder;
	}
	
	
	/**
	 * �����࣬�̳�Binder�ӿ�.  
	 */
	class MyBinder extends Binder {

		/*
		 * ֱ�ӷ���һ������˶����ÿͻ��˿��Ե��÷���˵����з�����
		 */
		public Service getService(){
			return MyBinderService.this;
		}
		
		public String helloWorld(String name) {
			return "Your name is :" + name;
		}

	}
	
	/*
	 * ����˵ķ�������Ϊpublic�ͻ��˲ſɵ��á�
	 */
	public void helloWorld(){
		
		for (int i = 0; i < 10; i++) {
			try {
				
				Thread.sleep(1000);
				Log.i("MyLog",""+i);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}


	@Override
	public void onCreate() {
		Log.i("MyLog","onCreate");
		super.onCreate();
		
	}

	@Override
	public void onDestroy() {
		Log.i("MyLog","onDestroy");
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("MyLog","onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.i("MyLog","onUnbind");
		return super.onUnbind(intent);
	}


	
}
