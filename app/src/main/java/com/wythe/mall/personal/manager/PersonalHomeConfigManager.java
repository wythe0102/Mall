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


public class PersonalHomeConfigManager {

    private static String TAG = "PersonalHomeConfigManager";

    private static PersonalHomeConfigManager instance;

    private long clientQueryTime;
    private Map<String, PersonalLableItem> homeConfigMap;
    private Map<String, PersonalLableItem> navigationMap;
    private PersonalLableItem guideImage;

    private PersonalHomeConfigManager(){
        clientQueryTime = 0l;
        homeConfigMap = new HashMap<String, PersonalLableItem>();
        navigationMap = new HashMap<String, PersonalLableItem>();

        // 初始化加载默认配置
        setDefaultConfig();
    }

    public static PersonalHomeConfigManager getInstance() {
        if (instance == null) {
            synchronized (PersonalHomeConfigManager.class) {
                if (instance == null) {
                    instance = new PersonalHomeConfigManager();
                }
            }
        }

        return instance;
    }

    public void setDefaultConfig() {
        try{
            JSONObject jsonObject = new JSONObject(PersonalConstants.DEFAULT_CONFIG);
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


        JSONArrayPoxy configArray = jsonObject.getJSONArrayOrNull("jdHomeConfig");
        homeConfigMap = PersonalJsonParseUtil.parseConfig(configArray);

        JSONArrayPoxy navigationArray = jsonObject.getJSONArrayOrNull("navigation");
        navigationMap = PersonalJsonParseUtil.parseNavigation(navigationArray);

        JSONArrayPoxy guideImageArray = jsonObject.getJSONArrayOrNull("guideImage");
        guideImage = PersonalJsonParseUtil.parseGuideImage(guideImageArray);
    }

    /**
     *
     * @return
     */
    public long getClientQueryTime() {
        return clientQueryTime;
    }


    public Map<String, PersonalLableItem> getHomeConfigMap() {
        return homeConfigMap;
    }

    public Map<String, PersonalLableItem> getNavigationMap() {
        return navigationMap;
    }

    public PersonalLableItem getGuideImage() {
        return guideImage;
    }

    /**
     * 获取对应配置
     * @param functionId
     * @return
     */
    public PersonalLableItem getLableItem(String functionId) {
        return homeConfigMap.get(functionId);
    }
}