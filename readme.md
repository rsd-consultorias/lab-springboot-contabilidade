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

# CURL para testes

## Criar um plano de contas

```bash
curl --location --request PUT 'http://localhost:8080/api/v1/plano-contas/' \
--header 'usuario: ee1b75626e8a405b940b307ee80d00d5' \
--header 'Content-Type: application/json' \
--data-raw '{
            "versao": "202202",
            "dataInicio": "2022-05-31T00:00:00Z",
            "descricao": "Plano de Contas - Exercício 2022"
}'
```

## Alterar um plano de contas

```bash
curl --location --request POST 'http://localhost:8080/api/v1/plano-contas/52ffad72-804a-4231-847c-4371033d1f8e' \
--header 'usuario: ee1b75626e8a405b940b307ee80d00d5' \
--header 'Content-Type: application/json' \
--data-raw '{
    "dataCriacao": "2022-06-24T17:13:03.578933Z",
    "dataAlteracao": "2022-06-24T17:29:54.765936Z",
    "usuarioCriacao": "ee1b75626e8a405b940b307ee80d00d5",
    "usuarioAlteracao": "ee1b75626e8a405b940b307ee80d00d5",
    "versao": "202201",
    "dataInicio": "2022-01-01T00:00:00Z",
    "dataFim": "2022-05-31T00:01:00Z",
    "descricao": "Plano de Contas de Abertura",
    "id": "8dc6fbda-6161-49f3-9a6e-e5b2603ba59e"
}'
```

## Listar planos de contas

```bash
curl --location --request GET 'http://localhost:8080/api/v1/plano-contas/' \
--header 'usuario: ee1b75626e8a405b940b307ee80d00d5'
```