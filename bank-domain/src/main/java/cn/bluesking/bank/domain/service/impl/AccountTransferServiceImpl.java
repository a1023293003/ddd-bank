package cn.bluesking.bank.domain.service.impl;

import cn.bluesking.bank.domain.entity.Account;
import cn.bluesking.bank.domain.service.AccountTransferService;
import cn.bluesking.bank.external.ExchangeRateService;
import cn.bluesking.bank.types.behavior.ExchangeRate;
import cn.bluesking.bank.types.context.Money;
import lombok.NonNull;

/**
 * 账户转账服务实现类。
 *
 * @author 随心
 * @date 2020/7/26
 */
public class AccountTransferServiceImpl implements AccountTransferService {

    private final ExchangeRateService exchangeRateService;

    public AccountTransferServiceImpl(@NonNull ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @Override
    public void transfer(@NonNull Account sourceAccount,
                         @NonNull Account targetAccount,
                         @NonNull Money targetMoney,
                         @NonNull ExchangeRate exchangeRate) {
        Money sourceMoney = exchangeRate.exchangeTo(targetMoney);
        sourceAccount.deposit(sourceMoney);
        targetAccount.withdraw(targetMoney);
    }

}
