package com.combination.rabbitmq.rabbit.config;

import com.combination.rabbitmq.rabbit.key.RabbitMqKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: qiusongzhi
 * @date: 2019/4/16 18:12
 * @description:
 */
@Component
public class TradeOrderQueueConfig {


    private final static Logger logger = LoggerFactory.getLogger(TradeOrderQueueConfig.class);

    /**
     * 创建队列
     * Queue 可以有4个参数
     * String name: 队列名
     * boolean durable: 持久化消息队列，rabbitmq 重启的时候不需要创建新的队列，默认为 true
     * boolean exclusive: 表示该消息队列是否只在当前的connection生效，默认为 false
     * boolean autoDelete: 表示消息队列在没有使用时将自动被删除，默认为 false
     * Map<String, Object> arguments:
     *
     * @return
     */
    @Bean(name = "queue")
    public Queue queue() {
        logger.info("queue : {}", RabbitMqKey.TRADE_ORDER_QUEUE);
        // 队列持久化
        return new Queue(RabbitMqKey.TRADE_ORDER_QUEUE, true);
    }

    /**
     * 创建一个 Fanout 类型的交换器
     * <p>
     * rabbitmq中，Exchange 有4个类型：Direct，Topic，Fanout，Headers
     * Direct Exchange：将消息中的Routing key与该Exchange关联的所有Binding中的Routing key进行比较，如果相等，则发送到该Binding对应的Queue中；
     * Topic Exchange：将消息中的Routing key与该Exchange关联的所有Binding中的Routing key进行对比，如果匹配上了，则发送到该Binding对应的Queue中；
     * Fanout Exchange：直接将消息转发到所有binding的对应queue中，这种exchange在路由转发的时候，忽略Routing key；
     * Headers Exchange：将消息中的headers与该Exchange相关联的所有Binging中的参数进行匹配，如果匹配上了，则发送到该Binding对应的Queue中；
     *
     * @return
     */
    @Bean(name = "fanoutExchange")
    public FanoutExchange fanoutExchange() {
        logger.info("exchange : {}", RabbitMqKey.TRADE_ORDER_EXCHANGE);
        return new FanoutExchange(RabbitMqKey.TRADE_ORDER_EXCHANGE);
    }



//    @Bean(name = "testQueue")
//    public Queue testQueue() {
//        logger.info("queue : {}", RabbitMqKey.TEST_QUEUE);
//        // 队列持久化
//        return new Queue(RabbitMqKey.TEST_QUEUE, true);
//    }

//    @Bean
//    Binding testBinding(@Qualifier("testQueue") Queue testQueue,
//                          @Qualifier("testExchange") FanoutExchange testExchange) {
//        return BindingBuilder.bind(testQueue).to(testExchange);
//    }

//    @Bean(name = "delayTestQueue")
//    public Queue delayTestQueue() {
//        Map<String, Object> params = new HashMap<>(2);
//        // x-dead-letter-exchange 声明了当前队列绑定的死信交换机
//        params.put("x-dead-letter-exchange", RabbitMqKey.DELAY_EXCHANGE);
//        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
//        params.put("x-dead-letter-routing-key", RabbitMqKey.DELAY_ROUTING_KEY);
//        return QueueBuilder.durable(RabbitMqKey.TEST_QUEUE).withArguments(params).build();
//    }
//
//    @Bean
//    Binding testBinding(@Qualifier("delayTestQueue") Queue delayTestQueue,
//                          @Qualifier("testExchange") FanoutExchange testExchange) {
//        return BindingBuilder.bind(delayTestQueue).to(testExchange);
//    }

    @Bean(name = "testExchange")
    public FanoutExchange testExchange() {
        logger.info("exchange : {}", RabbitMqKey.TEST_EXCHANGE);
        return new FanoutExchange(RabbitMqKey.TEST_EXCHANGE);
    }

    @Bean(name = "delayTestQueue")
    public Queue delayTestQueue() {
        logger.info("queue : {}", RabbitMqKey.TEST_QUEUE);
        // 队列持久化
        return new Queue(RabbitMqKey.TEST_QUEUE, true);
    }

    @Bean
    Binding delayTestBinding(@Qualifier("delayTestQueue") Queue delayTestQueue,
                          @Qualifier("testExchange") FanoutExchange testExchange) {
        return BindingBuilder.bind(delayTestQueue).to(testExchange);
    }

    @Bean(name = "delayQueue")
    public Queue delayQueue() {
        logger.info("queue : {}", RabbitMqKey.DELAY_QUEUE);
        // 队列持久化
        return new Queue(RabbitMqKey.DELAY_QUEUE, true);
    }

    @Bean(name = "delayExchange")
    public DirectExchange delayExchange() {
        logger.info("exchange : {}", RabbitMqKey.DELAY_EXCHANGE);
        return new DirectExchange(RabbitMqKey.DELAY_EXCHANGE);
    }

    @Bean
    Binding delayBinding(@Qualifier("delayQueue") Queue delayQueue,
                          @Qualifier("delayExchange") DirectExchange delayExchange) {
        return BindingBuilder.bind(delayQueue).to(delayExchange).with(RabbitMqKey.DELAY_ROUTING_KEY);
    }

