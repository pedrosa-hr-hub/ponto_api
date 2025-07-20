# 📌 Projeto de Marcação de Ponto com Spring Boot

## 💡 Ideia do Projeto

O objetivo é estudar o funcionamento do **Spring Boot** por meio de um exemplo prático: criar um microsserviço para marcações de ponto, que serão armazenadas em um banco de dados e farão parte do ecossistema Saas.

---

## 📦 Estrutura do Projeto

### 🗃️ Model

Contém as classes que representam as entidades do sistema. Essas classes definem a estrutura das tabelas no banco de dados, incluindo atributos e relacionamentos.

### 📁 Repository

Camada responsável por realizar as operações de acesso ao banco de dados. Aqui são criadas as interfaces que estendem `JpaRepository` ou similares, facilitando o uso de CRUD e consultas personalizadas.

### 📤 DTO (Data Transfer Object)

Define os objetos que são trocados entre a API e o sistema. Os DTOs funcionam como uma camada de filtro, separando os dados recebidos pela requisição dos dados realmente salvos no banco — garantindo segurança e clareza na comunicação entre as camadas.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Banco de Dados (ex: PostgreSQL)

---

## 📄 Licença

Projeto com fins educacionais.

---
