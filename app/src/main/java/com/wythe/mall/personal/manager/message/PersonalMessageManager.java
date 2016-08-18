package com.wythe.mall.personal.manager.message;

import android.text.TextUtils;

import com.wythe.mall.utils.StringUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class PersonalMessageManager{

    public static final String CHANNEL_MESSAGE = "message";

    private static List<WeakReference<PersonalMessageObserver>> mObservers;

    private static String mPin;
    private static volatile PersonalMessageManager personalMessageManager;

    private static Map<String, PersonalMessageChannel> personalMessageChannelMap;

    private static JSONObject channelMap;

    private PersonalMessageManager(String pin) {
        mObservers = new ArrayList<WeakReference<PersonalMessageObserver>>();
        personalMessageChannelMap = new HashMap<String, PersonalMessageChannel>();
        mPin = pin;
    }

    /**
     *
     * @param pin 用户pin，用以区别不同用户的消息
     * @return
     */
    public static PersonalMessageManager getInstance(String pin) {

        if(personalMessageManager == null) {
            synchronized (PersonalMessageManager.class) {
                if(personalMessageManager == null) {
                    personalMessageManager = new PersonalMessageManager(StringUtils.makeSafe(pin));
                }
            }
        }

        mPin = pin;

        return personalMessageManager;
    }

    public static void registPersonalMessageObserver(final PersonalMessageObserver observer) {
        if(observer == null) {
            throw new NullPointerException("observer is null");
        }
        synchronized (mObservers) {
            Iterator<WeakReference<PersonalMessageObserver>> iterator = mObservers.iterator();
            while (iterator.hasNext()) {
                WeakReference<PersonalMessageObserver> weakReference = iterator.next();
                PersonalMessageObserver o = weakReference.get();
                if (o == observer){
                    return;
                }
            }
            mObservers.add(new WeakReference<PersonalMessageObserver>(observer));
        }
    }

    public static void deregisterPersonalMessageObserver(final PersonalMessageObserver observer) {
        if(observer == null) {
            throw new NullPointerException("observer is null");
        }
        synchronized (mObservers) {
            Iterator<WeakReference<PersonalMessageObserver>> iterator = mObservers.iterator();
            while (iterator.hasNext()) {
                WeakReference<PersonalMessageObserver> weakReference = iterator.next();
                PersonalMessageObserver o = weakReference.get();
                if (o == null || o == observer) {
                    iterator.remove();
                }
            }
        }
    }

    public static void notifyObservers() {
        try {
            synchronized (mObservers) {
                Iterator<WeakReference<PersonalMessageObserver>> iterator = mObservers.iterator();
                while (iterator.hasNext()) {
                    WeakReference<PersonalMessageObserver> weakReference = iterator.next();

                    PersonalMessageObserver observer = weakReference.get();
                    if (observer != null) {
                        observer.onPersonalMessageReceived(personalMessageChannelMap);
                    } else {
                        iterator.remove();
                    }
                }
            }
        } catch (Throwable t) {
        }
    }

    private static void parsePersonalMessage(JSONObject jsonObj) {

        JSONArray channelArray = jsonObj.optJSONArray("channels");

        personalMessageChannelMap.clear();

        if (channelArray != null && channelArray.length() > 0) {
            for (int i = 0; i < channelArray.length(); i++) {
                JSONObject channelObj = channelArray.optJSONObject(i);
                if (channelObj != null) {
                    PersonalMessageChannel channel = new PersonalMessageChannel();
                    channel.channel = channelObj.optString("channel");
                    channel.style = channelObj.optInt("style");
                    channel.redDot = channelObj.optInt("redDot");
                    channel.lastReadNotice = channelObj.optLong("lastReadNotice");
                    channel.num = channelObj.optInt("num");
                    personalMessageChannelMap.put(channel.channel, channel);
                }
            }
        }
    }

}
