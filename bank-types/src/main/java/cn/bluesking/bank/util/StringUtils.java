package cn.bluesking.bank.util;

import java.util.Objects;

/**
 * 常用字符串操作工具类。
 * 
 * @author 随心
 * 2020年8月20日
 */
public class StringUtils extends UninstantiableUtils {

    private StringUtils() {
        super();
    }

    private static boolean isBlank(String target) {
        return target.trim().length() == 0;
    }

    public static boolean isEmpty(String target) {
        return Objects.isNull(target) || isBlank(target);
    }

    public static boolean isNotEmpty(String target) {
        return !isEmpty(target);
    }

    public static boolean isNumeric(String target) {
        int length = target.length();
        for (int i = 0; i < length; i ++) {
            if (CharacterUtils.isNumeric(target.charAt(i))) {
                return true;
            }
        }
        return false;
    }

}
