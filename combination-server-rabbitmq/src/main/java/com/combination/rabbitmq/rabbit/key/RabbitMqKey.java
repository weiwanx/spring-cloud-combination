package com.combination.rabbitmq.rabbit.key;

/**
 * @author: wx
 * @date: 2020/03/10 18:12
 * @description:
 */
public class RabbitMqKey {

    /**
     * 订单-队列
     */
    public static final String TRADE_ORDER_QUEUE = "trade-order-queue";

    /**
     * 订单-交换器
     */
    public static final String TRADE_ORDER_EXCHANGE = "trade-order-exchange";

    /**
     * 路由测试队列
     */
    public static final String TRADE_DIRECT_TEST_QUEUE = "trade-direct-test-queue";

    /**
     * 路由测试交换器
     */
    public static final String TRADE_DIRECT_TEST_EXCHANGE = "trade-direct-test-exchange";

    /**
     * 路由
     */
    public static final String ROUTING_KEY = "ERROR";

    /**
     * 路由测试队列
     */
    public static final String TRADE_TOPIC_TEST_QUEUE = "trade-topic-test-queue";

    /**
     * 路由测试交换器
     */
    public static final String TRADE_TOPIC_TEST_EXCHANGE = "trade-topic-test-exchange";

    /**
     * 路由
     */
    public static final String TOPIC_ROUTING_KEY = "JAVA.#";

    /**
     * 接收延迟消息的队列
     */
    public static final String TRADE_ORDER_DELAY_QUEUE = "trade-order-delay-queue";
    /**
     * DLX，dead letter发送到的 exchange
     * 接收延迟消息的队列交换器
     */
    public static final String TRADE_ORDER_DELAY_EXCHANGE = "trade-order-delay-exchange";
    /**
     * routing key 名称
     * 具体消息发送在该 routingKey 的
     */
    public static final String ORDER_DELAY_ROUTING_KEY = "order-delay";

    /**
     * 接收死信消息的queue - queue
     */
    public static final String DEAD_LETTER_QUEUE = "dead-letter-queue";

    /**
     * 接收死信消息的exchange - exchange
     */
    public static final String DEAD_LETTER_EXCHANGE = "dead-letter-exchange";

    /**
     * routing key 名称
     */
    public static final String DEAD_LETTER_ROUTING_KEY = "dead-letter";

    /**
     * 测试-队列
     */
    public static final String TEST_QUEUE = "test-queue";

    /**
     * 测试-交换器
     */
    public static final String TEST_EXCHANGE = "test-exchange";

    /**
     * 死信队列
     */
    public static final String DELAY_QUEUE = "delay-queue";
    /**
     * 死信交换器
     */
    public static final String DELAY_EXCHANGE = "delay-exchange";
    /**
     * routing key 名称
     */
    public static final String DELAY_ROUTING_KEY = "delay-routing-key";

}
