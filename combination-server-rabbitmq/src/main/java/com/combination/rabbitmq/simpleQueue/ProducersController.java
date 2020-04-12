package com.combination.rabbitmq.simpleQueue;

import com.combination.rabbitmq.rabbit.send.Sender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wx
 */
@RestController
public class ProducersController {

    @Resource
    private Sender sender;

    /**
     * 单个发送
     */
    @PostMapping("/producers")
    public void producers(){
        sender.orderSendQueue("Hello World");
    }

    /**
     * 批量发送
     */
    @PostMapping("/batch/producers")
    public void batchProducers(){
        for (int i = 0; i < 100; i++){
            sender.orderSendQueue("Hello World" + i);
        }
    }

    /**
     * 发送信息至交换器
     */
    @PostMapping("/send/message")
    public void sendMessage(){
        sender.orderSendExchange("我是一只快乐的小青蛙");
    }

    /**
     * info
     */
    @PostMapping("/send/info")
    public void sendInfo(){
        sender.infoSendQueue("我是info级别的日志，你可以不用管我");
    }

    /**
     * info
     */
    @PostMapping("/send/error")
    public void sendError(){
        sender.errorSendQueue("我是error级别的日志，你也可以不用管我，只要你不怕死");
    }

    /**
     * 发送信息
     */
    @PostMapping("/send/java")
    public void sendJava(){
        sender.topicErrorSendQueue("JAVA.*:匹配不多不少一个词 JAVA.#:匹配一个或多个词");
    }

    /**
     * 发送信息
     */
    @PostMapping("/send/java/error")
    public void sendJavaError(){
        sender.topicInfoSendQueue("JAVA.*:匹配不多不少一个词 JAVA.#:匹配一个或多个词");
    }

    /**
     * 发送信息
     */
    @PostMapping("/send/delay/message")
    public void sendDelayMessage(){
        sender.delaySend("某某某订单已经失效，请归还库存");
    }

    /**
     * 发送信息
     */
    @PostMapping("/send/test")
    public void sendTest(){
        sender.testSendExchange("测试消息重试机制");
    }
}
