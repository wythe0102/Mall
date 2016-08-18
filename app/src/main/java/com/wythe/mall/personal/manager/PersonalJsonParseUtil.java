package com.wythe.mall.personal.manager;

import android.text.TextUtils;
import android.util.Log;


import com.wythe.mall.personal.PersonalLableItem;
import com.wythe.mall.utils.JSONArrayPoxy;
import com.wythe.mall.utils.JSONObjectProxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PersonalJsonParseUtil {

    private static final String TAG = PersonalJsonParseUtil.class.getSimpleName();

    private static PersonalLableItem parseLableItem(JSONObjectProxy jsonObjectProxy) {

        PersonalLableItem lableItem = new PersonalLableItem();

        lableItem.lableName = jsonObjectProxy.optString("lableName");
        lableItem.lableImage =  jsonObjectProxy.optString("lableImage");
        lableItem.newIconNum =  jsonObjectProxy.optInt("newIconNum");
        lableItem.functionId =  jsonObjectProxy.optString("functionId");
        lableItem.sort =  jsonObjectProxy.optInt("sort");
        lableItem.next =  jsonObjectProxy.optString("next");
        lableItem.mUrl =  jsonObjectProxy.optString("mUrl");
        lableItem.iconStyle =  jsonObjectProxy.optString("iconStyle");
        lableItem.action =  jsonObjectProxy.optString("action");
        lableItem.platList =  jsonObjectProxy.optString("platList");
        lableItem.clientVersion =  jsonObjectProxy.optString("clientVersion");
        lableItem.type =  jsonObjectProxy.optString("type");
        lableItem.apkUrl =  jsonObjectProxy.optString("apkUrl");
        lableItem.content =  jsonObjectProxy.optString("content");
        lableItem.title =  jsonObjectProxy.optString("title");
        lableItem.componentType = jsonObjectProxy.optInt("componentType");
        lableItem.reddotflag = jsonObjectProxy.optInt("reddotflag", 0) == 0 ? false : true;
        lableItem.reddotversion = jsonObjectProxy.optLong("reddotversion");
        lableItem.color = jsonObjectProxy.optString("color");

        return lableItem;
    }


    public static Map<String, PersonalLableItem> parseConfig(JSONArrayPoxy configArray) {

        Map<String, PersonalLableItem> configMap = new HashMap<String, PersonalLableItem>();

        if(configArray == null) {
            Log.d(TAG, " parseConfig error -->> jdHomeConfig null");
            return configMap;
        }

        int configArrayLen = configArray.length();
        if(configArrayLen == 0) {
            Log.d(TAG, " parseConfig error -->> jdHomeConfig length 0");
            return configMap;
        }

        for (int i = 0; i < configArrayLen; ++i) {
            JSONArrayPoxy configItemArray = configArray.getJSONArrayOrNull(i);
            if(configItemArray == null || configItemArray.length() == 0) {
                continue;
            }

            for (int j = 0; j < configItemArray.length(); ++j) {
                JSONObjectProxy configItem = configItemArray.getJSONObjectOrNull(j);
                if(configItem == null) {
                    continue;
                }

                PersonalLableItem personalLableItem = parseLableItem(configItem);

                if(configItem.has("chindItem")) {
                    personalLableItem.childLableItems = new ArrayList<List<PersonalLableItem>>();
                    JSONArrayPoxy childItemArray = configItem.getJSONArrayOrNull("chindItem");

                    if (childItemArray != null && childItemArray.length() > 0) {
                        personalLableItem.childLableitemJson = childItemArray.toString();

                        for (int k = 0; k < childItemArray.length(); ++k) {
                            List<PersonalLableItem> childArray = new ArrayList<PersonalLableItem>();
                            JSONArrayPoxy childInnerItemArray = childItemArray.getJSONArrayOrNull(k);
                            if(childInnerItemArray != null && childInnerItemArray.length() > 0) {
                                for (int m = 0; m < childInnerItemArray.length(); ++m) {

                                    JSONObjectProxy childJsonProxy = childInnerItemArray.getJSONObjectOrNull(m);
                                    if (childJsonProxy == null) {
                                        continue;
                                    }
                                    PersonalLableItem childItem = parseLableItem(childJsonProxy);
                                    childArray.add(childItem);
                                }
                                Collections.sort(childArray);
                            }

                            if (childArray.size() > 0) {
                                personalLableItem.childLableItems.add(childArray);
                            }
                        }

                    }
                }

                if(configItem.has("showItem")) {
                    personalLableItem.showLableItems = new ArrayList<PersonalLableItem>();
                    JSONArrayPoxy showItemArray = configItem.getJSONArrayOrNull("showItem");

                    if(showItemArray != null && showItemArray.length() > 0) {
                        for (int l = 0; l < showItemArray.length(); ++l) {

                            JSONObjectProxy showJsonProxy = showItemArray.getJSONObjectOrNull(l);
                            if(showJsonProxy == null) {
                                continue;
                            }
                            PersonalLableItem showItem = parseLableItem(showJsonProxy);

                            personalLableItem.showLableItems.add(showItem);
                        }

                        Collections.sort(personalLableItem.showLableItems);
                    }
                }

                configMap.put(personalLableItem.functionId, personalLableItem);
            }
        }

        return configMap;
    }

    public static Map<String, PersonalLableItem> parseNavigation(JSONArrayPoxy configArray) {

        Map<String, PersonalLableItem> configMap = new HashMap<String, PersonalLableItem>();

        if(configArray == null) {
            Log.d(TAG, " parseConfig error -->> jdHomeConfig null");
            return configMap;
        }

        int configArrayLen = configArray.length();
        if(configArrayLen == 0) {
            Log.d(TAG, " parseConfig error -->> jdHomeConfig length 0");
            return configMap;
        }

        for (int i = 0; i < configArrayLen; ++i) {
            JSONObjectProxy configItem = configArray.getJSONObjectOrNull(i);
            if(configItem == null) {
                continue;
            }

            PersonalLableItem personalLableItem = parseLableItem(configItem);

            configMap.put(personalLableItem.functionId, personalLableItem);
        }

        return configMap;
    }

    public static PersonalLableItem parseGuideImage(JSONArrayPoxy configArray) {

        PersonalLableItem item = null;

        if(configArray == null) {
            return null;
        }

        int configArrayLen = configArray.length();
        if(configArrayLen == 0) {
            return null;
        }

        for (int i = 0; i < configArrayLen; ++i) {
            JSONObjectProxy configItem = configArray.getJSONObjectOrNull(i);
            if(configItem == null) {
                continue;
            }

            PersonalLableItem temp = parseLableItem(configItem);
            if(!TextUtils.isEmpty(temp.lableImage) && temp.platList.contains("android")) {
                item = temp;
                break;
            }
        }

        return item;
    }

}
