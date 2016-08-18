package com.wythe.mall.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Iterator;

public class JSONObjectProxy extends JSONObject implements Serializable {

	private JSONObject jsonObject;

	public JSONObjectProxy(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	/**
	 * 
	 */
	public JSONObjectProxy() {
		// TODO Auto-generated constructor stub
		jsonObject = new JSONObject();
	}

	public JSONObject accumulate(String name, Object value) throws JSONException {
            return jsonObject.accumulate(name, value);
	}

	public boolean equals(JSONObject o) {
		if(jsonObject == o)
			return true;
		else if(null!=jsonObject && null!=o)
		{
			String strjsonObj = jsonObject.toString();
			String strTmp = o.toString();
			return strjsonObj.equals(strTmp);
		}
		else 
			return false;
		
		//原来的 jsonObject.equals(o) 不能实现json内容比较
	}

	public Object get(String name) throws JSONException {
		return jsonObject.get(name);
	}

	public boolean getBoolean(String name) throws JSONException {
		return jsonObject.getBoolean(name);
	}

	/**
	 * 获取对象类型 Boolean 值, 获取不到返回null。
	 * 
	 * @deprecated 如果设置默认返回值，建议使用{@link JSONObject#optBoolean(String )} 或者 {@link JSONObject#optBoolean(String,boolean)}
	 * @param name
	 * @return Boolean 对象，可能返回null
	 */
	@Deprecated
	public Boolean getBooleanOrNull(String name) {
		if (jsonObject.isNull(name)) {
			return null;
		}
		try {
			return jsonObject.getBoolean(name);
		} catch (JSONException e) {
			Log.v(JSONObjectProxy.class.getName(), e.getMessage());
			return null;
		}
	}

	public double getDouble(String name) throws JSONException {
		return jsonObject.getDouble(name);
	}
	
	/**
	 * 获取对象类型 Double 值, 获取不到返回null。
	 *
	 * @param name
	 * @return Double 对象，可能返回null
	 */
	@Deprecated
	public Double getDoubleOrNull(String name) {
		if (jsonObject.isNull(name)) {
			return null;
		}
		try {
			return jsonObject.getDouble(name);
		} catch (JSONException e) {
			Log.v(JSONObjectProxy.class.getName(), e.getMessage());
			return null;
		}
	}

	
	public int getIntegerValue(String name) {
		if (jsonObject.isNull(name)) {
			return -1;
		}
		try {
			int temp = jsonObject.getInt(name);
			return temp;
		} catch (JSONException e) {
			Log.v(JSONObjectProxy.class.getName(), e.getMessage());
			return -1;
		}
	}
	
	public double getDoubleValue(String name) {
		if (jsonObject.isNull(name)) {
			return -1;
		}
		try {
			Double tempDouble  = jsonObject.getDouble(name);
			return tempDouble.doubleValue();
		} catch (JSONException e) {
			Log.v(JSONObjectProxy.class.getName(), e.getMessage());
			return -1;
		}
	}
	
	public int getInt(String name) throws JSONException {
		return jsonObject.getInt(name);
	}

	/**
	 * 获取对象类型 Integer 值, 获取不到返回null。
	 * 
	 * @deprecated 如果设置默认返回值，建议使用{@link JSONObject#optInt(String )}
	 * @param name
	 * @return Integer 对象，可能返回null
	 */
	@Deprecated
	public Integer getIntOrNull(String name) {
		if (jsonObject.isNull(name)) {
			return null;
		}
		try {
			return jsonObject.getInt(name);
		} catch (JSONException e) {
			Log.v(JSONObjectProxy.class.getName(), e.getMessage());
			return null;
		}
	}

	public JSONArrayPoxy getJSONArray(String name) throws JSONException {
		return new JSONArrayPoxy(jsonObject.getJSONArray(name));
	}

	/**
	 * 获取JSONArrayPoxy, 获取不到返回null。
	 * 
	 * @param name
	 * @return JSONArrayPoxy 对象，可能返回null
	 */
	public JSONArrayPoxy getJSONArrayOrNull(String name) {
		if (jsonObject.isNull(name)) {
			return null;
		}
		try {
			return new JSONArrayPoxy(jsonObject.getJSONArray(name));
		} catch (JSONException e) {
			return null;
		}
	}

	public JSONObjectProxy getJSONObject(String name) throws JSONException {
		return new JSONObjectProxy(jsonObject.getJSONObject(name));
	}

	/**
	 * 获取JSONObjectProxy, 获取不到返回null。
	 * 
	 * @param name
	 * @return JSONObjectProxy 对象，可能返回null
	 */
	public JSONObjectProxy getJSONObjectOrNull(String name) {
		if (jsonObject.isNull(name)) {
			return null;
		}
		try {
			return new JSONObjectProxy(jsonObject.getJSONObject(name));
		} catch (JSONException e) {
			return null;
		}
	}

	public long getLong(String name) throws JSONException {
		return jsonObject.getLong(name);
	}

	/**
	 * 获取对象类型 Long 值, 获取不到返回null。
	 * 
	 * @deprecated 如果设置默认返回值，建议使用{@link JSONObject#optLong(String )}
	 * @param name
	 * @return Long 对象，可能返回null
	 */
	@Deprecated
	public Long getLongOrNull(String name) {
		if (jsonObject.isNull(name)) {
			return null;
		}
		try {
			return jsonObject.getLong(name);
		} catch (JSONException e) {
			Log.v(JSONObjectProxy.class.getName(), e.getMessage());
			return null;
		}
	}

	public String getString(String name) throws JSONException {
		return jsonObject.getString(name);
	}

	
	/**
	 * 获取对象类型 String 值, 获取不到返回null。
	 * 
	 * @deprecated 如果设置默认返回值，建议使用{@link JSONObject#optString(String )}
	 * @param name
	 * @return String 对象，可能返回null
	 */
	@Deprecated
	public String getStringOrNull(String name) {
		if (jsonObject.isNull(name)) {
			return null;
		}
		try {
			return jsonObject.getString(name);
		} catch (JSONException e) {
			Log.v(JSONObjectProxy.class.getName(), e.getMessage());
			return null;
		}
	}

	public boolean has(String name) {
		return jsonObject.has(name);
	}

	public int hashCode() {
		return jsonObject.hashCode();
	}

	public boolean isNull(String name) {
		return jsonObject.isNull(name);
	}

	public Iterator keys() {
		return jsonObject.keys();
	}

	public int length() {
		return jsonObject.length();
	}

	public JSONArray names() {
		return jsonObject.names();
	}

	public Object opt(String name) {
		return jsonObject.opt(name);
	}

	public boolean optBoolean(String name, boolean fallback) {
		return jsonObject.optBoolean(name, fallback);
	}

	public boolean optBoolean(String name) {
		return jsonObject.optBoolean(name);
	}

	public double optDouble(String name, double fallback) {
		return jsonObject.optDouble(name, fallback);
	}

	public double optDouble(String name) {
		return jsonObject.optDouble(name);
	}

	public int optInt(String name, int fallback) {
		return jsonObject.optInt(name, fallback);
	}

	public int optInt(String name) {
		return jsonObject.optInt(name);
	}

	public JSONArray optJSONArray(String name) {
		return jsonObject.optJSONArray(name);
	}

	public JSONObject optJSONObject(String name) {
		return jsonObject.optJSONObject(name);
	}

	public long optLong(String name, long fallback) {
		return jsonObject.optLong(name, fallback);
	}

	public long optLong(String name) {
		return jsonObject.optLong(name);
	}

	public String optString(String name, String fallback) {
		return jsonObject.optString(name, fallback);
	}

	public String optString(String name) {
		return jsonObject.optString(name);
	}

	public JSONObject put(String name, boolean value) throws JSONException {
		return jsonObject.put(name, value);
	}

	public JSONObject put(String name, double value) throws JSONException {
		return jsonObject.put(name, value);
	}

	public JSONObject put(String name, int value) throws JSONException {
		return jsonObject.put(name, value);
	}

	public JSONObject put(String name, long value) throws JSONException {
		return jsonObject.put(name, value);
	}

	public JSONObject put(String name, Object value) throws JSONException {
		return jsonObject.put(name, value);
	}

	public JSONObject putOpt(String name, Object value) throws JSONException {
		return jsonObject.putOpt(name, value);
	}

	public Object remove(String name) {
		return jsonObject.remove(name);
	}

	public JSONArray toJSONArray(JSONArray names) throws JSONException {
		return jsonObject.toJSONArray(names);
	}

	public String toString() {
		return jsonObject.toString();
	}

	public String toString(int indentSpaces) throws JSONException {
		return jsonObject.toString(indentSpaces);
	}

}
