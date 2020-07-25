package cn.bluesking.bank.types.behavior;

import cn.bluesking.bank.types.concept.Currency;
import cn.bluesking.bank.types.context.Money;
import cn.bluesking.bank.types.exception.CurrencyNotMatchException;
import cn.bluesking.bank.types.exception.ValidationException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 汇率。
 *
 * @author 随心
 * @date 2020/7/25
 */
@Value
@Getter
public class ExchangeRate {

    private final BigDecimal rate;
    private final Currency source;
    private final Currency target;

    public ExchangeRate(BigDecimal rate, @NonNull Currency source, @NonNull Currency target) {
        isValid(rate);
        this.rate = rate;
        this.source = source;
        this.target = target;
    }

    private void isValid(BigDecimal rate) {
        if (Objects.isNull(rate)) {
            throw new ValidationException("汇率值不能为空！");
        }
        if (rate.signum() < 0) {
            throw new ValidationException("汇率值不能是负数！[" + rate.toString() + "]");
        }
    }

    public Money exchangeTo(@NonNull Money sourceMoney) {
        if (!target.equals(sourceMoney.getCurrency())) {
            throw new CurrencyNotMatchException("Source Money 货币种类和预期不符！[" + sourceMoney.toString() + "]");
        }
        BigDecimal targetAmount = sourceMoney.getAmount().multiply(rate);
        return new Money(targetAmount, target);
    }

}
