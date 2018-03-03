package com.blueice.standarddemo.engine;


import com.blueice.androidlib.activity.BaseActivity;
import com.blueice.androidlib.net.RequestCallback;
import com.blueice.androidlib.net.RequestParameter;
import com.blueice.androidlib.net.URLData;
import com.blueice.androidlib.net.UrlConfigManager;
import org.apache.http.HttpRequest;

import java.util.List;

public class RemoteService {
	private static RemoteService service = null;

	private RemoteService() {

	}

	public static synchronized RemoteService getInstance() {
		if (RemoteService.service == null) {
			RemoteService.service = new RemoteService();
		}
		return RemoteService.service;
	}

	public void invoke(final BaseActivity activity,
			final String apiKey,
			final List<RequestParameter> params,
			final RequestCallback callBack) {
		final URLData urlData = UrlConfigManager.findURL(activity, apiKey);
		HttpRequest request = activity.getRequestManager().createRequest(
				urlData, params, callBack);
		DefaultThreadPool.getInstance().execute(request);
	}
}