package cn.bluesking.bank.helper;

import cn.bluesking.bank.domain.types.SendResult;
import lombok.experimental.UtilityClass;

/**
 * 信息发送结果助手类。
 *
 * @author 随心
 * @date 2020/7/26
 */
@UtilityClass
public final class SendResultHelper {

    public static final SendResult SEND_SUCCESS = new SendResult(true);

    public static final SendResult SEND_FAILURE = new SendResult(false);

}
