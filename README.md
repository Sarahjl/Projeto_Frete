API para calculo de frete.

Essa API consome a API https://github.com/JoaoEnrique/spring-boot-pokemon na branch `feature-frete` 

#
## `POST /api/v1/frete`

Busca usuário por ID e calcula frete pelo estado retornado pela API

Body
```json
{
    "idUser": "string"
}
```

Response
```json
{
    "id": "e5d67479-c945-4ce9-ab20-4638d31c7670",
    "user": "0b69b56f-13bc-4e60-9e5b-a5a02888d65d",
    "status": "PROCESSANDO",
    "valor": "FRETE GRATIS"
}
```

#
## `GET /api/v1/frete/{id}`

Busca dados do frete pelo ID

Response
```json
{
    "id": "e5d67479-c945-4ce9-ab20-4638d31c7670",
    "user": "0b69b56f-13bc-4e60-9e5b-a5a02888d65d",
    "status": "PROCESSANDO",
    "valor": "FRETE GRATIS"
}
```


#
## `GET /api/v1/frete/by-iduser/{id}`

Busca dados de todos os fretes de um usuário

Response
```json
[
    {
        "id": "71c938e3-a071-4fcd-8f6d-fc5f847285f2",
        "idUser": "0b69b56f-13bc-4e60-9e5b-a5a02888d65d",
        "status": "PROCESSANDO",
        "valor": "FRETE GRATIS"
    },
    {
        "id": "04a59d25-c342-4484-bae2-1fa0329ea0ff",
        "idUser": "0b69b56f-13bc-4e60-9e5b-a5a02888d65d",
        "status": "PROCESSANDO",
        "valor": "FRETE GRATIS"
    }
]
```
