# 🏫 Sistema de Gerenciamento de Turmas e Alunos

Uma API REST feita em Java com Spring Boot para gerenciar turmas e alunos de uma escola ficticia, utilizando boas práticas como DTOs, validações e separação de responsabilidades.

---

## 🚀 Funcionalidades

- ✅ Cadastrar uma nova **turma**
- ✅ Listar todas as **turmas**
- ✅ Buscar uma **turma por ID**
- ✅ Atualizar uma **turma**
- ✅ Deletar uma **turma**
- ✅ Adicionar um **aluno** a uma turma
- ✅ Remover um **aluno** de uma turma
- ✅ Listar todos os **alunos**
- ✅ Buscar **aluno por ID**
- ✅ Cadastrar um novo **aluno**
- ✅ Atualizar dados de um aluno
- ✅ (Em planejamento) Cadastro de **notas por aluno**

---

## 🛠 Tecnologias

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- DTO (Data Transfer Object)
- Maven

---

## 📁 Estrutura do Projeto

```
src/
 └── main/
     ├── java/
     │    └── com.mundoatual/
     │         ├── controller/
     │         ├── model/
     │         ├── repository/
     │         ├── service/
     │         └── dto/
     └── resources/
          └── application.properties
```

---

## 📦 Endpoints principais

### 🔹 Turmas

| Método | Rota                      | Descrição                        |
|--------|---------------------------|----------------------------------|
| GET    | `/turma`                  | Lista todas as turmas            |
| GET    | `/turma/{id}`             | Busca uma turma por ID           |
| POST   | `/turma`                  | Cria uma nova turma              |
| PUT    | `/turma/{id}`             | Atualiza os dados da turma       |
| DELETE | `/turma/{id}`             | Deleta uma turma                 |
| PUT    | `/turma/{id}/aluno/{id}`  | Adiciona um aluno à turma        |
| DELETE | `/turma/{id}/aluno/{id}`  | Remove um aluno da turma         |

### 🔹 Alunos

| Método | Rota             | Descrição                    |
|--------|------------------|------------------------------|
| GET    | `/aluno`         | Lista todos os alunos        |
| GET    | `/aluno/{id}`    | Busca um aluno por ID        |
| POST   | `/aluno`         | Cria um novo aluno           |
| PUT    | `/aluno/{id}`    | Atualiza os dados do aluno   |
| DELETE | `/aluno/{id}`    | Deleta os dados do aluno     |

---

## 📌 Exemplos de DTOs

### TurmaDTO

```java
public class TurmaDTO {
    private Long id;
    private String name;
    private List<AlunoModel> alunos;
    // Getters e setters
}
```

### TurmaRequestDTO

```java
public class TurmaRequestDTO {
    private String name;
    // Getters e setters
}
```

---

## ⚙️ Como rodar o projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/Matheus-Aguiarr/cadastro-alunos-api.git
   ```

2. Abra no IntelliJ, Eclipse ou VS Code com suporte Java

3. Rode o projeto 

4. Use o Postman ou Insomnia para testar os endpoints

---

## 🧠 O que aprendi com esse projeto

- Organização de código com **camadas MVC**
- Uso de **DTOs** para manter os dados trafegando de forma segura e limpa
- **Tratamento de erros** com `RuntimeException`
- Integração de **JPA com banco de dados**
- Prática de **RESTful APIs**

---

## 📌 Futuras melhorias

- Adicionar notas aos alunos
- Validações com Bean Validation (`@Valid`)
- Tratamento de erros com `@ControllerAdvice`
- Documentação com Swagger
- Testes unitários e de integração

---

## 🧑‍💻 Autor

**Matheus Aguiar** – Desenvolvedor Java em formação  
🇧🇷 Guarulhos, São Paulo | Desde Dez/2024

---

## 📫 Contato

Se quiser trocar ideia ou dar feedback:

- Email: `matheusaguiardealmeida@gmail.com`
- GitHub: [Matheus-Aguiarr](https://github.com/Matheus-Aguiarr)
- Portfolio: [](https://matheusaguiar.vercel.app)

---

## Finalidade
Projeto unicamente com finalidade educacional, sem fins de uso profissional.
