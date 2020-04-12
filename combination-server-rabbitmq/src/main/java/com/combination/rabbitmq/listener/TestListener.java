package com.combination.rabbitmq.listener;

import com.combination.rabbitmq.rabbit.key.RabbitMqKey;
import com.combination.rabbitmq.redisson.serivce.RedissonService;
import com.rabbitmq.client.Channel;
import org.apache.commons.lang.StringUtils;
import org.redisson.api.RMapCache;
import org.redisson.client.codec.IntegerCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * @author: Kenny
 * @date: 2019/6/19 13:12
 * @description: 预订订单队列
 */
@Component
public class TestListener {

    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);

    /**
     * 接收消息
     *
     * @param message
     */
    @RabbitListener(queues = RabbitMqKey.TEST_QUEUE)
    public void process(Message message) throws UnsupportedEncodingException {
        String msg = new String(message.getBody());
        if (StringUtils.isBlank(msg)) {
            logger.warn("接收的数据为空");
            return;
        }
        System.out.println(LocalDateTime.now() + ":Subscriber:" + new String(message.getBody(), "UTF-8"));
        //出现异常
        int a = 0;
        int b = 1 / a;
    }

//    @RabbitListener(queues = RabbitMqKey.TEST_QUEUE)
//    public void process(@Payload Message message, @Headers Map<String, Object> headers, Channel channel) throws IOException, InterruptedException {
//        //delivery tag可以从消息头里边get出来
//        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
//        String correlation = (String) headers.get("spring_returned_message_correlation");
//        try {
//            String msg = new String(message.getBody());
//            if (StringUtils.isBlank(msg)) {
//                logger.warn("接收的数据为空");
//                return;
//            }
//            System.out.println(LocalDateTime.now() + ":Subscriber:" + new String(message.getBody(), "UTF-8"));
//            //出现异常
//            int a = 0;
//            int b = 1 / a;
//            //basicAck()表示确认已经消费消息。通知一下mq,需要先得到 delivery tag
//            channel.basicAck(deliveryTag, false);
//        }catch (Exception e){
//
//            RMapCache<String, Integer> mapCache = RedissonService.getMapCache("RETRY:MECHANISM", IntegerCodec.INSTANCE);
//            if (!mapCache.containsKey(correlation)){
//                mapCache.put(correlation, 1);
//            }
//            Integer integer = mapCache.get(correlation);
//            if (integer > 5){
//                //第三个参数:如果被拒绝的消息应该被重新排队而不是丢弃/死信，则为true,这个参数代表是否重新分发
//                channel.basicNack(deliveryTag,false, false);
//            }else {
//                mapCache.put(correlation, integer + 1);
//                //第三个参数:如果被拒绝的消息应该被重新排队而不是丢弃/死信，则为true,这个参数代表是否重新分发
//                channel.basicNack(deliveryTag,false, true);
//            }
//        }
//    }

    /**
     * 接收死信消息
     *
     * @param message
     */
    @RabbitListener(queues = RabbitMqKey.DELAY_QUEUE)
    public void process1(Message message){
        try {
            String msg = new String(message.getBody());
            if (StringUtils.isBlank(msg)) {
                logger.warn("接收的数据为空");
                return;
            }
            System.out.println("接收到的死信消息：" + msg);
        } catch (Exception e) {
            logger.warn("处理接收到数据，发生异常：{}", e.getMessage());
        }
    }
}
