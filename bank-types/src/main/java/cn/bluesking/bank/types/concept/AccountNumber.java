package cn.bluesking.bank.types.concept;

import cn.bluesking.bank.util.StringUtils;
import cn.bluesking.bank.util.ValidationUtils;
import lombok.Getter;
import lombok.Value;

/**
 * 账户数字编号对象。
 *
 * @author 随心
 * @date 2020/7/25
 */
@Value
@Getter
public final class AccountNumber {

    private final String number;

    public AccountNumber(String number) {
        isValid(number);
        this.number = number;
    }

    private void isValid(String number) {
        ValidationUtils.assertNotNull(number, "Account Number 不能为 null！");
        ValidationUtils.assertTrue(StringUtils.isNumeric(number), () -> "Account Number 不合法！[" + number + "]");
    }



}
