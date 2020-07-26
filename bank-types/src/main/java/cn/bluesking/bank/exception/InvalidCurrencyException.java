package cn.bluesking.bank.exception;

/**
 * 无效货币种类异常。
 *
 * @author 随心
 * @date 2020/7/25
 */
public class InvalidCurrencyException extends ValidationException {

    public InvalidCurrencyException() {
    }

    public InvalidCurrencyException(String errorMessage) {
        super(errorMessage);
    }

}
