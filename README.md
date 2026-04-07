# Virtual Threads Spring Boot Demo

Este projeto demonstra o uso de **Virtual Threads** no Spring Boot 3.2+ com Java 21, comparando desempenho com threads tradicionais.

## Endpoints

- `/api/normal` → método bloqueante tradicional
- `/api/virtual` → método usando virtual threads

## Como rodar

1. Build do projeto:
```bash
mvn clean package

java -jar target/virtual-threads-springboot-0.0.1-SNAPSHOT.jar

# Rodar benchmark com k6
cd k6
k6 run test.js