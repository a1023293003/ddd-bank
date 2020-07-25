package cn.bluesking.bank.types.concept;

import cn.bluesking.bank.types.exception.ValidationException;
import lombok.Getter;
import lombok.Value;

import java.util.Objects;

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

    public Currency(String value) {
        iaValid(value);
        this.value = value;
    }

    private void iaValid(String value) {
        if (Objects.isNull(value) || "".equals(value)) {
            throw new ValidationException("货币种类不能为空！");
        }
    }

}
