package com.wythe.mall.personal.manager.message;

/**
 * Created by litingchang on 4/8/15.
 */
public class PersonalMessageChannel {
    public String channel = ""; // 消息类型
    public int style; // 显示类型
    public int redDot;
    public long lastReadNotice;
    public int num;
//    public String icon;

    public boolean isShowNumber() {
        return style == 0 && redDot > 0;
    }

    public boolean isShowRedDot() {
        return style == 1 && redDot > 0;
    }
}
