# Como rodar

## Requisitos
- mvn (ou use o `./mvnw` incluso no projeto, não precisa ter o Maven instalado);
- java 11;
- MySQL rodando localmente (pode gerenciar pelo MySQL Workbench).

## Passo 1 — Banco de dados

Não é obrigatório criar o banco manualmente — a propriedade `createDatabaseIfNotExist=true`
no `application.properties` já cria o banco `floricultura` automaticamente na primeira
conexão. Se preferir criar manualmente pelo Workbench:

```sql
CREATE DATABASE floricultura;
```

## Passo 2 — Configurar a senha do banco

Abra `src/main/resources/application.properties` e troque:

```properties
spring.datasource.password=SUA_SENHA_AQUI
```

pela senha real do seu usuário MySQL.

## Passo 3 — Execução

Executar comando `./mvnw clean spring-boot:run`

Acesso à API em `http://localhost:8080/flores`

Ao subir, o Hibernate cria automaticamente a tabela `flor` no banco `floricultura`,
e alguns dados de exemplo são inseridos automaticamente.

## Endpoints

| Método | Endpoint              | Descrição                                        |
|--------|------------------------|---------------------------------------------------|
| GET    | `/flores`              | Lista todas as flores                              |
| GET    | `/flores/{id}`         | Busca uma flor por id                              |
| GET    | `/flores/cor/{cor}`    | Lista flores de uma cor (ex: `/flores/cor/Rosa`)   |
| GET    | `/flores?nome=texto`   | Busca flores cujo nome contém o texto              |
| POST   | `/flores`               | Cria uma nova flor                                 |
| PUT    | `/flores/{id}`          | Atualiza (ou cria, se não existir) uma flor        |
| DELETE | `/flores/{id}`          | Remove uma flor                                    |

### Exemplo de corpo para POST/PUT

```json
{
  "nome": "Margarida",
  "cor": "Branca",
  "preco": 5.50,
  "estoque": 100
}
```
