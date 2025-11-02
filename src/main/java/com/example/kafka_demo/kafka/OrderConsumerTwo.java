package com.example.kafka_demo.kafka;

import com.example.kafka_demo.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumerTwo {

    @KafkaListener(topics = "order-topic", groupId = "order-group")
    public void consume(Order order) {
        System.out.println("📦 [Consumer-2] Received from Kafka: " + order);
    }
}
