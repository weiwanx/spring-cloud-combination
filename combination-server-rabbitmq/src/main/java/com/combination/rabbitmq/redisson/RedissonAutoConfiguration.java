package com.combination.rabbitmq.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * redisson auto configuration
 * @author Ager
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@Component
public class RedissonAutoConfiguration extends Config {
//    /**
//     * 加载配置
//     */
//    @Autowired
//    private RedissProperties redissProperties;
//
//    @Bean
//    public RedissonClient redissonClient() {
//
//        String[] nodeArr = redissProperties.getAddNodeAddress().split(",");
//        Config config = new Config();
//        config.useClusterServers().addNodeAddress(nodeArr)
//                //集群状态扫描间隔时间，单位是毫秒
//                .setScanInterval(redissProperties.getScanInterval())
//                //设置对于Master节点的连接池中连接数最大为500
//                .setMasterConnectionPoolSize(redissProperties.getMasterConnectionPoolSize())
//                //设置对于slave节点的连接池中连接数
//                .setSlaveConnectionPoolSize(redissProperties.getSlaveConnectionPoolSize())
//                //如果当前连接池里的连接数量超过了最小空闲连接数，而同时有连接空闲时间超过了该数值，那么这些连接将会自动被关闭，并从连接池里去掉。时间单位是毫秒。
//                .setIdleConnectionTimeout(redissProperties.getIdleConnectionTimeout())
//                //同任何节点建立连接时的等待超时。时间单位是毫秒。
//                .setConnectTimeout(redissProperties.getConnectTimeout())
//                //等待节点回复命令的时间。该时间从命令发送成功时开始计时。
//                .setTimeout(redissProperties.getTimeout())
//                //设置心跳
//                .setPingTimeout(redissProperties.getPingTimeout());
//        //注意：不设置序列化类型；将会是 Jackson JSON 编码 默认编码
//
//        return Redisson.create(config);
//    }

}