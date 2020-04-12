package com.combination.rabbitmq.rabbit;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wx
 * @date: 2020/03/10 18:12
 * @description:
 */
@Data
@ToString
@Configuration
public class RabbitProperties {

    /**
     * rabbitmq 服务器地址
     */
    @Value("${spring.rabbitmq.host}")
    private String host;

    /**
     * rabbitmq 服务器端口
     */
    @Value("${spring.rabbitmq.port}")
    private int port;

    /**
     * rabbitmq 账号
     */
    @Value("${spring.rabbitmq.username}")
    private String username;

    /**
     * rabbitmq 密码
     */
    @Value("${spring.rabbitmq.password}")
    private String password;
}
