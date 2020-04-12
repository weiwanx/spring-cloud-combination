package com.combination.rabbitmq.rabbit;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author: wx
 * @date: 2020/03/10 18:12
 * @description:
 */
@Configuration
public class RabbitConfiguration {

    @Autowired
    private RabbitProperties rabbitProperties;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(rabbitProperties.getHost(), rabbitProperties.getPort());
        connectionFactory.setUsername(rabbitProperties.getUsername());
        connectionFactory.setPassword(rabbitProperties.getPassword());
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    /**
     * @return
     * @Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)这个是说在每次注入的时候回自动创建一个新的bean实例
     * @Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)单例模式，在整个应用中只能创建一个实例
     * @Scope(value=WebApplicationContext.SCOPE_GLOBAL_SESSION)全局session中的一般不常用
     * @Scope(value=WebApplicationContext.SCOPE_APPLICATION)在一个web应用中只创建一个实例
     * @Scope(value=WebApplicationContext.SCOPE_REQUEST)在一个请求中创建一个实例
     * @Scope(value=WebApplicationContext.SCOPE_SESSION)每次创建一个会话中创建一个实例
     * proxyMode=ScopedProxyMode.INTERFACES创建一个JDK代理模式
     * proxyMode=ScopedProxyMode.TARGET_CLASS基于类的代理模式
     * proxyMode=ScopedProxyMode.NO（默认）不进行代理
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        // 消息发送失败返回到队列中, yml需要配置 publisher-returns: true
        // template.setMandatory(true);
        return template;
    }
}
