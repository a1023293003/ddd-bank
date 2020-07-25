package cn.bluesking.bank.types.concept;

import cn.bluesking.bank.types.exception.ValidationException;
import lombok.Getter;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 账户 ID 对象。
 *
 * @author 随心
 * @date 2020/7/25
 */
@Value
@Getter
public class AccountId {

    private final Long id;

    public AccountId(Long id) {
        isValid(id);
        this.id = id;
    }

    private void isValid(Long id) {
        if (Objects.isNull(id)) {
            throw new ValidationException("Account ID 不能为 null！");
        }
        if (id < 0) {
            throw new ValidationException("Account ID 不能为负数！[" + id + "]");
        }
    }

}
