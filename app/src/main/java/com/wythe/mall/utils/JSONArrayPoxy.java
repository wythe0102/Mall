package com.wythe.mall.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONArrayPoxy extends JSONArray {

	private JSONArray jsonArray;

	public JSONArrayPoxy(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}
	public JSONArrayPoxy() {
		jsonArray =  new JSONArray();
	}

	public boolean equals(Object object) {
		return jsonArray.equals(object);
	}

	public Object get(int index) throws JSONException {
		return jsonArray.get(index);
	}

	public boolean getBoolean(int index) throws JSONException {
		return jsonArray.getBoolean(index);
	}

	public double getDouble(int index) throws JSONException {
		return jsonArray.getDouble(index);
	}

	public int getInt(int index) throws JSONException {
		return jsonArray.getInt(index);
	}

	public JSONArrayPoxy getJSONArray(int index) throws JSONException {
		return new JSONArrayPoxy(jsonArray.getJSONArray(index));
	}
	
	/**
	 * 获取JSONArrayPoxy, 获取不到返回null。
	 * 
	 * @param index
	 * @return JSONArrayPoxy 对象，可能返回null
	 */
	public JSONArrayPoxy getJSONArrayOrNull(int index) {
		try {
			return new JSONArrayPoxy(jsonArray.getJSONArray(index));
		} catch (JSONException e) {
			return null;
		}
	}

	public JSONObjectProxy getJSONObject(int index) throws JSONException {
		return new JSONObjectProxy(new JSONObjectProxy(jsonArray.getJSONObject(index)));
	}

	/**
	 * 获取JSONObjectProxy, 获取不到返回null。
	 * 
	 * @param index
	 * @return JSONObjectProxy 对象，可能返回null
	 */
	public JSONObjectProxy getJSONObjectOrNull(int index) {
		try {
			return new JSONObjectProxy(new JSONObjectProxy(jsonArray.getJSONObject(index)));
		} catch (JSONException e) {
			return null;
		}
	}


	public long getLong(int index) throws JSONException {
		return jsonArray.getLong(index);
	}

	public String getString(int index) throws JSONException {
		return jsonArray.getString(index);
	}

	public int hashCode() {
		return jsonArray.hashCode();
	}

	public boolean isNull(int index) {
		return jsonArray.isNull(index);
	}

	public String join(String separator) throws JSONException {
		return jsonArray.join(separator);
	}

	public int length() {
		return jsonArray.length();
	}

	public Object opt(int index) {
		return jsonArray.opt(index);
	}

	public boolean optBoolean(int index, boolean fallback) {
		return jsonArray.optBoolean(index, fallback);
	}

	public boolean optBoolean(int index) {
		return jsonArray.optBoolean(index);
	}

	public double optDouble(int index, double fallback) {
		return jsonArray.optDouble(index, fallback);
	}

	public double optDouble(int index) {
		return jsonArray.optDouble(index);
	}

	public int optInt(int index, int fallback) {
		return jsonArray.optInt(index, fallback);
	}

	public int optInt(int index) {
		return jsonArray.optInt(index);
	}

	public JSONArray optJSONArray(int index) {
		return jsonArray.optJSONArray(index);
	}

	public JSONObject optJSONObject(int index) {
		return jsonArray.optJSONObject(index);
	}

	public long optLong(int index, long fallback) {
		return jsonArray.optLong(index, fallback);
	}

	public long optLong(int index) {
		return jsonArray.optLong(index);
	}

	public String optString(int index, String fallback) {
		return jsonArray.optString(index, fallback);
	}

	public String optString(int index) {
		return jsonArray.optString(index);
	}

	public JSONArray put(boolean value) {
		return jsonArray.put(value);
	}

	public JSONArray put(double value) throws JSONException {
		return jsonArray.put(value);
	}

	public JSONArray put(int index, boolean value) throws JSONException {
		return jsonArray.put(index, value);
	}

	public JSONArray put(int index, double value) throws JSONException {
		return jsonArray.put(index, value);
	}

	public JSONArray put(int index, int value) throws JSONException {
		return jsonArray.put(index, value);
	}

	public JSONArray put(int index, long value) throws JSONException {
		return jsonArray.put(index, value);
	}

	public JSONArray put(int index, Object value) throws JSONException {
		return jsonArray.put(index, value);
	}

	public JSONArray put(int value) {
		return jsonArray.put(value);
	}

	public JSONArray put(long value) {
		return jsonArray.put(value);
	}

	public JSONArray put(Object value) {
		return jsonArray.put(value);
	}

	public JSONObject toJSONObject(JSONArray names) throws JSONException {
		return jsonArray.toJSONObject(names);
	}

	public String toString() {
		return jsonArray.toString();
	}

	public String toString(int indentSpaces) throws JSONException {
		return jsonArray.toString(indentSpaces);
	}

}
