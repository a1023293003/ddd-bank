package cn.bluesking.bank.persistence.builder.impl;

import cn.bluesking.bank.domain.entity.Account;
import cn.bluesking.bank.persistence.builder.AccountBuilder;
import cn.bluesking.bank.persistence.model.AccountDO;
import cn.bluesking.bank.types.concept.AccountId;
import cn.bluesking.bank.types.concept.AccountNumber;
import cn.bluesking.bank.types.concept.Currency;
import cn.bluesking.bank.types.concept.UserId;
import cn.bluesking.bank.types.context.Money;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 银行账号对象构建器实现类。
 *
 * @author 随心
 * @date 2020/7/26
 */
@Component
public class AccountBuilderImpl implements AccountBuilder {

    @Override
    public Account toAccount(AccountDO accountDO) {
        if (Objects.isNull(accountDO)) {
            return null;
        } else {
            Account account = new Account();
            account.setId(new AccountId(accountDO.getId()));
            account.setAccountNumber(new AccountNumber(accountDO.getAccountNumber()));
            account.setUserId(new UserId(accountDO.getUserId()));
            Currency currency = new Currency(accountDO.getCurrency());
            account.setAvailable(new Money(accountDO.getAvailableAmount(), currency));
            account.setDailyLimit(new Money(accountDO.getDailyLimitAmount(), currency));
            return account;
        }
    }

    @Override
    public AccountDO fromAccount(Account account) {
        if (Objects.isNull(account)) {
            return null;
        } else {
            AccountDO accountDO = new AccountDO();
            if (Objects.nonNull(account.getId())) {
                accountDO.setId(account.getId().getId());
            }
            if (Objects.nonNull(account.getUserId())) {
                accountDO.setUserId(account.getUserId().getId());
            }
            if (Objects.nonNull(account.getAccountNumber())) {
                accountDO.setAccountNumber(account.getAccountNumber().getNumber());
            }
            if (Objects.nonNull(account.getAvailable())) {
                accountDO.setAvailableAmount(account.getAvailable().getAmount());
            }
            if (Objects.nonNull(account.getDailyLimit())) {
                accountDO.setDailyLimitAmount(account.getDailyLimit().getAmount());
            }
            if (Objects.nonNull(account.getCurrency())) {
                accountDO.setCurrency(account.getCurrency().getValue());
            }
            return accountDO;
        }
    }

}
