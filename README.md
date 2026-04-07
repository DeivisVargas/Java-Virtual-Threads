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

Estrutura do projeto 
virtual-threads-springboot/
│
├─ src/
│  └─ main/
│     └─ java/com/virtual/virtualThreads/
│        ├─ config/
│        │   └─ AppConfig.java          # ExecutorService de virtual threads
│        ├─ controller/
│        │   └─ TestController.java     # Endpoints /normal e /virtual
│        └─ service/
│            ├─ TestService.java        # Interface
│            └─ TestServiceImpl.java   # Implementação com virtual threads
│
├─ k6/
│  └─ Test.js                           # Script de benchmark
│
├─ pom.xml                              # Maven
└─ README.md                            # Explicação do projeto

Teste utilizando K6 benchmark
CENÁRIO: Teste leve (200 VUs, 100ms I/O)

Requisições completadas:
Normal  | █████████████████████████  5.629
Virtual | ██████████████████████████ 5.654  (+0,44%)

Latência média:
Normal  : 160ms
Virtual : 160ms
Falhas:
Normal  : 0,27%
Virtual : 0,27%

---------------------------------------------------

CENÁRIO: Teste pesado (500 VUs, 500ms I/O)

Requisições completadas:
Normal  | █████████████████████████  5.290
Virtual | ██████████████████████████ 5.435  (+2,74%)

Latência média:
Normal  : 682ms
Virtual : 682ms
Falhas:
Normal  : 4,83%
Virtual : 4,83%