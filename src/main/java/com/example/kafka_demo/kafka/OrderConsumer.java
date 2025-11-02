package com.example.kafka_demo.kafka;

import com.example.kafka_demo.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderConsumer {

    @KafkaListener(topics = "order-topic", groupId = "order-group")
    public void consume(Order order) {
        log.info("📥 Consumed from Kafka: {}", order);
    }
}
