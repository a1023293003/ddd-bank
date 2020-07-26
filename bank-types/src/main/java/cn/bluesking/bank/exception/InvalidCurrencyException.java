package cn.bluesking.bank.exception;

/**
 * 货币种类不匹配异常。
 *
 * @author 随心
 * @date 2020/7/25
 */
public class CurrencyNotMatchException extends ValidationException {

    public CurrencyNotMatchException(String errorMessage) {
        super(errorMessage);
    }

}
