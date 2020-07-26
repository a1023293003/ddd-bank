package cn.bluesking.bank.repository;

import cn.bluesking.bank.domain.entity.Account;
import cn.bluesking.bank.types.concept.AccountId;
import cn.bluesking.bank.types.concept.AccountNumber;
import cn.bluesking.bank.types.concept.UserId;

/**
 * 银行账号持久化仓库对象。
 *
 * @author 随心
 * @date 2020/7/26
 */
public interface AccountRepository {

    Account find(AccountId id);
    Account find(AccountNumber accountNumber);
    Account find(UserId userId);
    Account save(Account account);

}
