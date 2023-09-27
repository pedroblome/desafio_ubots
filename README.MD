# Desafui backend Attornatus

Crição de api usando springboot com as as seguintes funcionalidades:
- Criar uma pessoa

- Editar uma pessoa

- Consultar uma pessoa

- Listar pessoas

- Criar endereço para pessoa

- Listar endereços da pessoa

- Poder informar qual endereço é o principal da pessoa

Foi Usado uma arquiteura baseada em Model-Service-Controller-Repository, usando o JpaRepository como orm entre a tabela do banco de dados e as entidades na aplicação sringboot.
Foi usado um banco em memoria h2 apenas para testar os endpoints e seus respectivos metodos.

## Endpoints para Pessoa


### Cadastrar pessoa

Requisição POST

url: http://localhost:8080/pessoa/criar

body:
{"nome": "joao souza",
    "dataNascimento": "2000-12-12"
}



### Editar pessoaRequisição GET
Requisição PUT

url: http://localhost:8080/pessoa/editar

body:

    {
    "id":1,
    "nome": "joao souza",
    "dataNascimento": "2000-12-12"
    }
### Listar todas as pessoas
Requisição GET

url: http://localhost:8080/pessoa/consultar



### Listar pessoa pelo id
Requisição GET

url: http://localhost:8080/pessoa/consultar/{id}


## Endpoints para Endereço

### Cadastrar endereço
Requisição POST

url: http://localhost:8080/endereco/criar

body:

    {
    "logadouro": "avenida Marechal neto",
    "cep": "72820200",
    "numero": 150,
    "cidade": "Luziania",
    "pessoa":{
        "id": 1
    }

### listar todos endereços
Requisição GET

url: http://localhost:8080/endereco/consultar

### listar endereço pelo id
Requisição GET

url: http://localhost:8080/endereco/consultar/{id}

### listar endereços pelo id da pessoa 
Requisição GET

url: http://localhost:8080/endereco/consultarIdPessoa{id}

### informar qual endereço é o principal
Requisição PUT  







