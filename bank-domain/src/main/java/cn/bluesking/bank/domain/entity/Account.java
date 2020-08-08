package cn.bluesking.bank.domain.entity;

import cn.bluesking.bank.exception.DailyLimitExceededException;
import cn.bluesking.bank.exception.InsufficientFundsException;
import cn.bluesking.bank.types.concept.AccountId;
import cn.bluesking.bank.types.concept.AccountNumber;
import cn.bluesking.bank.types.concept.Currency;
import cn.bluesking.bank.types.concept.UserId;
import cn.bluesking.bank.types.context.Money;
import lombok.Data;

/**
 * 银行账户对象。
 *
 * @author 随心
 * @date 2020/7/26
 */
@Data
public class Account {

    private AccountId id;
    private AccountNumber accountNumber;
    private UserId userId;
    private Money available;
    private Money dailyLimit;

    public Currency getCurrency() {
        return this.available.getCurrency();
    }

    public void deposit(Money money) {
        this.available = this.available.add(money);
    }

    public void withdraw(Money money) {
        if (this.available.compareTo(money) < 0) {
            throw new InsufficientFundsException();
        }
        if (this.dailyLimit.compareTo(money) < 0) {
            throw new DailyLimitExceededException();
        }
        this.available = this.available.subtract(money);
    }

}
