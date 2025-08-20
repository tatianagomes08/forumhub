# ForumHub

## Status do Projeto
✔️ Entregue

## Índice
- [Descrição do Projeto](#descrição-do-projeto)
- [Funcionalidades](#funcionalidades)
- [Como Usar](#como-usar)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Desenvolvedora](#desenvolvedores)

## Descrição do Projeto
ForumHub é uma REST API em Java para gerenciar tópicos de um fórum, permitindo gerenciar esses tópicos via requisições HTTP. A API também conta com controle de acesso implementado de modo a garantir que usuários não permitidos não consigam fazer nada na API.

## Funcionalidades
- Criar um tópico -> POST /topicos
- Alterar um tópico -> PUT /topicos/{id}
- Listar tópicos já cadastrados -> GET /topicos
- Detalhar um tópico -> GET /topicos/{id}
- Excluir um tópido -> DELETE /topicos/{id}
- Efetuar login - POST /login

## Como Usar

```bash
# Clone o repositório
git clone https://github.com/tatianagomes08/literalura.git

# Abra o projeto na IDE de preferência como IntelliJ e clique em executar

# Efetue requisições via Postman ou outro software similar para o domínio http://localhost:8080/ e o complemento descrito na seção anterior
```

A API ainda não tem endpoint de cadastro de usuários. Então, para testar será preciso que cadastre na tabela usuarios do banco de dados um login e senha.
A senha deve ser encryptada usando BCrypt, pois é como o projeto foi implementado.

Para criação e alteração, todos os campos são obrigatórios, sendo que na alteração é possível enviar uma alteração de estado do tópico.

Abaixo exemplos de requests da API.

POST /topicos

```json
{
    "autor": "nome do autor",
    "mensagem": "corpo da mensagem do tópico",
    "titulo": "titulo do tópico",
    "curso": "nome do curso"
}
```
PUT /topicos/{id}

```json
{
    "autor": "nome do autor",
    "mensagem": "corpo da mensagem do tópico",
    "titulo": "titulo do tópico",
    "curso": "nome do curso",
    "estadoTopico": "CLOSED" //opcional
}
```

Nas respostas de GET, POST e PUT são retornados o mesmo corpo. O id e a dataCriacao são gerados somente no momento do POST e nunca mais são alterados. Na criação um POST nasce com estado "OPEN" e pode ser alterado no PUT.

Exemplo de resposta:

```json
{
    "id": 1,
    "autor": "nome do autor",
    "mensagem": "corpo da mensagem do tópico",
    "titulo": "titulo do tópico",
    "curso": "nome do curso",
    "estadoTopico": "OPEN",
    "dataCriacao": "2025-08-19T23:39:14.309+00:00"
}
```

Além disso, para toda requisição é necessário enviar um token JWT no header Authorization. Para conseguir esse token basta fazer o request para:

POST /login

```json
{
    "login": "login",
    "senha": "senha aberta" //o código faz a criptografia para confirmar no banco de dados
}
```

Resposta:

```json
{
    "token": "token JWT gerado com validade de 2 horas"
}
```

## Tecnologias Utilizadas 🛠️

- **Java** — Linguagem principal utilizada no desenvolvimento.
- **Maven** — Gerenciador de dependências e build do projeto.
- **Spring Boot** — Para facilitar a configuração e execução da aplicação.
- **JPA / Hibernate** — Para mapeamento objeto-relacional.
- **Banco de Dados** — MySQL.
- **IDE** — IntelliJ IDEA.
- **Git & GitHub** — Controle de versão e hospedagem do código.

## Desenvolvedora
- Tatiana Gomes - [GitHub](https://github.com/tatianagomes08)
