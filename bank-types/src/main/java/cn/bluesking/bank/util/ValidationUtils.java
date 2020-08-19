package cn.bluesking.bank.util;

import java.util.Objects;
import java.util.function.Supplier;

import cn.bluesking.bank.exception.ValidationException;

/**
 * 参数验证工具类。
 * 
 * @author 随心
 * 2020年8月20日
 */
public class ValidationUtils extends UninstantiableUtils {

    private ValidationUtils() {
        super();
    }

    public static void validationFailed(String message) {
        throw new ValidationException(message);
    }

    public static void validationFailed(Supplier<String> messageSupplier) {
        throw new ValidationException(messageSupplier.get());
    }

    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            validationFailed(message);
        }
    }

    public static void assertTrue(boolean condition, Supplier<String> messageSupplier) {
        if (!condition) {
            validationFailed(messageSupplier);
        }
    }

    public static void assertFalse(boolean condition, String message) {
        if (condition) {
            validationFailed(message);
        }
    }

    public static void assertFalse(boolean condition, Supplier<String> messageSupplier) {
        if (condition) {
            validationFailed(messageSupplier);
        }
    }

    public static void assertNotNull(Object target, String message) {
        if (Objects.isNull(target)) {
            validationFailed(message);
        }
    }

    public static void assertNotNull(Object target, Supplier<String> messageSupplier) {
        if (Objects.isNull(target)) {
            validationFailed(messageSupplier);
        }
    }

    public static void assertNull(Object target, String message) {
        if (Objects.nonNull(target)) {
            validationFailed(message);
        }
    }

    public static void assertNull(Object target, Supplier<String> messageSupplier) {
        if (Objects.nonNull(target)) {
            validationFailed(messageSupplier);
        }
    }
    
    public static void assertNotEmpty(String target, String message) {
        if (StringUtils.isEmpty(target)) {
            validationFailed(message);
        }
    }

    public static void assertNotEmpty(String target, Supplier<String> messageSupplier) {
        if (StringUtils.isEmpty(target)) {
            validationFailed(messageSupplier);
        }
    }

    public static void assertEmpty(String target, String message) {
        if (StringUtils.isNotEmpty(target)) {
            validationFailed(message);
        }
    }

    public static void assertEmpty(String target, Supplier<String> messageSupplier) {
        if (StringUtils.isNotEmpty(target)) {
            validationFailed(messageSupplier);
        }
    }

}
