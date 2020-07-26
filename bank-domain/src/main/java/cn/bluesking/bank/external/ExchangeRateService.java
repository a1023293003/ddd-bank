package cn.bluesking.bank.external;

import cn.bluesking.bank.types.behavior.ExchangeRate;
import cn.bluesking.bank.types.concept.Currency;

/**
 * 获取汇率服务。
 *
 * @author 随心
 * @date 2020/7/26
 */
public interface ExchangeRateService {

    ExchangeRate getExchangeRate(Currency source, Currency target);

}
