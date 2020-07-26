package cn.bluesking.bank.application;

import cn.bluesking.bank.application.types.Result;

import java.math.BigDecimal;

/**
 * 转账服务接口。
 *
 * @author 随心
 * @date 2020/7/26
 */
public interface TransferService {

    Result<Boolean> transfer(Long sourceUserId,
                             String targetAccountNumber,
                             BigDecimal targetAmount,
                             String targetCurrency);

}
