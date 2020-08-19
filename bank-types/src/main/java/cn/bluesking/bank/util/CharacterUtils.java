package cn.bluesking.bank.util;

/**
 * 常用字符操作工具类。
 * 
 * @author 随心
 * 2020年8月20日
 */
public class CharacterUtils extends UninstantiableUtils {

    private CharacterUtils() {
        super();
    }

    public static boolean isNumeric(char c) {
        return c >= '0' && c <= '9';
    }

}
