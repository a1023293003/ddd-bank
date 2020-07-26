package cn.bluesking.bank.domain.service;

import cn.bluesking.bank.domain.entity.Account;
import cn.bluesking.bank.types.behavior.ExchangeRate;
import cn.bluesking.bank.types.context.Money;

/**
 * 账户转账服务。
 *
 * @author 随心
 * @date 2020/7/26
 */
public interface AccountTransferService {

    void transfer(Account sourceAccount, Account targetAccount, Money targetMoney, ExchangeRate exchangeRate);

}