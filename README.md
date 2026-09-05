# LAB3-BERTOTI

# 🌷 Dream Fields — API de Floricultura

API REST para gerenciamento do catálogo de flores de uma floricultura, feita com **Spring Boot 2.4.1**, **Spring Data JPA** e **MySQL**, com um front-end simples incluso.

Projeto acadêmico — CRUD completo de flores (criar, listar, buscar, atualizar e remover).

---

## 🧱 Tecnologias utilizadas

- Java 11
- Spring Boot 2.4.1
- Spring Data JPA (Hibernate)
- MySQL
- HTML, CSS e JavaScript puro (front-end)
- Postman (coleção de testes inclusa)

---

## 📋 Pré-requisitos

- **JDK 11+** instalado
- **MySQL** rodando localmente (pode ser gerenciado pelo MySQL Workbench)
- Variável de ambiente **`JAVA_HOME`** configurada apontando para o seu JDK
- Não precisa ter o Maven instalado — o projeto já vem com o Maven Wrapper (`mvnw` / `mvnw.cmd`)

---

## 📁 Estrutura do projeto

```
sbur-rest-demo/
├── mvnw / mvnw.cmd                          # Maven Wrapper
├── pom.xml                                  # Dependências do projeto
├── schema.sql                               # Script SQL equivalente (opcional)
├── dream-fields.postman_collection.json     # Coleção de testes do Postman
└── src/
    ├── main/
    │   ├── java/com/thehecklers/sburrestdemo/
    │   │   ├── SburRestDemoApplication.java  # Classe principal + dados iniciais
    │   │   ├── Flor.java                     # Entidade JPA
    │   │   ├── FlorRepository.java           # Acesso ao banco (Spring Data)
    │   │   └── RestApiDemoController.java    # Endpoints REST
    │   └── resources/
    │       ├── application.properties        # Configuração do banco
    │       └── static/
    │           └── index.html                # Front-end
    └── test/
        └── java/com/thehecklers/sburrestdemo/
            └── SburRestDemoApplicationTests.java
```

---

## ⚙️ Configuração do banco de dados

Não é necessário criar o banco manualmente — a propriedade `createDatabaseIfNotExist=true`
no `application.properties` já cria o banco `floricultura` automaticamente na primeira conexão,
e o Hibernate cria a tabela `flor` sozinho (`ddl-auto=update`).

Antes de rodar, edite `src/main/resources/application.properties` e ajuste a senha:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/floricultura?useSSL=false&serverTimezone=UTC&createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=SUA_SENHA_AQUI
```

Se preferir criar o banco manualmente pelo MySQL Workbench, use o `schema.sql` incluso no projeto.

---

## ▶️ Como rodar

### Pela linha de comando

```bash
./mvnw clean spring-boot:run
```

### Pela IDE (IntelliJ)

Abra `SburRestDemoApplication.java` e clique no botão ▶️ ao lado do método `main()`.

A aplicação sobe em **`http://localhost:8080`**. Ao iniciar, o Hibernate cria a tabela `flor`
e 5 flores de exemplo são inseridas automaticamente (só na primeira vez).

O front-end fica disponível em `http://localhost:8080/` (servido automaticamente pelo Spring Boot).

---

### Exemplo de corpo para POST/PUT

```json
{
  "nome": "Margarida",
  "cor": "Branca",
  "preco": 5.50,
  "estoque": 100
}
```

## 🧪 Testando com o Postman

1. Abra o Postman e clique em **Import**
2. Selecione o arquivo `dream-fields.postman_collection.json` incluso no projeto
3. Confirme que a variável `base_url` está como `http://localhost:8080`
4. Rode primeiro o **"Listar todas as flores"** (GET) para pegar o `id` de uma flor existente
5. Cole esse `id` na variável `flor_id` da coleção — assim as rotas de buscar/atualizar/remover por id já funcionam

Com a aplicação rodando, todas as 7 requisições da coleção (listar, buscar por id, buscar por cor,
buscar por nome, criar, atualizar e remover) podem ser testadas diretamente.

---



## 🚀 Possíveis melhorias futuras

- Autenticação (Spring Security)
- Paginação em `GET /flores` para catálogos grandes
- DTOs separados da entidade JPA
- Versionamento de schema com Flyway/Liquibase
