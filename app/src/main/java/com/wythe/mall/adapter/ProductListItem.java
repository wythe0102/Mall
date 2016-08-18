package com.wythe.mall.adapter;

/**
 * Created by wythe on 2016/7/24.
 */
public class ProductListItem {
    private String imgPath;
    private String title;
    private String price;
    private String info;

    public ProductListItem(String imgPath, String title, String price, String info) {
        this.imgPath = imgPath;
        this.info = info;
        this.price = price;
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
