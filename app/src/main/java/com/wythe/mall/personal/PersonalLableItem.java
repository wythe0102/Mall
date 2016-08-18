package com.wythe.mall.personal;

import java.util.List;


public class PersonalLableItem implements Comparable<PersonalLableItem>{

    public String lableName;
    public String lableImage;
    public int newIconNum;
    public String functionId;
    public int sort;
    public String next;
    public String mUrl;
    public String iconStyle;
    public String action;
    public String platList;
    public String clientVersion;
    public String type;
    public String apkUrl;
    public String content;
    public String title;
    public int componentType;
    public boolean reddotflag;
    public long reddotversion;
    public String color;

    public List<List<PersonalLableItem>> childLableItems;
    public List<PersonalLableItem> showLableItems;

    // 供下级页面用
    public String childLableitemJson;

    public PersonalLableItem getShowLableItem(String functionId) {

        for (PersonalLableItem item : showLableItems) {
            if(item.functionId.equals(functionId)) {
                return item;
            }
        }

        return null;
    }

    public PersonalLableItem getChildLableItem(String functionId) {

        for (List<PersonalLableItem> itemList : childLableItems) {
            for (PersonalLableItem item : itemList) {
                if(item.functionId.equals(functionId)) {
                    return item;
                }
            }
        }

        return null;
    }


    @Override
    public int compareTo(PersonalLableItem another) {
        if(another == null) {
            return 0;
        }
        return this.sort - another.sort;
    }
}
