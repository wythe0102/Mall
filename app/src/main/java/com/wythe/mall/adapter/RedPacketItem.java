package com.wythe.mall.adapter;

import java.io.Serializable;

/**
 * Created by wythe on 2016/7/20.
 */
public class RedPacketItem implements Serializable{
    private String title;
    private String amount;
    private String time;

    public RedPacketItem(String title, String amount, String time) {
        this.amount = amount;
        this.time = time;
        this.title = title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
