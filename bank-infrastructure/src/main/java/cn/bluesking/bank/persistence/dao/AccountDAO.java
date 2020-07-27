package cn.bluesking.bank.persistence.dao;

import cn.bluesking.bank.persistence.model.AccountDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 账号信息 DO 对象持久层操作接口。
 *
 * @author 随心
 * @date 2020/7/26
 */
@Repository
public interface AccountDAO extends JpaRepository<AccountDO, Long> {

    AccountDO findByAccountNumber(String accountNumber);

    AccountDO findByUserId(Long userId);

}
