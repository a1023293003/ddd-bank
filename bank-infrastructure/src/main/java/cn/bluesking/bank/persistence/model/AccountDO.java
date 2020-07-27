package cn.bluesking.bank.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 银行账号 DO 类。
 *
 * @author 随心
 * @date 2020/7/26
 */
@Data
@Entity
@Table(name = "account")
public class AccountDO {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence-generator"
    )
    @SequenceGenerator(
            name = "sequence-generator",
            sequenceName = "account_sequence"
    )
    private Long id;
    private String accountNumber;
    private Long userId;
    private BigDecimal availableAmount;
    private BigDecimal dailyLimitAmount;
    private String currency;

}
