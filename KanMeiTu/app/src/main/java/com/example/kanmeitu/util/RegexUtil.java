package com.example.kanmeitu.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
//  匹配邮箱的正则表达式
    private final static String EMAIL_REGEX = "^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Aa-z\\d])+\\.([A-Za-z]{2,4})$";
//    匹配手机号的正则表达式
    private final static String PHONE_REGEX = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";

    /*
    * 判断邮箱是否符合规范
    * @param value
    * return
    * */
    public static boolean isEmail(String value){
        Pattern regex = Pattern.compile(EMAIL_REGEX);
        return regex.matcher(value).matches();
    }
    /*
     * 判断手机是否符合规范
     * @param value
     * return
     * */
    public static boolean isPhone(String value){
        Pattern regex = Pattern.compile(PHONE_REGEX);
        return regex.matcher(value).matches();
    }
}
