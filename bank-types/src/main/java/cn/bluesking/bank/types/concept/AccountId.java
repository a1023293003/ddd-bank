package cn.bluesking.bank.types.concept;

import lombok.ToString;

/**
 * 账户 ID 对象。
 *
 * @author 随心
 * @date 2020/7/25
 */
@ToString(callSuper = true)
public final class AccountId extends NonNegativeId {

    public AccountId(Long id) {
        super(id);
    }

    @Override
    protected String getIdName() {
        return "Account ID";
    }

}
