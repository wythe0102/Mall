package com.wythe.mall.personal.manager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by litingchang on 2/11/15.
 */
public class PersonalRedDotmanager {

    private static int flag;
    private static long lastTime;

    public static Map<String, Channel> channelMap;

    private static PersonalRedDotmanager instance;

    private PersonalRedDotmanager() {
        channelMap = new HashMap<String, Channel>();
    }

    public static PersonalRedDotmanager getInstance() {
        if(instance == null) {
            synchronized (PersonalRedDotmanager.class) {
                if (instance == null) {
                    instance = new PersonalRedDotmanager();
                }
            }
        }
        return instance;
    }

    public void parseConfig(JSONObject jsonObject) {

        flag = jsonObject.optInt("redDot");
        lastTime = jsonObject.optLong("lastTime");

        JSONArray channelArray = jsonObject.optJSONArray("channels");


        if (channelArray != null && channelArray.length() > 0) {
            for (int i = 0; i < channelArray.length(); i++) {
                JSONObject channelObj = channelArray.optJSONObject(i);
                if (channelObj != null) {
                    Channel channel = new Channel();
                    channel.channel = channelObj.optString("channel");
                    channel.level = channelObj.optInt("level");
                    channel.redDot = channelObj.optInt("redDot");
                    channel.lastReadNotice = channelObj.optLong("lastReadNotice");
                    channel.icon = channelObj.optString("icon");
                    channel.num = channelObj.optInt("num");
                    channelMap.put(channel.channel, channel);
                }
            }
        }
    }

    private void saveData() {

    }

    public static class Channel {
        private String channel;
        private long lastReadNotice;
        private int num;
        private int level;
        private String icon;
        private int redDot;
    }

}
