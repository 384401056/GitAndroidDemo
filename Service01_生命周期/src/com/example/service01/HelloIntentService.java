package com.example.service01;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * IntentService��Service�����ࡣ��һ���첽��������¿���һ���̣߳�HandlerThread�����߳��з���Ϣ��Ȼ����ա�
 * ������ɺ������̣߳����رշ��񡣶�Service�Ĺر�Ҫ�ֶ���
 * 
 * �̳�IntentServiceҪʵ�ֵ�onHandleIntent()������
 * ����ҲҪ��Manifest�ļ���ע�ᡣ
 * 
 */
public class HelloIntentService extends IntentService {
 
	/**
	 * Ĭ�Ϲ��캯����
	 */
	public HelloIntentService(String name) {
		super(name);
	}
	
	/**
	 * ���뽨��һ���޲εĹ��캯����������IntentServiceʱ�����
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
		
		/* �緵������ֵ����ִֻ�е�onStartcommmand �ͽ����ˡ�onHandleIntent()���ᱻִ�С�*/
//		return START_STICKY;
	}

	
	

}
