package com.wythe.mall.personal.manager.message;

import java.util.Map;


public interface PersonalMessageObserver {
    void onPersonalMessageReceived(final Map<String, PersonalMessageChannel> channelMap);
}
