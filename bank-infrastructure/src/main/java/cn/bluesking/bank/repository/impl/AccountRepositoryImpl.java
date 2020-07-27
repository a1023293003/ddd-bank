package cn.bluesking.bank.repository.impl;

import cn.bluesking.bank.domain.entity.Account;
import cn.bluesking.bank.persistence.builder.AccountBuilder;
import cn.bluesking.bank.persistence.dao.AccountDAO;
import cn.bluesking.bank.repository.AccountRepository;
import cn.bluesking.bank.types.concept.AccountId;
import cn.bluesking.bank.types.concept.AccountNumber;
import cn.bluesking.bank.types.concept.UserId;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 银行账号持久化仓库对象实现类。
 *
 * @author 随心
 * @date 2020/7/26
 */
@Component
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountDAO accountDAO;

    private final AccountBuilder accountBuilder;

    public AccountRepositoryImpl(@NonNull AccountDAO accountDAO, @NonNull AccountBuilder accountBuilder) {
        this.accountDAO = accountDAO;
        this.accountBuilder = accountBuilder;
    }

    @Override
    public Account find(AccountId id) {
        return Optional.ofNullable(id)
                .map(AccountId::getId)
                .flatMap(accountDAO::findById)
                .map(accountBuilder::toAccount)
                .orElse(null);
    }

    @Override
    public Account find(AccountNumber accountNumber) {
        return Optional.ofNullable(accountNumber)
                .map(AccountNumber::getNumber)
                .map(accountDAO::findByAccountNumber)
                .map(accountBuilder::toAccount)
                .orElse(null);
    }

    @Override
    public Account find(UserId userId) {
        return Optional.ofNullable(userId)
                .map(UserId::getId)
                .map(accountDAO::findByUserId)
                .map(accountBuilder::toAccount)
                .orElse(null);
    }

    @Override
    public Account save(Account account) {
        return Optional.ofNullable(account)
                .map(accountBuilder::fromAccount)
                .map(accountDAO::save)
                .map(accountBuilder::toAccount)
                .orElse(account);
    }

}
