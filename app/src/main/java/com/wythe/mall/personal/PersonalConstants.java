package com.wythe.mall.personal;

/**
 * Created by litingchang on 2/5/15.
 */
public class PersonalConstants {

    // 京东入口
    public static final String FUNCTION_ID_USERIMAGE = "userimage"; // 个人信息

    public static final String FUNCTION_ID_ACTIVITY = "jdactivity"; // 京东活动
    public static final String FUNCTION_ID_PROMOTION = "jdpromotion"; //


    public static final String FUNCTION_ID_DINGDANCHAXUN = "dingdanchaxun"; // 订单查询
    public static final String FUNCTION_ID_DAIFUKUAN = "daifukuan"; //待付款
    public static final String FUNCTION_ID_DAISHOUHUO = "daishouhuo"; // 待收货
    public static final String FUNCTION_ID_DAIPINGJIA = "daipingjia"; // 待评价
    public static final String FUNCTION_ID_FANXIU_TUIHUO = "fanxiutuihuo"; // 返修/退货
    public static final String FUNCTION_ID_YIQUXIAO = "yiquxiao"; // 已取消

    public static final String FUNCTION_ID_WODEQIANBAO = "wodeqianbao"; // 我的钱包
    public static final String FUNCTION_ID_ZHANGHUYUE = "zhanghuyue"; // 账户余额
    public static final String FUNCTION_ID_YOUHUIQUAN = "youhuiquan"; // 优惠券
    public static final String FUNCTION_ID_JINGDOU = "jindou"; // 京豆
    public static final String FUNCTION_ID_JINGDONGKA = "jingdongka"; // 京东卡
    public static final String FUNCTION_ID_XIAOJINKU = "xiaojinku"; // 小金库
    public static final String FUNCTION_ID_BAITIAO = "wodebaitiao"; // 白条

    public static final String FUNCTION_ID_WODEFUWU = "wodefuwu"; // 我的服务
    public static final String FUNCTION_ID_WODETEQUAN = "wodetequan"; // 我的特权
    public static final String FUNCTION_ID_YIJIANFANKUI = "yijianfankui"; // 意见反馈

    public static final String FUNCTION_ID_LIULANJILU = "liulanjilu"; // 浏览记录
    public static final String FUNCTION_ID_WODEGUANZHU = "wodeguanzhu"; // 我的关注
    public static final String FUNCTION_ID_WISH_WARE = "followWareCount"; // 我的关注-店铺
    public static final String FUNCTION_ID_WISH_VENDEOR = "followVendorCount"; // 我的关注
    public static final String FUNCTION_ID_SHOP_NEWS = "dianpudongtai"; // 我的关注
    public static final String FUNCTION_ID_WODEXIAOXI = "wodexiaoxi"; // 我的消息


    public static final String FUNCTION_ID_WODEYUYUE = "wodeyuyue"; // 我的预约
    public static final String FUNCTION_ID_PINGJIASHAIDAN = "pingjiashaidan"; // 评价晒单
    public static final String FUNCTION_ID_ZHANGHUGUANLI = "zhanghuguanli"; // 账户管理
    public static final String FUNCTION_ID_FUWUGUANJIA = "fuwuguanjia"; // 服务管家
    public static final String FUNCTION_ID_TIEXINGONGNENG = "tiexinfuwu"; // 贴心服务

    public static final String FUNCTION_ID_JDNOW = "jdnow"; // 京东来点

    //我的订单部分functionIds
    public static final String FUNCTION_ID_ALL = "newUserAllOrderList";//全部订单
    public static final String FUNCTION_ID_SEARCH = "searchOrder";//搜索订单
    public static final String FUNCTION_ID_4PAYING = "wait4Payment";//待支付
    public static final String FUNCTION_ID_4ACCETPING = "wait4Delivery";//待收货
    public static final String FUNCTION_ID_4EVALUATING = "wait4Evaluate";//待评价
    public static final String FUNCTION_ID_CANCEL = "canceledOrderList";//已取消

    // 设置按钮
    public static final String FUNCTION_ID_SETTING = "shezhi";

    //订单列表标题
    public static final String ORDER_LIST_TITLE_ALL = "全部订单";
    public static final String ORDER_LIST_TITLE_4PAYING = "待付款";
    public static final String ORDER_LIST_TITLE_4ACCEPTING = "待收货";
    public static final String ORDER_LIST_TITLE_4EVALUATING = "待评价";
    public static final String ORDER_LIST_TITLE_CANCEL = "已取消订单";

