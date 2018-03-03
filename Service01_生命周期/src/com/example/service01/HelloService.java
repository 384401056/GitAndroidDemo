package com.example.service01;

/**
 * 理解Service的生命周期。
 * 了解开启和关闭服务的方法。
 */
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Service和Activity一样需要在Manifest中注册,注册名要与类名相同。
 * @author ServerAdmin
 *
 */
public class HelloService extends Service {

	private int mStartId;
	
	
	
	@Override
	public void onCreate() {
		super.onCreate();
	}
	
	/**
	 * 新片本的onStart()
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		mStartId = startId;
		
		//开启线程执行服务。
		new Thread(new Runnable() {
			@Override
			public void run() {
				
				serviceFunction();
				
			}
		}).start();

		return super.onStartCommand(intent, flags, startId);
	}
	

	/**
	 * 服务的方法体。
	 */
	private void serviceFunction() {
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
	public void onDestroy() {
		super.onDestroy();
		Log.i("MyLog", "Service onDestory");
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
}
