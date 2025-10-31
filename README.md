# 🧵 Kafka Order Producer — Spring Boot Demo

A **Spring Boot Kafka Producer** example that demonstrates how to send `Order` events to a Kafka topic using a **Dockerized Kafka and Zookeeper** setup.  
This project is designed for **learning and reference purposes**, showing how to integrate **Apache Kafka with Spring Boot** in a clean, modular, and enterprise-style way.

---

## 📚 Table of Contents
- [Overview](#-overview)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Setup Instructions](#️-setup-instructions)
- [Run the Application](#-run-the-application)
- [Test Kafka via CLI](#-test-kafka-via-cli)
- [Sample Output](#-sample-output)
- [Running Multiple Instances](#-running-multiple-instances)
- [Next Steps](#-next-steps)
- [Author](#-author)
- [License](#-license)

---

## 🧩 Overview

This microservice acts as a **Kafka Producer** that sends `Order` data to a topic named **`order-topic`**.  
It uses `KafkaTemplate` for message publishing and is pre-configured for a **local Docker-based Kafka setup**.

---

## 🧰 Tech Stack

| Tool | Description |
|------|--------------|
| ☕ **Java 17** | Core programming language |
| 🌱 **Spring Boot 3.x** | Framework for microservices |
| 🐘 **Apache Kafka** | Distributed event streaming platform |
| 🐳 **Docker & Docker Compose** | Containerization & orchestration |
| 🧩 **Lombok** | Reduces boilerplate code |
| 🧱 **Maven** | Dependency management |

---

## 🏗️ Project Structure



---

## ⚙️ Setup Instructions

2️⃣ Start Kafka and Zookeeper via Docker
sudo docker-compose up -d

3️⃣ Verify Running Containers
sudo docker ps


✅ You should see:

wurstmeister/zookeeper

wurstmeister/kafka

🚀 Run the Application
Using Maven Wrapper
./mvnw spring-boot:run

Or, if Maven is installed globally
mvn spring-boot:run

The application will start at:
👉 http://localhost:8080

You’ll see logs showing Kafka message production and consumption.

🧪 Test Kafka via CLI

Once Kafka and Zookeeper are running, test Kafka manually using Docker CLI commands.

1️⃣ List Topics
sudo docker exec -it kafka kafka-topics.sh --list --bootstrap-server localhost:9092

2️⃣ Create a Topic (if not already present)
sudo docker exec -it kafka kafka-topics.sh \
  --create \
  --topic order-topic \
  --bootstrap-server localhost:9092 \
  --partitions 1 \
  --replication-factor 1

3️⃣ Produce Messages
sudo docker exec -it kafka kafka-console-producer.sh \
  --broker-list localhost:9092 \
  --topic order-topic


Type messages like:

hello kafka
order test

4️⃣ Consume Messages
sudo docker exec -it kafka kafka-console-consumer.sh \
  --bootstrap-server localhost:9092 \
  --topic order-topic \
  --from-beginning


✅ You should see messages produced from either the CLI or your Spring Boot app.

📦 Sample Output

From Spring Boot App:

✅ Sent to Kafka: Order(orderId=1, product=Laptop, quantity=2)
📥 Received from Kafka: Order(orderId=1, product=Laptop, quantity=2)


From CLI Consumer:

hello kafka
order test

🪄 Running Multiple Instances

To simulate multiple consumer instances (Kafka load balancing):

In IntelliJ IDEA, duplicate your run configuration.

Rename one as:

KafkaDemo-Instance1


Add program argument:

--spring.profiles.active=default


Rename the duplicate as:

KafkaDemo-Instance2


Add program argument:

--spring.profiles.active=instance2


✅ Run both — each will have its own console logs.
Kafka will automatically assign partitions between the two instances for parallel message consumption.

🚧 Next Steps

Add a Kafka Consumer microservice

Implement error handling and retry logic

Add Schema Registry and Avro serialization

Containerize with Dockerfile for deployment

Deploy on Kubernetes or AWS ECS

👨‍💻 Author

Pradeep Kumar Maurya
💼 Java Developer | ☕ Spring Boot | ⚙️ Microservices | 🧠 Kafka & Cloud Enthusiast
