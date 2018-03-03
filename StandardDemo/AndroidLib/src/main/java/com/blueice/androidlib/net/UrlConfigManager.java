package com.blueice.androidlib.net;

import java.io.IOException;

import com.blueice.androidlib.R;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.app.Activity;
import android.content.res.XmlResourceParser;


public class UrlConfigManager {

	/**
	 * 从url.xml文件中找出对应的URLData实体。
	 * @param activity
	 * @param findKey
     * @return
     */
	public static URLData findURL(final Activity activity, final String findKey) {
		final XmlResourceParser xmlParser = activity.getApplication()
				.getResources().getXml(R.xml.url);
		int eventCode;
		try {
			eventCode = xmlParser.getEventType();
			while (eventCode != XmlPullParser.END_DOCUMENT) {
				switch (eventCode) {
				case XmlPullParser.START_DOCUMENT:
					break;
				case XmlPullParser.START_TAG:
					if ("Node".equals(xmlParser.getName())) {
						final String key = xmlParser.getAttributeValue(
								null, "Key");
						if (key.trim().equals(findKey)) {
							final URLData urlData = new URLData();
							urlData.setKey(findKey);
							urlData.setExpires(Long.parseLong(xmlParser
									.getAttributeValue(null, "Expires")));
							urlData.setNetType(xmlParser.getAttributeValue(
									null, "NetType"));
							urlData.setUrl(xmlParser.getAttributeValue(null,
									"Url"));
							return urlData;
						}
					}
					break;
				case XmlPullParser.END_TAG:
					break;
				default:
					break;
				}
				eventCode = xmlParser.next();
			}
		} catch (final XmlPullParserException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			xmlParser.close();
		}
		return null;
	}
}