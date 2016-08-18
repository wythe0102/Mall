package com.wythe.mall.personal.manager;


import android.util.Log;

import com.wythe.mall.personal.PersonalConstants;
import com.wythe.mall.personal.PersonalLableItem;
import com.wythe.mall.utils.JSONArrayPoxy;
import com.wythe.mall.utils.JSONObjectProxy;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by litingchang on 2/5/15.
 */
public class PersonalMoreConfigManager {

    private static String TAG = PersonalMoreConfigManager.class.getSimpleName();

    private static PersonalMoreConfigManager instance;

    private long clientQueryTime;
    private Map<String, PersonalLableItem> moreConfigMap;

    private PersonalMoreConfigManager(){
        clientQueryTime = 0l;
        moreConfigMap = new HashMap<String, PersonalLableItem>();

        // 初始化加载默认配置
        setDefaultConfig();
    }

    public static PersonalMoreConfigManager getInstance() {
        if (instance == null) {
            synchronized (PersonalMoreConfigManager.class) {
                if (instance == null) {
                    instance = new PersonalMoreConfigManager();
                }
            }
        }

        return instance;
    }

    public void setDefaultConfig() {
        try{
            JSONObject jsonObject = new JSONObject(PersonalConstants.DEFAULT_CONFIG_MORE);
            parseConfig(new JSONObjectProxy(jsonObject));
        }catch (JSONException e) {
            Log.d(TAG, " parseConfig error -->> default");
        }
    }


    /**
     *
     * @param jsonObject
     */
    public void parseConfig(JSONObjectProxy jsonObject) {

        if(jsonObject.optInt("code", -1) != 0) {
            return;
        }

        // clientQueryTime
        if(jsonObject.has("clientQueryTime")) {
            clientQueryTime = jsonObject.optLong("clientQueryTime", 0l);
        }


        JSONArrayPoxy configArray = jsonObject.getJSONArrayOrNull("jdHomeMore");

        moreConfigMap = PersonalJsonParseUtil.parseConfig(configArray);

    }


    /**
     *
     * @return
     */
    public long getClientQueryTime() {
        return clientQueryTime;
    }


    public Map<String, PersonalLableItem> getMoreConfigMap() {
        return moreConfigMap;
    }

    /**
     * 获取对应配置
     * @param functionId {@see com.jingdong.common.entity.personal.PersonalConstants}
     * @return
     */
    public PersonalLableItem getLableItem(String functionId) {
        return moreConfigMap.get(functionId);
    }
}