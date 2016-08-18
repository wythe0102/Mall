package com.wythe.mall.adapter;

/**
 * Created by wythe on 2016/7/17.
 */
public class MessageItem {
    private String itemColor;
    private String itemType;
    private String itemTime;
    private String itemSummary;

    public MessageItem(String itemColor, String itemType, String itemTime, String itemSummary){
        this.itemColor = itemColor;
        this.itemType =  itemType;
        this.itemTime = itemTime;
        this.itemSummary = itemSummary;
    }

    public String getItemColor() {
        return itemColor;
    }

    public void setItemColor(String itemColor) {
        this.itemColor = itemColor;
    }

    public String getItemSummary() {
        return itemSummary;
    }

    public void setItemSummary(String itemSummary) {
        this.itemSummary = itemSummary;
    }

    public String getItemTime() {
        return itemTime;
    }

    public void setItemTime(String itemTime) {
        this.itemTime = itemTime;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}
