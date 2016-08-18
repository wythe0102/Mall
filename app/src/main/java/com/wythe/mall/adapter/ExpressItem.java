package com.wythe.mall.adapter;

/**
 * Created by wythe on 2016/7/22.
 */
public class ExpressItem {
    private String time;
    private String imgPath;
    private String itemContent;

    public ExpressItem(String time, String imgPath, String itemContent) {
        this.time = time;
        this.itemContent = itemContent;
        this.imgPath = imgPath;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
