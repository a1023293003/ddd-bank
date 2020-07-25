package cn.bluesking.bank.types.concept;

import cn.bluesking.bank.types.exception.ValidationException;
import lombok.Getter;
import lombok.Value;

import java.util.Objects;

/**
 * 用户 ID。
 *
 * @author 随心
 * @date 2020/7/25
 */
@Value
@Getter
public class UserId {

    private Long id;

    public UserId(Long id) {
        isValid(id);
        this.id = id;
    }

    private void isValid(Long id) {
        if (Objects.isNull(id)) {
            throw new ValidationException("User ID 不能为 null！");
        }
        if (id >= 0) {
            throw new ValidationException("User ID 不能为负数！[" + id + "]");
        }
    }

}
