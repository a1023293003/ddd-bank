package cn.bluesking.bank.types.concept;

import cn.bluesking.bank.exception.ValidationException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

/**
 * ID、Long 类型、一种不为 null 且不为负数的标识符。
 *
 * @author 随心
 * @date 2020/7/26
 */
@Getter
@ToString
@EqualsAndHashCode
public abstract class NonNegativeId {

    protected final Long id;

    public NonNegativeId(Long id) {
        isValid(id);
        this.id = id;
    }

    protected abstract String getIdName();

    protected void isValid(Long id) {
        String idName = getIdName();
        if (Objects.isNull(id)) {
            throw new ValidationException(idName + " 不能为 null！");
        }
        if (id < 0) {
            throw new ValidationException(idName + " 不能为负数！[" + id + "]");
        }
    }

}
