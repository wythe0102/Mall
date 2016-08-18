package com.wythe.mall.adapter;

/**
 * Created by wythe on 2016/7/24.
 */
public class ProductGridItem {
    private String imgPath1;
    private String price1;
    private String title1;
    private String imgPath2;
    private String price2;
    private String title2;

    public ProductGridItem(String imgPath1, String title1, String price1, String imgPath2, String title2, String price2) {
        this.imgPath1 = imgPath1;
        this.imgPath2 = imgPath2;
        this.price1 = price1;
        this.price2 = price2;
        this.title1 = title1;
        this.title2 = title2;
    }

    public String getImgPath1() {
        return imgPath1;
    }

    public void setImgPath1(String imgPath1) {
        this.imgPath1 = imgPath1;
    }

    public String getImgPath2() {
        return imgPath2;
    }

    public void setImgPath2(String imgPath2) {
        this.imgPath2 = imgPath2;
    }

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }
}
