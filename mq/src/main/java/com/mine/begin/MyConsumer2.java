package com.mine.begin;

import com.mine.common.Constant;
import com.rabbitmq.client.*;

import java.io.IOException;

public class MyConsumer2 {
    private final static String EXCHANGE_NAME = "SIMPLE_EXCHANGE";
    private final static String QUEUE_NAME = "SIMPLE_QUEUE";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        // 连接IP
        factory.setHost("10.20.146.182");
        // 默认监听端口
        factory.setPort(5672);
        // 虚拟机
        factory.setVirtualHost("/");
        // 设置访问的用户
        factory.setUsername("guest");
        factory.setPassword("guest");
        // 建立连接
        Connection conn = factory.newConnection();
        // 创建消息通道
        Channel channel = conn.createChannel();
        // 声明交换机
        // String exchange, String type, boolean durable, boolean autoDelete, Map<String, Object> arguments
        channel.exchangeDeclare(EXCHANGE_NAME, Constant.MQ_EXCHANGE_TYPE_TOPIC, false, false, null);
        // 声明队列
        // String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println("MyConsumer2 Waiting for message....");
        // 绑定队列和交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "mine.#");
        // 创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("MyConsumer2 Received message : '" + msg + "'");
                System.out.println("MyConsumer2 consumerTag : " + consumerTag);
                System.out.println("MyConsumer2 deliveryTag : " + envelope.getDeliveryTag());
            }
        };
        // 开始获取消息
        // String queue, boolean autoAck, Consumer callback
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}