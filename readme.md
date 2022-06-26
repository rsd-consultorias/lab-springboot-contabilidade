# Lab - Contabilidade

Neste projeto a ideia é implementar regras mais próximas de casos reais e entender como organizar o código e a escolha das soluções. O projeto é concentrado em uma API REST sem a preocupação de implementar o front-end e autorização, bem como outros aspectos mais específicos.

# Swagger

Para mais informações [clique aqui](https://www.baeldung.com/spring-rest-openapi-documentation)

## Swagger UI

```
http://localhost:8080/swagger-ui.html
```

## Swagger json

```
http://localhost:8080/v3/api-docs
```

## Swagger yaml

```
http://localhost:8080/v3/api-docs.yaml
```

# Acesso ao banco de dados em memória

## Configuração necessária no application.properies
spring.h2.console.enabled=true

## URL para acessar console

```
usuário: sa
senha: password
banco: rsdcontabilidade

http://localhost:8080/h2-console/
```
# Monitoramento da aplicação

Para mais informações [clique aqui](https://www.baeldung.com/spring-boot-actuators)

## Configuração necessária no application.properties

```
management.endpoints.web.exposure.include=*
```

## URL para acessar métricas

```
http://localhost:8080/actuator
```

# Datas no Node.JS/JavaScript

Gravar a data no formato GMT no banco de dados e converter no front end
para localidade desejada
```bash
new Date().toISOString({timeZone: "GMT"})
> '2022-06-24T10:18:05.147Z'
```

Data GMT para data da localidade desejada no Node.JS/javascript
```bash
new Date("2022-06-24T10:18:05.147Z").toLocaleString("pt-BR", {timeZone: "America/Sao_Paulo"})
> '24/06/2022 07:18:05'
```

Data para data GMT no Node.JS/javascript
```bash
new Date("2022-06-24T10:18:05").toLocaleString("pt-BR", {timeZone: "GMT"})
> '24/06/2022 13:18:05'
```

Data para data GMT formato ISO no Node.JS/javascript
```bash
new Date("2022-06-24T10:18:05").toISOString()
> '2022-06-24T13:18:05.000Z'
```