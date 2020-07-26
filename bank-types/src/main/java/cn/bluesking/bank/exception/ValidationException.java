package cn.bluesking.bank.exception;

/**
 * 参数校验异常。
 *
 * @author 随心
 * @date 2020/7/25
 */
public class ValidationException extends IllegalArgumentException {

    public ValidationException() {
    }

    public ValidationException(String errorMessage) {
        super(errorMessage);
    }

}
