package cn.bluesking.bank.domain.types;

import lombok.Getter;
import lombok.Value;

/**
 * 信息发送结果。
 *
 * @author 随心
 * @date 2020/7/26
 */
@Value
@Getter
public final class SendResult {

    private final boolean success;

    public SendResult(boolean success) {
        this.success = success;
    }

}
