package com.example.service01;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * IntentService是Service的子类。是一个异步处理服务，新开了一个线程：HandlerThread，在线程中发消息，然后接收。
 * 处理完成后会结束线程，并关闭服务。而Service的关闭要手动。
 * 
 * 继承IntentService要实现的onHandleIntent()方法。
 * 此类也要在Manifest文件中注册。
 * 
 */
public class HelloIntentService extends IntentService {
 
	/**
	 * 默认构造函数。
	 */
	public HelloIntentService(String name) {
		super(name);
	}
	
	/**
	 * 必须建立一个无参的构造函数，否则开启IntentService时会出错。
	 */
	public HelloIntentService() {
		super("MyIntentService");
	} 

	
	@Override
	protected void onHandleIntent(Intent intent) {
		Log.i("MyLog","onHandleIntent");
		
		for (int i = 0; i < 10; i++) {
			try {
				
				Thread.sleep(1000);
				Log.i("MyLog",""+i);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i("MyLog","onCreate");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i("MyLog","onDestroy");
	} 

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("MyLog","onStartCommand");
		return super.onStartCommand(intent, flags, startId);
		
		/* 如返回如下值，则只执行到onStartcommmand 就结束了。onHandleIntent()不会被执行。*/
//		return START_STICKY;
	}

	
	

}
