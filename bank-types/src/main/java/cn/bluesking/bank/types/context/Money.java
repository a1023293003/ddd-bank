package cn.bluesking.bank.types.context;

import cn.bluesking.bank.types.concept.Currency;
import cn.bluesking.bank.types.exception.ValidationException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 钱、一般等价物、交易的媒介。
 *
 * @author 随心
 * @date 2020/7/25
 */
@Value
@Getter
public class Money {

    private final BigDecimal amount;
    private final Currency currency;

    public Money(BigDecimal amount, @NonNull Currency currency) {
        isValid(amount);
        this.amount = amount;
        this.currency = currency;
    }

    private void isValid(BigDecimal amount) {
        if (Objects.isNull(amount)) {
            throw new ValidationException("Money Amount 不能为 null！");
        }
    }

}
