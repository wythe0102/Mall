package com.wythe.mall.utils;

/**
 * Created by wythe on 2016/7/8.
 */
public class UserManager {
    private String username;
    private String phone;
    private String userId;
    private boolean isLogin = false;
    private UserManager userManager;

    private UserManager(){ }

    public static UserManager getInstance()
    {
        return Nested.instance;
    }

    //在第一次被引用时被加载
    static class Nested
    {
        private static UserManager instance = new UserManager();
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
