package com.example.service01;

/**
 * ���Service���������ڡ�
 * �˽⿪���͹رշ���ķ�����
 */
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Service��Activityһ����Ҫ��Manifest��ע��,ע����Ҫ��������ͬ��
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
	 * ��Ƭ����onStart()
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		mStartId = startId;
		
		//�����߳�ִ�з���
		new Thread(new Runnable() {
			@Override
			public void run() {
				
				serviceFunction();
				
			}
		}).start();

		return super.onStartCommand(intent, flags, startId);
	}
	

	/**
	 * ����ķ����塣
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
