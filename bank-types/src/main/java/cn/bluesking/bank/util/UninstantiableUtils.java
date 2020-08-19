package cn.bluesking.bank.util;

/**
 * 不可实例化的工具类。
 * 
 * @author 随心
 * 2020年8月20日
 */
class UninstantiableUtils {

    protected UninstantiableUtils() {
        throw new IllegalStateException("工具类无法实例化！");
    }

}
