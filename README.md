# 📘 Projeto Spring Boot – Usuários e Cursos

Este projeto é uma aplicação **Spring Boot** que implementa uma API REST simples para **gerenciamento de usuários** e **cursos**, utilizando **JPA/Hibernate** para persistência de dados e seguindo uma arquitetura organizada em camadas.

---

## 🚀 Tecnologias Utilizadas

- Java  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Jakarta Persistence (JPA)  
- Maven  
- Banco de dados relacional (MySQL, H2, PostgreSQL, etc.)

---

## 🧩 Models (Entities)

### 👤 User
Representa um usuário do sistema.

**Tabela:** `tab_user`

**Atributos:**
- `id`
- `name`
- `username`
- `password`

---

### 📚 Conteudo (Classe Abstrata)

Classe base para conteúdos educacionais.

**Atributos:**
- `titulo`
- `descricao`

**Método abstrato:**
```java
🌐 Endpoints da API
👤 UserController (/user)
🔍 Buscar usuário por ID
GET /user/{id}

➕ Cadastrar usuário
POST /user


Body (JSON):

{
  "name": "João",
  "username": "joao123",
  "password": "123456"
}

🔐 Login
POST /user/login


Body (JSON):

{
  "username": "joao123",
  "password": "123456"
}

🎓 CursoController (/curso)
➕ Cadastrar curso
POST /curso

🔍 Buscar curso por ID
GET /curso/{id}




