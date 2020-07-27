package cn.bluesking.bank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * JPA 配置。
 *
 * @author 随心
 * @date 2020/7/26
 */
@Configuration
@EnableJpaRepositories("cn.bluesking.bank")
public class JPAConfig {



}
