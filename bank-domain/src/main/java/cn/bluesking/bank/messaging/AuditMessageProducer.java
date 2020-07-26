package cn.bluesking.bank.messaging;

import cn.bluesking.bank.domain.types.AuditMessage;
import cn.bluesking.bank.domain.types.SendResult;

/**
 * 审计信息生产者。
 *
 * @author 随心
 * @date 2020/7/26
 */
public interface AuditMessageProducer {

    SendResult send(AuditMessage message);

}
