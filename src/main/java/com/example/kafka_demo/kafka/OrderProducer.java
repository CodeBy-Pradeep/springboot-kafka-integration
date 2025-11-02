package com.example.kafka_demo.kafka;

import com.example.kafka_demo.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Slf4j
@Service
public class OrderProducer {

    @Value("${app.kafka.order-topic}")
    private String topic;

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

/*    public void sendOrder(Order order) {
        kafkaTemplate.send(topic, order);
        log.info("✅ Sent to Kafka topic [{}]: {}", topic, order);
        System.out.println("✅ Sent to Kafka: " + order);
    }*/

    //This version ensures you get feedback after each send — useful for debugging or observability dashboards.
    public void sendOrder(Order order) {
        kafkaTemplate.send(topic, order).whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("-------------------------------------------------------------");
                log.info("✅ Order delivered successfully to topic '{}' (partition={}, offset={})",
                        result.getRecordMetadata().topic(),
                        result.getRecordMetadata().partition(),
                        result.getRecordMetadata().offset());
            } else {
                log.error("❌ Failed to deliver order to Kafka", ex);
            }
        });
    }
}
