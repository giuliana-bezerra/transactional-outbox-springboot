<h1 align="center">
  Transactional Outbox Spring Boot
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Youtube&message=@giulianabezerra&color=8257E5&labelColor=000000" alt="@giulianabezerra" />
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Video&color=8257E5&labelColor=000000" alt="Video" />
</p>

Projeto apresentado [nesse vídeo](https://youtu.be/0_Fm-xr3LY8) para explicar como utilizar o Pattern Transactional Outbox num projeto Spring Boot e seguindo uma abordagem com CDC.

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [MySQL](https://www.mysql.com)
- [Postgres](https://www.postgresql.org)
- [Docker Compose](https://docs.docker.com/compose/)
- [Kafka](https://kafka.apache.org)
- [Kafka Connect](https://docs.confluent.io/platform/current/connect/index.html)
- [Debezium MySQL Source Connector](https://docs.confluent.io/kafka-connectors/debezium-mysql-source/current/mysql_source_connector_config.html)

## Como Executar

- Iniciar a infra com o docke-compose:
```
docker-compose up -d
```

- Adicionar o conector do mysql:
```
curl -X POST  -H  "Content-Type:application/json" http://localhost:8083/connectors -d @mysql.json
```

- Conferir se o conector foi adicionado com sucesso:
```
http GET :8083/connectors
```

- Iniciar os projetos Java

## API

Os seguintes endpoints estarão disponíveis para cada microsserviço desse projeto:

### posts-service
- POST /posts
```
http POST :8080/posts content='Vídeo novo no canal'
```

- GET /posts
```
http :8080/posts
```

### comments-service
- POST /comments
```
http POST :8081/comments text='Excelente vídeo!' postId=1
```

- GET /comments
```
http :8081/comments
```