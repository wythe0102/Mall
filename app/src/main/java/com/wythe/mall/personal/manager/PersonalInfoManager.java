package com.wythe.mall.personal.manager;

import android.text.TextUtils;

import com.wythe.mall.utils.JSONArrayPoxy;
import com.wythe.mall.utils.JSONObjectProxy;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class PersonalInfoManager {

    private static String TAG = "userInfoSnsManager";

    private boolean available;

    private int score;
    private boolean interview;
    private boolean isSupportCredit;
    private UserInfoSns userInfoSns;
    private List<Lable> lableList;
    private HomePage homePage;

    public PersonalInfoManager.CustomerService mCustomerService;
    public String nickName;

    private static PersonalInfoManager instance;

    private PersonalInfoManager() {
        available = false;
        userInfoSns = new UserInfoSns();
        lableList = new ArrayList<Lable>();
    }

    public static PersonalInfoManager getInstance() {
        if (instance == null) {
            synchronized (PersonalInfoManager.class) {
                if (instance == null) {
                    instance = new PersonalInfoManager();
                }
            }
        }
        return instance;
    }

    public void reset() {
        available = false;

    }


    public boolean isAvailable() {
        return available;
    }

    public int getScore() {
        if (!available) {
            throw new IllegalStateException("personal info uninitialized");
        }

        return score;
    }

    public boolean isInterview() {
        if (!available) {
            throw new IllegalStateException("personal info uninitialized");
        }

        return interview;
    }

    public boolean isSupportCredit() {
        if (!available) {
            throw new IllegalStateException("personal info uninitialized");
        }

        return isSupportCredit;
    }

    public UserInfoSns getUserInfoSns() {

        if (!available) {
            throw new IllegalStateException("personal info uninitialized");
        }

        return userInfoSns;
    }

    public List<Lable> getLablesList() {
        if (!available) {
            throw new IllegalStateException("personal info uninitialized");
        }

        return lableList;
    }

    public int getGiftCardNumber() {
        return getLableValue("giftCard");
    }

    public int getGiftECardNumber() {
        return getLableValue("giftECard");
    }

    private int getLableValue(String key) {
        if (!available) {
            throw new IllegalStateException("personal info uninitialized");
        }
        for (Lable lable : lableList) {
            if (lable.key.equals(key)) {
                return (int) lable.amount;
            }
        }

        return 0;
    }

    public void parsePersonalInfo(JSONObjectProxy jsonObject) {


        score = jsonObject.optInt("score", -1);
        interview = jsonObject.optBoolean("interview", false);
        isSupportCredit = jsonObject.optBoolean("isSupportCredit", false);

        JSONObjectProxy userInfo = jsonObject.getJSONObjectOrNull("userInfoSns");
        if (userInfo != null) {

            userInfoSns.userId = userInfo.optLong("userId");
            userInfoSns.unickName = userInfo.optString("unickName");
            userInfoSns.userName = userInfo.optString("userName");
            userInfoSns.petName = userInfo.optString("petName");
            userInfoSns.uclass = userInfo.optString("uclass");
            userInfoSns.sex = userInfo.optInt("sex", 2);
            userInfoSns.province = userInfo.optInt("province");
            userInfoSns.city = userInfo.optInt("city");
            userInfoSns.county = userInfo.optInt("county");

            userInfoSns.email = userInfo.optString("email");
            userInfoSns.lastTime = userInfo.optString("lastTime");
            userInfoSns.ipAddress = userInfo.optString("ipAddress");
            userInfoSns.regTime = userInfo.optString("regTime");
            userInfoSns.regIp = userInfo.optString("regIp");

            userInfoSns.middleSchool = userInfo.optString("middleSchool");
            userInfoSns.schoolId = userInfo.optInt("schoolId");
            userInfoSns.secoSchool = userInfo.optString("secoSchool");
            userInfoSns.schoolYn = userInfo.optInt("schoolYn");

            userInfoSns.remark = userInfo.optString("remark");
            userInfoSns.msn = userInfo.optString("msn");
            userInfoSns.birthday = userInfo.optString("birthday");
            userInfoSns.unColleger = userInfo.optString("unColleger");
            userInfoSns.companys = userInfo.optString("companys");
            userInfoSns.qq = userInfo.optString("qq");
            userInfoSns.imgUrl = userInfo.optString("imgUrl");
            userInfoSns.imgFlag = userInfo.optInt("imgFlag");

            userInfoSns.homePage = userInfo.optString("homePage");

            if (!TextUtils.isEmpty(userInfoSns.homePage)) {
                try {
                    JSONObject homePageObj = new JSONObject(userInfoSns.homePage);

                    if (homePageObj != null) {
                        homePage = new HomePage();
                        homePage.yunSmaImageUrl = homePageObj.optString("yunSmaImageUrl");
                        homePage.yunMidImageUrl = homePageObj.optString("yunMidImageUrl");
                        homePage.yunBigImageUrl = homePageObj.optString("yunBigImageUrl");
                        homePage.uclass = homePageObj.optInt("uclass");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }


        lableList.clear();
        JSONArrayPoxy labelsJsonArray = jsonObject.getJSONArrayOrNull("labels");
        if (labelsJsonArray != null) {
            int len = labelsJsonArray.length();
            for (int i = 0; i < len; ++i) {
                JSONObjectProxy labelJsonObj = labelsJsonArray.getJSONObjectOrNull(i);
                if (labelJsonObj == null) {
                    continue;
                }

                Lable lable = new Lable();
                lable.amount = labelJsonObj.optDouble("amount");
                lable.key = labelJsonObj.optString("key");
                lable.name = labelJsonObj.optString("name");

                lableList.add(lable);
            }
        }

        setNickName(jsonObject.optString("nickname", ""));

        JSONObject csObject = jsonObject.optJSONObject("customerService");
        if (csObject != null) {
            mCustomerService = new PersonalInfoManager.CustomerService(csObject);
        }

        available = true;
    }


    public static class UserInfoSns {
        public long userId;
        public String unickName;
        public String userName;
        public String petName;
        public String uclass;
        public int sex = 2; //默认值为保密   男0 女1 保密2
        public int province;
        public int city;
        public int county;
        public String email;
        public String lastTime;
        public String ipAddress;
        public String regTime;
        public String regIp;
        public String middleSchool;
        public int schoolId;
        public int schoolYn;
        public String remark;
        public String msn;
        public String birthday;
        public String unColleger;
        public String companys;
        public String secoSchool;
        public String qq;
        public String homePage;
        public String imgUrl;
        public int imgFlag;
    }

    public static class HomePage {
        public String yunMidImageUrl;
        public String yunBigImageUrl;
        public String yunSmaImageUrl;
        public int uclass;
    }

    public class Lable {
        public double amount; //数量
        public String key;
        public String name;
    }

    public static class CustomerService {

        //"customerService":{"isFloatOpen":true,"isFirstLogin":false,"url":"http:\/\/xxx.ssss","isExclusive":true}

        public boolean isFloatOpen;
        public boolean isFirstLogin;
        public boolean isExclusive;
        public String url;

        public CustomerService(JSONObject jsonobject) {
            this.isFloatOpen = jsonobject.optBoolean("isFloatOpen");
            this.isFirstLogin = jsonobject.optBoolean("isFirstLogin");
            this.isExclusive = jsonobject.optBoolean("isExclusive");
            this.url = jsonobject.optString("url");
        }


    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 昵称
     *
     * @return
     */
    public String getNickName() {
        if (TextUtils.isEmpty(nickName)) {
            return userInfoSns.unickName;
        }

        return nickName;
    }

    /**
     * 等级
     *
     * @return
     */
    public String getUclass() {
        if (TextUtils.isEmpty(userInfoSns.uclass)) {
            userInfoSns.uclass = "游客";
        }

        return userInfoSns.uclass;
    }

    public int getGender() {
        return userInfoSns.sex;
    }

    public String getAvatarUrl() {
        return userInfoSns.imgUrl;
    }

    public interface PersonalInfoRequestListener {
        public void onEnd();

        public void onError();
    }
}