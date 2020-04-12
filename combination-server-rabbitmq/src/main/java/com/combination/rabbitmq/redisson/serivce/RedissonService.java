package com.combination.rabbitmq.redisson.serivce;

import org.redisson.api.*;
import org.redisson.client.codec.Codec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author: Kenny
 * @date: 2019/5/30 10:06
 * @description:
 */
@Component
public class RedissonService {
//
//    private static final Logger logger = LoggerFactory.getLogger(RedissonService.class);
//
//    private static RedissonService redissonTemplate;
//
//    @Autowired
//    private RedissonClient redissonClient;
//
//    /**
//     * 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次
//     */
//    @PostConstruct
//    public void init() {
//        redissonTemplate = this;
//        redissonTemplate.redissonClient = this.redissonClient;
//    }
//
//    /**
//     * redisson 获取操作
//     *
//     * @return
//     */
//    private static RedissonClient getR() {
//        return redissonTemplate.redissonClient;
//    }
//
//    /**
//     * 获取字符串对象
//     *
//     * @param objectName
//     * @param <T>
//     * @return
//     */
//    public static <T> RBucket<T> getRBucket(String objectName) {
//        RBucket<T> bucket = getR().getBucket(objectName);
//        return bucket;
//    }
//
//    /**
//     * 获取字符串
//     *
//     * @param objectName
//     * @return
//     */
//    public static String getRBucketString(String objectName) {
//        return getRBucket(objectName).get().toString();
//    }
//
//    /**
//     * 存储字符串
//     *
//     * @param objectName
//     * @param value
//     * @return
//     */
//    public static void setRBucketString(String objectName, String value) {
//        getRBucket(objectName).set(value);
//    }
//
//    /**
//     * 获取Map对象
//     *
//     * @param objectName
//     * @return
//     */
//    public static <K, V> RMap<K, V> getRMap(String objectName) {
//        RMap<K, V> map = getR().getMap(objectName);
//        return map;
//    }
//
//    /**
//     * 获取 Map 并指定 编码
//     * @param hashKey
//     * @param v1
//     * @param <K>
//     * @param <V>
//     * @return
//     */
//    public static <K, V> RMapCache<K, V> getMapCache(final String hashKey, final Codec v1) {
//        return getR().getMapCache(hashKey, v1);
//    }
//
//    /**
//     * 获取有序集合 SortedSet
//     *
//     * @param objectName
//     * @return
//     */
//    public static <V> RSortedSet<V> getRSortedSet(String objectName) {
//        RSortedSet<V> sortedSet = getR().getSortedSet(objectName);
//        return sortedSet;
//    }
//
//    /**
//     * 获取集合 Set
//     *
//     * @param objectName
//     * @return
//     */
//    public static <V> RSet<V> getRSet(String objectName) {
//        RSet<V> rSet = getR().getSet(objectName);
//        return rSet;
//    }
//
//    /**
//     * 获取列表 List
//     *
//     * @param objectName
//     * @return
//     */
//    public static <V> RList<V> getRList(String objectName) {
//        RList<V> rList = getR().getList(objectName);
//        return rList;
//    }
//
//    /**
//     * 获取队列
//     *
//     * @param objectName
//     * @return
//     */
//    public static <V> RQueue<V> getRQueue(String objectName) {
//        RQueue<V> rQueue = getR().getQueue(objectName);
//        return rQueue;
//    }
//
//    /**
//     * 获取双端队列
//     *
//     * @param objectName
//     * @return
//     */
//    public static <V> RDeque<V> getRDeque(String objectName) {
//        RDeque<V> rDeque = getR().getDeque(objectName);
//        return rDeque;
//    }
//
//    /**
//     * 获取锁
//     *
//     * @param objectName
//     * @return
//     */
//    public static RLock getRLock(String objectName) {
//        RLock rLock = getR().getLock(objectName);
//        return rLock;
//    }
//
//    /**
//     * 获取原子数
//     *
//     * @param objectName
//     * @return
//     */
//    public static RAtomicLong getRAtomicLong(String objectName) {
//        RAtomicLong rAtomicLong = getR().getAtomicLong(objectName);
//        return rAtomicLong;
//    }
//
//    /**
//     * 获取记数锁
//     *
//     * @param objectName
//     * @return
//     */
//    public static RCountDownLatch getRCountDownLatch(String objectName) {
//        RCountDownLatch rCountDownLatch = getR().getCountDownLatch(objectName);
//        return rCountDownLatch;
//    }
//
//    /**
//     * 获取消息的Topic
//     *
//     * @param objectName
//     * @return
//     */
//    public static <M> RTopic<M> getRTopic(String objectName) {
//        RTopic<M> rTopic = getR().getTopic(objectName);
//        return rTopic;
//    }
//

}
