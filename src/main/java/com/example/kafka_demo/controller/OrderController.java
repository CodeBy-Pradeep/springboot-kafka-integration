package com.example.kafka_demo.controller;

import com.example.kafka_demo.dto.ApiResponse;
import com.example.kafka_demo.kafka.OrderProducer;
import com.example.kafka_demo.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderProducer producer;

    public OrderController(OrderProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Order>> createOrder(@RequestBody Order order) {
        producer.sendOrder(order);

        ApiResponse<Order> response = new ApiResponse<>(
                "success",
                "Order sent to Kafka successfully",
                order
        );

        return ResponseEntity.ok(response);
    }

}
