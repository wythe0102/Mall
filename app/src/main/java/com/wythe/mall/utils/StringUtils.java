package com.wythe.mall.utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtils {

    private static final String EMPTY_STRING = "";

    // 判断字符串是否是数字
    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]{1,}");
        Matcher matcher = pattern.matcher((CharSequence) str);
        boolean result = matcher.matches();
        return result;
    }

    //^[A-Za-z0-9]+$

    // 判断字符串是否是数字和字母
    public static boolean isNumberAndLeter(String str) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");
        Matcher matcher = pattern.matcher((CharSequence) str);
        boolean result = matcher.matches();
        return result;
    }


    private static final String normalCharRegex = "[(A-Za-z0-9\\u4E00-\\u9FA5`~!@#$%^&*()+=|{}':;',\\.\\\\<>/?~！@#￥%……&*（）——+|{}【】\\[\\]‘；：”“’。，、？《》  )]";
    //过滤掉所有非法字符
    public static String filterIllegalString(String source){
        if(!TextUtils.isEmpty(source)) {
            Matcher matcher = Pattern.compile(normalCharRegex).matcher(source);
            StringBuilder sb = new StringBuilder();
            while(matcher.find()){
                sb.append(matcher.group(0));
            }
            return sb.toString();
        }else 
            return source;
    }

	// 判断是否颜色字符串
	public static boolean isColorString(String str) {
		if (TextUtils.isEmpty(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^#([a-fA-F0-9]{2})?[a-fA-F0-9]{6}$");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

    public static String makeSafe(String s) {
        return (s == null) ? EMPTY_STRING : s;
    }

    /**
     * 转半角
     * @param input
     * @return
     */
    public static String toDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }
}
