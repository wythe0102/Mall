package com.wythe.mall.adapter;

import java.io.Serializable;

/**
 * Created by wythe on 2016/7/21.
 */
public class TicketItem implements Serializable{
    private String title;
    private String amount;
    private String time;
    private String topInfo;
    private String belowInfo;

    public TicketItem(String title, String amount,String time, String topInfo, String belowInfo) {
        this.amount = amount;
        this.belowInfo = belowInfo;
        this.time = time;
        this.title = title;
        this.topInfo = topInfo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBelowInfo() {
        return belowInfo;
    }

    public void setBelowInfo(String belowInfo) {
        this.belowInfo = belowInfo;
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

    public String getTopInfo() {
        return topInfo;
    }

    public void setTopInfo(String topInfo) {
        this.topInfo = topInfo;
    }
}
