-----

# Banco Digital API - Projeto Final Parte 2 (Em desenvolvimento)

## 📋 Descrição

API completa para um sistema bancário digital com operações de clientes, contas e cartões.

-----

## 🚀 Endpoints

### 👤 Clientes

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/clientes` | Criar novo cliente |
| `GET` | `/clientes/{id}` | Obter detalhes de um cliente |
| `PUT` | `/clientes/{id}` | Atualizar informações de um cliente |
| `DELETE` | `/clientes/{id}` | Remover um cliente |
| `GET` | `/clientes` | Listar todos os clientes |

### 💰 Contas

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/contas` | Criar nova conta |
| `GET` | `/contas/{id}` | Obter detalhes de uma conta |
| `POST` | `/contas/{id}/transferencia` | Realizar transferência entre contas |
| `GET` | `/contas/{id}/saldo` | Consultar saldo da conta |
| `POST` | `/contas/{id}/pix` | Realizar pagamento via Pix |
| `POST` | `/contas/{id}/deposito` | Realizar depósito na conta |
| `POST` | `/contas/{id}/saque` | Realizar saque da conta |
| `PUT` | `/contas/{id}/manutencao` | Aplicar taxa de manutenção mensal (corrente) |
| `PUT` | `/contas/{id}/rendimentos` | Aplicar rendimentos (poupança) |

### 💳 Cartões

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/cartoes` | Emitir novo cartão |
| `GET` | `/cartoes/{id}` | Obter detalhes de um cartão |
| `POST` | `/cartoes/{id}/pagamento` | Realizar pagamento com o cartão |
| `PUT` | `/cartoes/{id}/limite` | Alterar limite do cartão |
| `PUT` | `/cartoes/{id}/status` | Ativar/desativar cartão |
| `PUT` | `/cartoes/{id}/senha` | Alterar senha do cartão |
| `GET` | `/cartoes/{id}/fatura` | Consultar fatura do cartão de crédito |
| `POST` | `/cartoes/{id}/fatura/pagamento` | Pagar fatura do cartão de crédito |
| `PUT` | `/cartoes/{id}/limite-diario` | Alterar limite diário do cartão de débito |

-----

## 🛠️ Tecnologias

  * **Java 21**
  * **Spring Boot 3.x**
  * **Spring Data JPA**
  * **H2 Database** (dev) 

-----

## ⚙️ Configuração

### Pré-requisitos

  * **JDK 21+**
  * **Maven 3.8+** ou **Gradle 7.x**

### Instalação

1.  Clone o repositório:

    ```bash
    git clone https://github.com/marcelfagundes/banco-digital-api.git
    ```

2.  Configure o banco de dados (no arquivo `application.properties`):

    ```properties
    # Dev (H2)
    spring.datasource.url=jdbc:h2:mem:banco_digital
    spring.datasource.driverClassName=org.h2.Driver
    spring.h2.console.enabled=true

    # Prod (PostgreSQL)
    # spring.datasource.url=jdbc:postgresql://localhost:5432/banco_digital
    # spring.datasource.username=postgres
    # spring.datasource.password=senha
    ```

3.  Execute a aplicação:

    ```bash
    mvn spring-boot:run
    # ou
    gradle bootRun
    ```

-----

## 📚 Documentação da API (Em desenvolvimento)

Acesse a documentação Swagger em:

```
http://localhost:8080/swagger-ui.html
```

## 🤝 Contribuição

1.  Faça um **fork** do projeto
2.  Crie uma branch para sua feature (`git checkout -b feature/awesome-feature`)
3.  Commit suas mudanças (`git commit -m 'Add awesome feature'`)
4.  Push para a branch (`git push origin feature/awesome-feature`)
5.  Abra um **Pull Request**
