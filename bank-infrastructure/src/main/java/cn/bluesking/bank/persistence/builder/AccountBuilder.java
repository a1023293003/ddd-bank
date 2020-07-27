package cn.bluesking.bank.persistence.builder;

import cn.bluesking.bank.domain.entity.Account;
import cn.bluesking.bank.persistence.model.AccountDO;

/**
 * 银行账号对象构建器接口。
 *
 * @author 随心
 * @date 2020/7/26
 */
public interface AccountBuilder {

    Account toAccount(AccountDO accountDO);

    AccountDO fromAccount(Account account);

}
