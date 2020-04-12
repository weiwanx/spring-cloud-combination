package com.combination.rabbitmq.listener;

import com.combination.rabbitmq.rabbit.key.RabbitMqKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author: Kenny
 * @date: 2019/6/19 13:12
 * @description: 预订订单队列
 */
@Component
public class DelayListener {

    private static final Logger logger = LoggerFactory.getLogger(DelayListener.class);

    /**
     * 接收延迟消息
     *
     * @param message
     */
    @RabbitListener(queues = RabbitMqKey.DEAD_LETTER_QUEUE)
    public void process(Message message) {
        try {
            String msg = new String(message.getBody());
            if (StringUtils.isEmpty(msg)) {
                logger.warn("接收的数据为空");
                return;
            }
            logger.info("接收到的延迟消息：{}", msg);
        } catch (Exception e) {
            logger.warn("处理接收到数据，发生异常：{}", e.getMessage());
            e.printStackTrace();
        }
    }
}
