# 🚀 Spring Boot Kafka Integration Demo

This project demonstrates a **complete end-to-end Kafka setup** with Spring Boot — including producer, consumer, multiple consumer groups, and Docker-based local Kafka setup.

---

## 🧩 Features

- Kafka Producer & Consumer using Spring Boot
- JSON serialization/deserialization with `KafkaTemplate`
- Multiple Consumers in the same or different groups
- Docker-based local Kafka & Zookeeper setup
- REST API endpoint to publish messages to Kafka
- Callback confirmation on producer send
- Works with `JsonSerializer` and `JsonDeserializer`

---

## ⚙️ Tech Stack

| Component | Technology |
|------------|-------------|
| Language | Java 17+ |
| Framework | Spring Boot 3.x |
| Messaging | Apache Kafka |
| Container | Docker |
| Build Tool | Maven |

---

## 🧰 Prerequisites

Install the following on your local machine:

- [Docker](https://docs.docker.com/engine/install/)
- [Java 17+](https://adoptium.net/)
- [Maven 3.8+](https://maven.apache.org/)
- [Postman](https://www.postman.com/) (for API testing)

---

## 🐳 Kafka Setup via Docker

1. **Create `docker-compose.yml` in project root:**

   ```yaml
   version: '3'
   services:
     zookeeper:
       image: wurstmeister/zookeeper
       container_name: zookeeper
       ports:
         - "2181:2181"

     kafka:
       image: wurstmeister/kafka
       container_name: kafka
       ports:
         - "9092:9092"
       environment:
         KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092
         KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
       depends_on:
         - zookeeper
