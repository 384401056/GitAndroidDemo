package com.example.service02;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBinderService extends Service {

	/* 声明接口对象。*/
	IBinder mBinder = new MyBinder();
	
 
	@Override
	public IBinder onBind(Intent intent) {
		/* 暴露我们的Binder接口给客户端。*/
		Log.i("MyLog","onBind");
		return mBinder;
	}
	
	
	/**
	 * 定义类，继承Binder接口.  
	 */
	class MyBinder extends Binder {

		/*
		 * 直接返回一个服务端对象，让客户端可以调用服务端的所有方法。
		 */
		public Service getService(){
			return MyBinderService.this;
		}
		
		public String helloWorld(String name) {
			return "Your name is :" + name;
		}

	}
	
	/*
	 * 服务端的方法必须为public客户端才可调用。
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
