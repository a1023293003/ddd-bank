package cn.bluesking.bank.config;

import cn.bluesking.bank.domain.service.AccountTransferService;
import cn.bluesking.bank.domain.service.impl.AccountTransferServiceImpl;
import cn.bluesking.bank.external.ExchangeRateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Domain Service 配置类。
 *
 * @author 随心
 * @date 2020/7/26
 */
@Configuration
public class DomainServiceConfig {

    @Bean
    public AccountTransferService accountTransferService(ExchangeRateService exchangeRateService) {
        return new AccountTransferServiceImpl(exchangeRateService);
    }

}
