package com.blueice.androidlib.net;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;

import com.alibaba.fastjson.JSON;

/**
 * 自封装的AsyncTask类，覆写的了doinBackground,onPostExecut方法。
 * 在执行doinBackground时传入URL.
 * 在onPostExecut可以接收到Respons对象,并且这里调用了两个抽像方法
 * 一个是成功后执行的方法，一个失败后的执行的方法。
 */
public abstract class RequestAsyncTask extends
		AsyncTask<String, Void, Response> {

	public abstract void onSuccess(String result);

	public abstract void onFail(String errorMessage);


	@Override
	protected void onPostExecute(Response response) {
		if (response.hasError()) {
			onFail(response.getErrorMessage());
		} else {
			onSuccess(response.getResult());
		}
	}

	@Override
	protected Response doInBackground(String... url) {
		return getResponseFromURL(url[0]);
	}

	private Response getResponseFromURL(String url) {
		Response response = new Response();
		HttpGet get = new HttpGet(url);
		String strResponse = null;
		try {
			HttpParams httpParameters = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParameters, 8000);
			HttpClient httpClient = new DefaultHttpClient(httpParameters);

			HttpResponse httpResponse = httpClient.execute(get);
			if (httpResponse.getStatusLine().getStatusCode() 
					== HttpStatus.SC_OK) {
				strResponse = EntityUtils.toString(httpResponse.getEntity());
			}
		} catch (Exception e) {
			response.setErrorType(-1);
			response.setError(true);
			response.setErrorMessage(e.getMessage());
		}

		if (strResponse == null) {
			response.setErrorType(-1);
			response.setError(true);
			response.setErrorMessage("网络异常，返回空值");
		} else {
			strResponse = "{'isError':false,'errorType':0,'errorMessage':'','result':{'city':'北京','cityid':'101010100','temp':'17','WD':'西南风','WS':'2级','SD':'54%','WSE':'2','time':'23:15','isRadar':'1','Radar':'JC_RADAR_AZ9010_JB','njd':'暂无实况','qy':'1016'}}";
			response = JSON.parseObject(strResponse, Response.class);
		}		
		return response;
	}
}
