package cn.bluesking.bank.domain.types;

import cn.bluesking.bank.exception.ValidationException;
import cn.bluesking.bank.types.concept.AccountNumber;
import cn.bluesking.bank.types.concept.Currency;
import cn.bluesking.bank.types.concept.UserId;
import cn.bluesking.bank.types.context.Money;
import lombok.NonNull;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 * @author 随心
 * @date 2020/7/26
 */
@Value
public final class AuditMessage {

    private final UserId userId;
    private final AccountNumber source;
    private final AccountNumber target;
    private final Money money;
    private final LocalDateTime date;

    public AuditMessage(@NonNull UserId userId,
                        @NonNull AccountNumber source,
                        @NonNull AccountNumber target,
                        @NonNull Money money,
                        @NonNull LocalDateTime date) {
        this.userId = userId;
        this.source = source;
        this.target = target;
        this.money = money;
        this.date = date;
    }

    public String serialize() {
        return userId.getId() + "," +
                source.getNumber() + "," +
                target.getNumber() + "," +
                money.getAmount() + "," +
                money.getCurrency().getValue() + "," +
                date.format(DateTimeFormatter.ISO_INSTANT);
    }

    public static AuditMessage deserialize(String value) {
        if (Objects.isNull(value)) {
            throw new ValidationException("Audit Message 反序列化入参不能为 null！");
        } else {
            String[] args = value.split(",");
            if (Objects.isNull(args) || args.length != 5) {
                throw new ValidationException("Audit Message 反序列化入参存在数据缺失！[" + value + "]");
            }
            return new AuditMessage(
                    new UserId(Long.parseLong(args[0])),
                    new AccountNumber(args[1]),
                    new AccountNumber(args[2]),
                    new Money(new BigDecimal(args[3]), new Currency(args[4])),
                    LocalDateTime.parse(args[5], DateTimeFormatter.ISO_INSTANT));
        }
    }

}
