# Java Design Patterns with Spring Boot

Projeto desenvolvido durante meus estudos de Java e Spring Boot, com foco na aplicação prática de **Design Patterns** e na integração entre serviços, repositórios e APIs externas.

O projeto é baseado no laboratório de Padrões de Projeto da [Digital Innovation One (DIO)](https://github.com/digitalinnovationone/lab-padroes-projeto-spring), com estudos e adaptações realizados durante o desenvolvimento.

## 🎯 Objetivo

Compreender como os padrões de projeto podem ajudar a organizar o código, reduzir o acoplamento entre componentes e simplificar a comunicação entre diferentes partes de uma aplicação Java.

## 🛠️ Tecnologias utilizadas

- Java 11
- Spring Boot
- Spring Data JPA
- Spring Web
- Spring Cloud OpenFeign
- H2 Database
- Maven
- Swagger / OpenAPI

## 🧩 Conceitos e padrões estudados

### Singleton
O Spring gerencia, por padrão, uma única instância de cada componente `@Service` por contexto de aplicação, facilitando o compartilhamento e a injeção de dependências.

### Strategy
A interface `ClienteService` define um contrato para as operações de negócio relacionadas aos clientes, implementado pela classe `ClienteServiceImpl`.

### Facade
O `ClienteRestController` disponibiliza uma interface REST para acessar as funcionalidades da aplicação, enquanto o método `salvarClienteComCep()` centraliza o fluxo de persistência do cliente e de obtenção do endereço.

### Repository
Com Spring Data JPA, as interfaces `ClienteRepository` e `EnderecoRepository` utilizam `CrudRepository` para disponibilizar operações de persistência sem a necessidade de implementar manualmente cada operação básica.

## ⚙️ Funcionalidades

- Cadastrar clientes.
- Consultar todos os clientes.
- Consultar um cliente pelo ID.
- Atualizar os dados de um cliente.
- Excluir clientes.
- Consultar endereços por CEP utilizando a API ViaCEP.
- Reutilizar endereços já armazenados no banco de dados.

## 🗂️ Estrutura do projeto

```text
src/
└── main/
    ├── java/
    │   └── one/digitalinnovation/gof/
    │       ├── controller/
    │       │   └── ClienteRestController.java
    │       ├── model/
    │       │   ├── Cliente.java
    │       │   ├── ClienteRepository.java
    │       │   ├── Endereco.java
    │       │   └── EnderecoRepository.java
    │       ├── service/
    │       │   ├── ClienteService.java
    │       │   ├── ViaCepService.java
    │       │   └── impl/
    │       │       └── ClienteServiceImpl.java
    │       └── Application.java
    └── resources/
pom.xml
```

## 🚀 Como executar

### Pré-requisitos

- JDK 11 instalado.
- IntelliJ IDEA ou outra IDE compatível com Java.
- Conexão com a internet para consultar a API ViaCEP.

### Executando pelo IntelliJ IDEA

1. Clone este repositório.
2. Abra a pasta do projeto no IntelliJ IDEA.
3. Aguarde o Maven carregar as dependências.
4. Execute a classe `Application.java`.

### Executando pelo terminal

Na pasta raiz do projeto, execute:

**Windows:**

```bash
mvnw.cmd spring-boot:run
```

**Linux / macOS:**

```bash
./mvnw spring-boot:run
```

## 🔗 Endpoints da API

A API utiliza o caminho base `/clientes`.

| Método HTTP | Endpoint | Descrição |
|---|---|---|
| GET | `/clientes` | Lista os clientes |
| GET | `/clientes/{id}` | Consulta um cliente pelo ID |
| POST | `/clientes` | Cadastra um cliente |
| PUT | `/clientes/{id}` | Atualiza um cliente |
| DELETE | `/clientes/{id}` | Exclui um cliente |

Os endpoints devem ser testados com uma ferramenta de requisições HTTP, como Postman ou Insomnia.

## 📚 Aprendizados

Este projeto faz parte da minha evolução nos estudos de Java e desenvolvimento backend. Durante sua implementação, busquei compreender melhor:

- A separação de responsabilidades entre controller, service e repository.
- O uso de interfaces e injeção de dependências.
- A persistência de dados com Spring Data JPA.
- A integração com APIs externas usando OpenFeign.
- A aplicação de padrões de projeto em uma aplicação Spring Boot.

## 👨‍💻 Autor

**Felipe Siqueira Campos**

Estudante de Ciência da Computação, com interesse em desenvolvimento backend, Java e Spring Boot.

- GitHub: [Felpesc](https://github.com/Felpesc)
- Portfólio: [felipe-campos.dev](https://felipe-campos.dev)

---

Projeto para fins educacionais, baseado no laboratório de Design Patterns com Java e Spring da Digital Innovation One.
