# Desafio Backend Attornatus

Este projeto consiste na criação de uma API usando Spring Boot com as seguintes funcionalidades:

- Criar uma pessoa
- Editar uma pessoa
- Consultar uma pessoa
- Listar pessoas
- Criar endereço para uma pessoa
- Listar endereços de uma pessoa
- Definir o endereço principal de uma pessoa

## Arquitetura e Tecnologias

O projeto utiliza uma arquitetura baseada no padrão Model-Service-Controller-Repository, onde o JpaRepository é usado como ORM (Object-Relational Mapping) para mapear as tabelas do banco de dados com as entidades da aplicação Spring Boot. Um banco de dados em memória H2 foi utilizado para testar os endpoints e seus respectivos métodos.

## Endpoints para Pessoa

### Cadastrar Pessoa

**Requisição POST**

URL: http://localhost:8080/pessoa/criar

Body:
```json
{
    "nome": "João Souza",
    "dataNascimento": "2000-12-12"
}
```

### Editar Pessoa

**Requisição PUT**

URL: http://localhost:8080/pessoa/editar

Body:
```json
{
    "id": 1,
    "nome": "João Souza",
    "dataNascimento": "2000-12-12"
}
```

### Listar Todas as Pessoas

**Requisição GET**

URL: http://localhost:8080/pessoa/consultar

### Listar Pessoa por ID

**Requisição GET**

URL: http://localhost:8080/pessoa/consultar/{id}

## Endpoints para Endereço

### Cadastrar Endereço

**Requisição POST**

URL: http://localhost:8080/endereco/criar

Body:
```json
{
    "logradouro": "Avenida Marechal Neto",
    "cep": "72820200",
    "numero": 150,
    "cidade": "Luziânia",
    "pessoa": {
        "id": 1
    }
}
```

### Listar Todos os Endereços

**Requisição GET**

URL: http://localhost:8080/endereco/consultar

### Listar Endereço por ID

**Requisição GET**

URL: http://localhost:8080/endereco/consultar/{id}

### Listar Endereços por ID da Pessoa

**Requisição GET**

URL: http://localhost:8080/endereco/consultarIdPessoa/{id}

### Definir o Endereço Principal por ID do Endereço

**Requisição PUT**

URL: http://localhost:8080/endereco/mudarPrincipal/{id}
