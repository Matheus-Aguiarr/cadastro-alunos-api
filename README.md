# 📚 AlunoAPI - CRUD de Alunos com Spring Boot

Este é um projeto simples de uma API REST desenvolvida com **Spring Boot**. Ele realiza operações de **CRUD (Create, Read, Update, Delete)** para gerenciar informações de alunos.

## 🚀 Funcionalidades

- Criar alunos (`POST /aluno`)
- Listar todos os alunos (`GET /aluno`)
- Atualizar um aluno (`PUT /aluno/{id}`)
- Deletar um aluno (`DELETE /aluno/{id}`)

Cada aluno possui:
- `id` (gerado automaticamente)
- `name` (nome)
- `age` (idade)
- `level` (definido automaticamente com base na idade)

## 🛠️ Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Lombok
- Banco de dados H2 (ou qualquer outro via configuração)

## 📂 Estrutura do projeto

- `AlunoModel` – representa a entidade Aluno.
- `AlunoRepository` – interface que lida com a persistência de dados.
- `AlunoService` – camada de regras de negócio.
- `AlunoController` – endpoints da API.

## 📦 Como rodar o projeto localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/Matheus-Aguiarr/cadastro-alunos-api
   cd cadastro-alunos-api