    // 详情页类型(埋点)
    public static final String ORDER_DETAIL_NORMAL = "1";// 正常订单
    public static final String ORDER_DETAIL_CANCEL = "2";// 已取消订单
    public static final String ORDER_DETAIL_SEARCH = "3";// 搜索订单

    // 更多-关于页面
    public static final String FUNCTION_ID_YINGYONGTUIJIAN = "yingyongtuijian";//应用推荐
    public static final String FUNCTION_ID_GUANYU = "guanyu";// 关于
    public static final String FUNCTION_ID_CHECK_UPDATE = "jiancegengxin";// 检查更新
    public static final String FUNCTION_ID_HELP = "shiyongbangzhu";//帮助

    // 更多入口
    public static final String MORE_ENTRY_SETUP = "shezhi"; // 设置
    public static final String MORE_ENTRY_HOST_SETUP = "CBTMODE"; // 服务器设置
    public static final String MORE_ENTRY_APP_RECOMMOND = "yingyongtuijian"; // 应用推荐
    public static final String MORE_ENTRY_JD_NEWS = "jingdongkuaibao"; // 京东快报
    public static final String MORE_ENTRY_HELP = ""; // 使用帮助
    public static final String MORE_ENTRY_FEEDBACK = "yijianfankui"; // 意见反馈
    public static final String MORE_ENTRY_CHECK_UPDATE = "jiancegengxin"; // 检测更新
    public static final String MORE_ENTRY_ABOUT = "guanyu"; // 关于
    public static final String MORE_ENTRY_DELIVERY = "yaoqingyouli"; // 邀请有礼

    // 图标样式
    public static final String ICON_STYLE_NEW = "new";
    public static final String ICON_STYLE_POINT = "point";
    public static final String ICON_STYLE_N = "n";


    public static final String DEFAULT_BG = "personal_default_bg";

    //订单国际站标识常量
    public static final int INTERNATIONAL_TYPE_NONE = 0;
    public static final int INTERNATIONAL_TYPE_INTERNATIONAL = 1;
    public static final int INTERNATIONAL_TYPE_EBAY = 2;

    //订单类型，0-普通订单，1-预售订单，2-国际站订单，不能为空
    public static final String ORDER_TYPE_CODE_NOEMAL = "0";
    public static final String ORDER_TYPE_CODE_PRESALE = "1";
    public static final String ORDER_TYPE_CODE_INTERNATIONAL = "2";

    //ERP订单类型，0-普通订单(预售订单，国际站订单都认为是普通订单) 37-充值订单，不能为空
    public static final String ORDER_TYPE_NORMAL = "0";
    public static final String ORDER_TYPE_CHARGE = "37";

    //my618 start
    public static final String INTENT_KEY_TITLE = "title";
    public static final String INTENT_KEY_NEED_CONTINUE = "need_continue";
    //my618 end

