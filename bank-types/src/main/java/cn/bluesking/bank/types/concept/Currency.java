package cn.bluesking.bank.types.concept;

import cn.bluesking.bank.util.ValidationUtils;
import lombok.Getter;
import lombok.Value;

/**
 * 货币种类。
 *
 * @author 随心
 * @date 2020/7/25
 */
@Value
@Getter
public final class Currency {

    private final String value;

    public Currency(String currency) {
        iaValid(currency);
        this.value = currency;
    }

    private void iaValid(String currency) {
        ValidationUtils.assertNotEmpty(currency, "货币种类不能为空！");
    }

}
