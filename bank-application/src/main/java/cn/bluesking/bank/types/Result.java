package cn.bluesking.bank.types;

import lombok.Value;

/**
 * 调用服务返回的结果对象。
 *
 * @author 随心
 * @date 2020/7/26
 */
@Value
public final class Result<T> {

    private final boolean success;
    private final String message;
    private final T data;

    public Result(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(true, null, data);
    }

}