    // 默认配置
    public static final String DEFAULT_CONFIG = "{\"clientQueryTime\":0,\"jdHomeConfig\":[[{\"lableName\":\"背景图片\",\"componentType\":3,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"userimage\",\"sort\":1,\"next\":\"2\",\"iconStyle\":\"\",\"platList\":\"apple#android\",\"chindItem\":[[{\"lableName\":\"地址管理\",\"componentType\":0,\"lableImage\":\"\",\"functionId\":\"dizhiguanli\",\"sort\":1,\"next\":\"1\",\"mUrl\":\"\",\"action\":\"\",\"platList\":\"apple#android\"},{\"lableName\":\"账户安全(可修改密码)\",\"componentType\":0,\"lableImage\":\"\",\"functionId\":\"zhanghuanquan\",\"sort\":2,\"next\":\"0\",\"mUrl\":\"http://m.360buy.com/user/apppay.action\",\"action\":\"to\",\"platList\":\"apple#android\"}]],\"content\":\"账户管理、收货地址\"}],[{\"lableName\":\"我的订单\",\"componentType\":2,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"dingdanchaxun\",\"sort\":1,\"next\":\"1\",\"iconStyle\":\"\",\"platList\":\"apple#android\",\"showItem\":[{\"lableName\":\"待付款\",\"componentType\":0,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"daifukuan\",\"sort\":1,\"next\":\"1\",\"iconStyle\":\"\",\"platList\":\"apple#android\"},{\"lableName\":\"待收货\",\"componentType\":0,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"daishouhuo\",\"sort\":2,\"next\":\"1\",\"iconStyle\":\"\",\"platList\":\"apple#android\"},{\"lableName\":\"待评价\",\"componentType\":0,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"daipingjia\",\"sort\":3,\"next\":\"1\",\"iconStyle\":\"\",\"platList\":\"apple#android\"},{\"lableName\":\"返修/退换\",\"componentType\":0,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"fanxiutuihuo\",\"sort\":4,\"next\":\"0\",\"mUrl\":\"http://m.mrd.jd.com/afs/orders\",\"action\":\"to\",\"platList\":\"apple#android\"}],\"content\":\"查看全部订单\"}],[{\"lableName\":\"我的钱包\",\"componentType\":1,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"wodeqianbao\",\"sort\":2,\"next\":\"2\",\"iconStyle\":\"\",\"platList\":\"apple#android\",\"chindItem\":[[{\"lableName\":\"账户余额\",\"componentType\":0,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"zhanghuyue\",\"sort\":1,\"next\":\"0\",\"mUrl\":\"http://m.jd.com/user/balance.action\",\"iconStyle\":\"\",\"action\":\"to\",\"platList\":\"apple#android\"},{\"lableName\":\"优惠券\",\"componentType\":0,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"youhuiquan\",\"sort\":2,\"next\":\"1\",\"iconStyle\":\"\",\"platList\":\"apple#android\"},{\"lableName\":\"京豆\",\"componentType\":0,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"jindou\",\"sort\":3,\"next\":\"0\",\"mUrl\":\"http://m.jd.com/user/jingBeanBalance.action\",\"iconStyle\":\"\",\"action\":\"to\",\"platList\":\"apple#android\"},{\"lableName\":\"京东卡/E卡\",\"componentType\":0,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"jingdongka\",\"sort\":4,\"next\":\"1\",\"iconStyle\":\"\",\"platList\":\"apple#android\"}],[{\"lableName\":\"小金库（支持转入转出）\",\"componentType\":0,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"xiaojinku\",\"sort\":2,\"next\":\"0\",\"mUrl\":\"https://jrapp.jd.com/s/redirect.action\",\"iconStyle\":\"\",\"action\":\"to\",\"platList\":\"apple#android\"},{\"lableName\":\"京东白条\",\"componentType\":0,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"wodebaitiao\",\"sort\":1,\"next\":\"0\",\"mUrl\":\"http://s.jr.jd.com/baitiaoRepayment_v3/index.action\",\"iconStyle\":\"\",\"action\":\"to\",\"platList\":\"apple#android\"}]],\"showItem\":[{\"lableName\":\"账户余额\",\"componentType\":0,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"zhanghuyue\",\"sort\":1,\"next\":\"0\",\"mUrl\":\"http://m.jd.com/user/balance.action\",\"iconStyle\":\"\",\"action\":\"to\",\"platList\":\"apple#android\"},{\"lableName\":\"优惠券\",\"componentType\":0,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"youhuiquan\",\"sort\":2,\"next\":\"1\",\"iconStyle\":\"\",\"platList\":\"apple#android\"},{\"lableName\":\"京豆\",\"componentType\":0,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"jindou\",\"sort\":3,\"next\":\"0\",\"mUrl\":\"http://m.jd.com/user/jingBeanBalance.action\",\"iconStyle\":\"\",\"action\":\"to\",\"platList\":\"apple#android\"},{\"lableName\":\"京东卡/E卡\",\"componentType\":0,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"jingdongka\",\"sort\":4,\"next\":\"1\",\"iconStyle\":\"\",\"platList\":\"apple#android\"}],\"content\":\"小金库、白条等\"}],[{\"lableName\":\"我的服务\",\"componentType\":0,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"wodefuwu\",\"sort\":1,\"next\":\"2\",\"mUrl\":\"\",\"iconStyle\":\"\",\"action\":\"to\",\"platList\":\"apple#android\",\"chindItem\":[[{\"lableName\":\"JIMI智能机器人\",\"componentType\":0,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"jimjiqi\",\"sort\":2,\"next\":\"1\",\"mUrl\":\"\",\"iconStyle\":\"\",\"action\":\"\",\"platList\":\"apple#android\",\"type\":\"cd_jimi\"},{\"lableName\":\"京东客服\",\"componentType\":0,\"lableImage\":\"\",\"newIconNum\":0,\"functionId\":\"zaixiankefu\",\"sort\":3,\"next\":\"1\",\"mUrl\":\"http://im.m.jd.com/after/category.action\",\"iconStyle\":\"\",\"action\":\"to\",\"platList\":\"apple#android\",\"type\":\"cd_im\",\"apkUrl\":\"http://chat.jd.com/download/apk-sdk\",\"content\":\"\",\"title\":\"新版京东客服发布了！\"},{\"lableName\":\"电话预约服务\",\"componentType\":0,\"lableImage\":\"\",\"functionId\":\"dianhuayuyue\",\"sort\":4,\"next\":\"0\",\"mUrl\":\"http://m.mrd.jd.com/tbis/book\",\"action\":\"to\",\"platList\":\"apple#android\",\"type\":\"m\"},{\"lableName\":\"配送服务查询\",\"componentType\":0,\"lableImage\":\"\",\"functionId\":\"peisongfuwu\",\"sort\":5,\"next\":\"0\",\"mUrl\":\"http://m.mrd.jd.com/promise/delivery\",\"action\":\"to\",\"platList\":\"apple#android\",\"type\":\"m\"}]],\"content\":\"京东客服等\"},{\"lableName\":\"京东会员\",\"componentType\":0,\"lableImage\":\"\",\"functionId\":\"wodetequan\",\"sort\":1,\"next\":\"0\",\"mUrl\":\"http://h5.m.jd.com/active/member/html/index.html?sid=\",\"action\":\"to\",\"platList\":\"apple#android\",\"type\":\"m\",\"content\":\"会员俱乐部\"}],[{\"lableName\":\"意见反馈\",\"componentType\":0,\"lableImage\":\"\",\"functionId\":\"yijianfankui\",\"sort\":1,\"next\":\"1\",\"platList\":\"apple#android\"}]],\"code\":\"0\"}";
    public static final String DEFAULT_CONFIG_MORE = "{\"jdHomeMore\":[[{\"lableName\":\"应用推荐\",\"componentType\":0,\"lableImage\":\"http://img30.360buyimg.com/mobilecms/g14/M08/15/02/rBEhV1MW0_gIAAAAAAAVgR0DpV4AAJnDgIy8eAAABWZ097.jpg\",\"functionId\":\"yingyongtuijian\",\"sort\":1,\"next\":\"0\",\"mUrl\":\"http://m.jd.com/download/androidInner.html?v=t\",\"platList\":\"apple#android\"},{\"lableName\":\"关于\",\"componentType\":0,\"lableImage\":\"http://img30.360buyimg.com/mobilecms/g14/M02/15/02/rBEhV1MW0HkIAAAAAAAU10K0mowAAJm9AOOQlIAABTv354.jpg\",\"functionId\":\"guanyu\",\"sort\":2,\"next\":\"1\",\"platList\":\"apple#android\",\"chindItem\":[[{\"lableName\":\"检测更新\",\"componentType\":0,\"lableImage\":\"http://img30.360buyimg.com/mobilecms/g13/M04/19/19/rBEhU1MW0JoIAAAAAAAT-O7ieWwAAJgRwFD0WgAABQQ756.jpg\",\"functionId\":\"jiancegengxin\",\"sort\":1,\"next\":\"1\",\"platList\":\"apple#android\"},{\"lableName\":\"使用帮助\",\"componentType\":0,\"lableImage\":\"http://img30.360buyimg.com/mobilecms/g13/M05/19/19/rBEhVFMW0SkIAAAAAAAWBD_1-VMAAJgSQP_4N4AABYc001.jpg\",\"functionId\":\"shiyongbangzhu\",\"sort\":2,\"next\":\"0\",\"mUrl\":\"http://m.360buy.com/help/app/\",\"action\":\"\",\"platList\":\"apple#android\"},{\"lableName\":\"给我评分\",\"componentType\":0,\"lableImage\":\"http://img30.360buyimg.com/mobilecms/g15/M09/0A/0A/rBEhWFMW0FQIAAAAAAASe4WidOgAAJeXQBIMqcAABKT127.jpg\",\"functionId\":\"geiwopingfen\",\"sort\":3,\"next\":\"1\",\"platList\":\"apple\"}]]}]],\"clientQueryTime\":0,\"code\":\"0\"}";

    // 展示平台
    public static final String PLAT_LIST_ANDROID = "android";

}