package cn.bluesking.bank.types.concept;

import lombok.ToString;

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
