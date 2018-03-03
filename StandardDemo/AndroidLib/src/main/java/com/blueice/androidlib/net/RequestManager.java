package com.blueice.androidlib.net;

import com.blueice.androidlib.activity.BaseActivity;
import org.apache.http.HttpRequest;
import org.apache.http.message.BasicHttpRequest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RequestManager {

	ArrayList<BasicHttpRequest> requestList = null;

	public RequestManager(final BaseActivity activity) {
		// 异步请求列表
		requestList = new ArrayList<BasicHttpRequest>();
	}

	/**
	 * 添加Request到列表
	 */
	public void addRequest(final BasicHttpRequest request) {
		requestList.add(request);
	}

	/**
	 * 取消网络请求
	 */
	public void cancelRequest() {
		if ((requestList != null) && (requestList.size() > 0)) {
			for (final HttpRequest request : requestList) {
				if (request.getRequest() != null) {
					try {
						request.getRequest().abort();
						requestList.remove(request.getRequest());
					} catch (final UnsupportedOperationException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * 无参数调用
	 */
	public HttpRequest createRequest(final URLData urlData,
			final RequestCallback requestCallback) {
		return createRequest(urlData, null, requestCallback);
	}

	/**
	 * 有参数调用
	 */
	public HttpRequest createRequest(final URLData urlData,
			final List<RequestParameter> params,
			final RequestCallback requestCallback) {
		final HttpRequest request = new HttpRequest(urlData, params,
				requestCallback);

		addRequest(request);
		return request;
	}
}
