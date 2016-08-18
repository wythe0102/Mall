package com.wythe.mall.utils;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {

	/**
	 * 将服务器返回的参数转换成json格式: "param": "page=1,pagesize=5 ",
	 * 
	 * @return
	 */
	public static JSONObjectProxy parseParamsJsonFromString(String params) {
		JSONObjectProxy json = new JSONObjectProxy();
		if(!params.startsWith("{")) {
			try {
				if (!TextUtils.isEmpty(params)) {
					String[] args = params.trim().split(",");
					for (String arg : args) {
						String[] strs = arg.trim().split("=");
						if (strs.length < 2) {
							continue;
						} else {
							try {
								json.put(strs[0], strs[1]);
							} catch (JSONException e) {
								e.printStackTrace();
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				json = new JSONObjectProxy(new JSONObject(params));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		return json;
		
	}
	
	
	
	/**
	 * 给jsonObject转译
	 * 
	 * @return
	 */
	public static String parseStringFromJsonObject(JSONObject params) {
		
		if(params == null) {
			return "";
		}
		
		String temp = params.toString();
		
		if(TextUtils.isEmpty(temp)) {
			return "";
		}
		
		temp = temp.replaceAll("\"", "\\\"");
		
		return temp;
	}

}
