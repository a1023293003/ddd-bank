package cn.bluesking.bank.external.impl;

import cn.bluesking.bank.exception.InvalidServiceException;
import cn.bluesking.bank.external.ExchangeRateService;
import cn.bluesking.bank.types.behavior.ExchangeRate;
import cn.bluesking.bank.types.concept.Currency;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author 随心
 * @date 2020/7/26
 */
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Override
    public ExchangeRate getExchangeRate(@NonNull Currency source, @NonNull Currency target) {
        if (Objects.equals(source, target)) {
            return new ExchangeRate(BigDecimal.ONE, source, target);
        } else {
            throw  new InvalidServiceException();
        }
    }

}
