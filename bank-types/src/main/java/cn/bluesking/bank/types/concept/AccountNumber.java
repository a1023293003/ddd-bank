package cn.bluesking.bank.types.concept;

import cn.bluesking.bank.types.exception.ValidationException;
import lombok.Getter;
import lombok.Value;

import java.util.Objects;

/**
 * 账户数字编号对象。
 *
 * @author 随心
 * @date 2020/7/25
 */
@Value
@Getter
public class AccountNumber {

    private final String number;

    public AccountNumber(String number) {
        isValid(number);
        this.number = number;
    }

    private void isValid(String number) {
        if (Objects.isNull(number)) {
            throw new ValidationException("Account Number 不能为 null！");
        }
        if (isNumeric(number)) {
            throw new ValidationException("Account Number 不合法！[" + number + "]");
        }
    }

    private boolean isNumeric(String number) {
        int length = number.length();
        for (int i = 0; i < length; i ++) {
            if (isNumeric(number.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumeric(char c) {
        return c >= '0' && c <= '9';
    }

}
