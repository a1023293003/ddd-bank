package cn.bluesking.bank.types.concept;

import cn.bluesking.bank.types.exception.ValidationException;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

import java.util.Objects;

/**
 * 用户 ID。
 *
 * @author 随心
 * @date 2020/7/25
 */
@ToString(callSuper = true)
public final class UserId extends NonNegativeId {

    public UserId(Long id) {
        super(id);
    }

    @Override
    protected String getIdName() {
        return "User ID";
    }

}