    @Bean
    Binding fanoutBinding(@Qualifier("queue") Queue queue,
                    @Qualifier("fanoutExchange") FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean(name = "directQueue")
    public Queue directQueue() {
        logger.info("queue : {}", RabbitMqKey.TRADE_DIRECT_TEST_QUEUE);
        // 队列持久化
        return new Queue(RabbitMqKey.TRADE_DIRECT_TEST_QUEUE, true);
    }

    @Bean(name = "directExchange")
    public DirectExchange directExchange() {
        logger.info("exchange : {}", RabbitMqKey.TRADE_DIRECT_TEST_EXCHANGE);
        return new DirectExchange(RabbitMqKey.TRADE_DIRECT_TEST_EXCHANGE);
    }

    @Bean
    Binding directBinding(@Qualifier("directQueue") Queue directQueue,
                          @Qualifier("directExchange") DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue).to(directExchange).with(RabbitMqKey.ROUTING_KEY);
    }

    @Bean(name = "topicQueue")
    public Queue topicQueue() {
        logger.info("queue : {}", RabbitMqKey.TRADE_TOPIC_TEST_QUEUE);
        // 队列持久化
        return new Queue(RabbitMqKey.TRADE_TOPIC_TEST_QUEUE, true);
    }

    @Bean(name = "topicExchange")
    public TopicExchange topicExchange() {
        logger.info("exchange : {}", RabbitMqKey.TRADE_TOPIC_TEST_EXCHANGE);
        return new TopicExchange(RabbitMqKey.TRADE_TOPIC_TEST_EXCHANGE);
    }

    @Bean
    Binding topicBinding(@Qualifier("topicQueue") Queue topicQueue,
                          @Qualifier("topicExchange") TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue).to(topicExchange).with(RabbitMqKey.TOPIC_ROUTING_KEY);
    }

    /**
     * 接收延迟信息的队列，并指定过期时间，以及过期之后要发送到哪个死信交换器，以及死信交换器的路由
     *
     * @return
     */
    @Bean(name = "delayOrderQueue")
    public Queue delayOrderQueue() {
        Map<String, Object> params = new HashMap<>(2);
        // x-dead-letter-exchange 声明了当前队列绑定的死信交换机
        params.put("x-dead-letter-exchange", RabbitMqKey.DEAD_LETTER_EXCHANGE);
        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
        params.put("x-dead-letter-routing-key", RabbitMqKey.DEAD_LETTER_ROUTING_KEY);
        // x-message-ttl 队列过期时间
        params.put("x-message-ttl", 100000);
        return QueueBuilder.durable(RabbitMqKey.TRADE_ORDER_DELAY_QUEUE).withArguments(params).build();
    }

    /**
     * 接收延迟信息的交换器
     *
     * @return
     */
    @Bean(name = "orderDelayExchange")
    public DirectExchange orderDelayExchange() {
        return new DirectExchange(RabbitMqKey.TRADE_ORDER_DELAY_EXCHANGE);
    }

    @Bean
    Binding orderDelayBinding(@Qualifier("delayOrderQueue") Queue delayOrderQueue,
                         @Qualifier("orderDelayExchange") DirectExchange orderDelayExchange) {
        return BindingBuilder.bind(delayOrderQueue).to(orderDelayExchange).with(RabbitMqKey.ORDER_DELAY_ROUTING_KEY);
    }

    /**
     * 接收死信队列内的信息 - queue
     * @return
     */
    @Bean(name = "orderQueue")
    public Queue orderQueue() {
        return new Queue(RabbitMqKey.DEAD_LETTER_QUEUE, true);
    }

    /**
     * 将路由键和某模式进行匹配。此时队列需要绑定要一个模式上。
     * 符号“#”匹配一个或多个词，符号“*”匹配不多不少一个词。因此“audit.#”能够匹配到“audit.irs.corporate”，但是“audit.*” 只会匹配到“audit.irs”。
     **/
    @Bean(name = "orderTopicExchange")
    public TopicExchange orderTopicExchange() {
        return new TopicExchange(RabbitMqKey.DEAD_LETTER_EXCHANGE);
    }

    @Bean
    Binding orderTopicBinding(@Qualifier("orderQueue") Queue orderQueue,
                              @Qualifier("orderTopicExchange") TopicExchange orderTopicExchange) {
        return BindingBuilder.bind(orderQueue).to(orderTopicExchange).with(RabbitMqKey.DEAD_LETTER_ROUTING_KEY);
    }

    /**
     * 把队列（Queue）绑定到交换器（Exchange）
     * topic 使用路由键（routingKey）
     *
     * @return
     */
//    @Bean
//    public List<Binding> bindings() {
//        List<Binding> bindings = new ArrayList<>();
//
//        bindings.add(BindingBuilder.bind(queue()).to(fanoutExchange()));
//        bindings.add(BindingBuilder.bind(directQueue()).to(directExchange()).with(RabbitMqKey.ROUTING_KEY));
//        bindings.add(BindingBuilder.bind(topicQueue()).to(topicExchange()).with(RabbitMqKey.TOPIC_ROUTING_KEY));
//        bindings.add(BindingBuilder.bind(orderQueue()).to(orderTopicExchange()).with(RabbitMqKey.DEAD_LETTER_ROUTING_KEY));
//        bindings.add(BindingBuilder.bind(delayOrderQueue()).to(orderDelayExchange()).with(RabbitMqKey.ORDER_DELAY_ROUTING_KEY));
//        bindings.add(BindingBuilder.bind(delayTestQueue()).to(testExchange()));
//        bindings.add(BindingBuilder.bind(delayQueue()).to(delayExchange()).with(RabbitMqKey.DELAY_ROUTING_KEY));
//
//        return bindings;
//    }
}


