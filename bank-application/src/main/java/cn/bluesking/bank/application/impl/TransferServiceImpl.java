package cn.bluesking.bank.application.impl;

import cn.bluesking.bank.application.TransferService;
import cn.bluesking.bank.application.types.Result;
import cn.bluesking.bank.domain.entity.Account;
import cn.bluesking.bank.domain.service.AccountTransferService;
import cn.bluesking.bank.domain.types.AuditMessage;
import cn.bluesking.bank.external.ExchangeRateService;
import cn.bluesking.bank.messaging.AuditMessageProducer;
import cn.bluesking.bank.repository.AccountRepository;
import cn.bluesking.bank.types.behavior.ExchangeRate;
import cn.bluesking.bank.types.concept.AccountNumber;
import cn.bluesking.bank.types.concept.Currency;
import cn.bluesking.bank.types.concept.UserId;
import cn.bluesking.bank.types.context.Money;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 转账服务实现类。
 *
 * @author 随心
 * @date 2020/7/26
 */
public class TransferServiceImpl implements TransferService {

    private final AccountRepository accountRepository;
    private final AuditMessageProducer auditMessageProducer;
    private final ExchangeRateService exchangeRateService;
    private final AccountTransferService accountTransferService;

    public TransferServiceImpl(@NonNull AccountRepository accountRepository,
                               @NonNull AuditMessageProducer auditMessageProducer,
                               @NonNull ExchangeRateService exchangeRateService,
                               @NonNull AccountTransferService accountTransferService) {
        this.accountRepository = accountRepository;
        this.auditMessageProducer = auditMessageProducer;
        this.exchangeRateService = exchangeRateService;
        this.accountTransferService = accountTransferService;
    }

    @Override
    public Result<Boolean> transfer(Long sourceUserId,
                                    String targetAccountNumber,
                                    BigDecimal targetAmount,
                                    String targetCurrency) {

        // 参数校验
        Money targetMoney = new Money(targetAmount, new Currency(targetCurrency));

        // 读数据
        Account sourceAccount = accountRepository.find(new UserId(sourceUserId));
        Account targetAccount = accountRepository.find(new AccountNumber(targetAccountNumber));
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(sourceAccount.getCurrency(), targetMoney.getCurrency());

        // 业务逻辑
        accountTransferService.transfer(sourceAccount, targetAccount, targetMoney, exchangeRate);

        // 保存数据
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        // 发送审计消息
        AuditMessage message = createAuditMessage(targetMoney, sourceAccount, targetAccount);
        auditMessageProducer.send(message);

        return Result.success(true);
    }

    private AuditMessage createAuditMessage(Money targetMoney, Account sourceAccount, Account targetAccount) {
        return new AuditMessage(sourceAccount.getUserId(),
                                sourceAccount.getAccountNumber(),
                                targetAccount.getAccountNumber(),
                                targetMoney,
                                LocalDateTime.now());
    }

}
