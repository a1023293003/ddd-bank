package cn.bluesking.bank.repository.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.bluesking.bank.BaseSpringBootTest;
import cn.bluesking.bank.domain.entity.Account;
import cn.bluesking.bank.repository.AccountRepository;
import cn.bluesking.bank.types.concept.AccountId;
import cn.bluesking.bank.types.concept.AccountNumber;
import cn.bluesking.bank.types.concept.Currency;
import cn.bluesking.bank.types.concept.UserId;
import cn.bluesking.bank.types.context.Money;

/**
 * Junit Test For {@link cn.bluesking.bank.repository.AccountRepository}。
 *
 * @author 随心
 * @date 2020/7/26
 */
class AccountRepositoryImplTest extends BaseSpringBootTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    @Order(1)
//    @Sql("classpath:sql/AccountRepositoryImplTest.sql")
//    @Sql(scripts = "classpath:sql/truncate.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void findByAccountId() {
        for (long i = 1001; i <= 1002; i ++) {
            Account expectFound = accountRepository.find(new AccountId(i));
            Assert.assertNotNull(expectFound);
            Account expectNotFound = accountRepository.find(new AccountId(i - 7));
            Assert.assertNull(expectNotFound);
        }
    }

    @Test
    @Order(2)
    void findByAccountNumber() {
        Account expectFound = accountRepository.find(new AccountNumber("1234567890"));
        Assert.assertNotNull(expectFound);
    }

    @Test
    @Order(3)
    void findByUserId() {
        for (long i = 1001; i <= 1002; i ++) {
            Account expectFound = accountRepository.find(new UserId(i));
            Assert.assertNotNull(expectFound);
            Account expectNotFound = accountRepository.find(new UserId(i + 7));
            Assert.assertNull(expectNotFound);
        }
    }

    @Test
    @Order(4)
    void save() {
        Account account = new Account();
        account.setUserId(new UserId(1010L));
        account.setAccountNumber(new AccountNumber("0987654321"));
        account.setAvailable(new Money(new BigDecimal(123), new Currency("CNY")));
        account.setDailyLimit(new Money(new BigDecimal(20000.0), new Currency("CNY")));
        Account savedAccount = accountRepository.save(account);
        Assert.assertNotNull(savedAccount.getId());
        Assert.assertNotNull(savedAccount.getAccountNumber());
        Assert.assertNotNull(savedAccount.getAvailable());
        Assert.assertNotNull(savedAccount.getCurrency());
        Assert.assertNotNull(savedAccount.getDailyLimit());
        Assert.assertNotNull(savedAccount.getUserId());
    }

}