# 📌 Projeto de Marcação de Ponto com Spring Boot

## 💡 Ideia do Projeto

O objetivo é estudar o funcionamento do **Spring Boot** por meio de um exemplo prático: criar um microsserviço para marcações de ponto, que serão armazenadas em um banco de dados e integrarão um ecossistema **SaaS**.

---

## 📦 Estrutura do Projeto

### 🗃️ Model

Contém as classes que representam as entidades do sistema. Essas classes definem a estrutura das tabelas no banco de dados, incluindo atributos e relacionamentos.

### 📁 Repository

Camada responsável por realizar as operações de acesso ao banco de dados. Aqui são definidas as interfaces que estendem `JpaRepository` (ou similares), facilitando a implementação de operações CRUD e consultas personalizadas.

### 📤 DTO (Data Transfer Object)

Define os objetos transferidos entre a API e o sistema. Os DTOs atuam como uma camada de filtragem, separando os dados recebidos nas requisições daqueles que serão efetivamente persistidos no banco — garantindo segurança, controle e clareza na comunicação entre as camadas.

### 🧠 Service

Contém toda a **lógica de negócio** da aplicação. É responsável por processar os dados recebidos, aplicar regras específicas e interagir com as demais camadas, como o Repository.

### 🌐 Controller

Gerencia as **rotas da API**. É o ponto de entrada para as requisições HTTP, encaminhando-as para os serviços apropriados e retornando as respostas correspondentes ao cliente.

---

## 🚀 Tecnologias, Frameworks e Padrões Utilizados

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker
- SQL
- Microsserviços
- DTO
- Kafka
- Kafka UI

---
