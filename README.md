# DOM House Management

Sistema para gerenciamento doméstico com foco em monitoramento de consumo elétrico residencial.

O objetivo do projeto é permitir o cadastro de casas, cômodos e itens elétricos para possibilitar análises de consumo energético por cômodo e também por residência.

---

# Funcionalidades atuais

Atualmente o sistema possui:

- Cadastro de casas (`HouseHold`)
- CRUD completo de `HouseHold`
- Busca com parâmetro opcional
- Tratamento global de exceções com `ControllerAdvice`

---

# Conceitos do domínio

## HouseHold

Representa uma residência dentro do sistema.

Exemplo:

```json
{
  "description": "Casa 1",
  "observation": "Observação da casa 1",
  "regionalKwhPrice": 0.65
}
```

---

# Estrutura da entidade

| Campo | Tipo | Obrigatório | Descrição |
|---|---|---|---|
| `description` | String | Sim | Nome/descrição da residência |
| `observation` | String | Não | Observações adicionais |
| `regionalKwhPrice` | Double | Sim | Valor regional do kWh |

---

# API

## Base URL

```http
/v1/house-hold
```

---

# Endpoints

## Find All

Retorna todas as casas cadastradas.

### Endpoint

```http
GET /v1/house-hold
```

### Query Parameters

| Parâmetro | Tipo | Obrigatório | Descrição |
|---|---|---|---|
| `q` | String | Não | Realiza busca textual |

### Exemplos

Buscar todos:

```http
GET /v1/house-hold
```

Buscar utilizando query:

```http
GET /v1/house-hold?q=casa
```

### Response

```json
[
  {
    "description": "Casa 1",
    "observation": "Observação",
    "regionalKwhPrice": 0.65
  },
  {
    "description": "Casa 2",
    "observation": "Observação",
    "regionalKwhPrice": 0.65
  }
]
```

### Status

| Código | Descrição |
|---|---|
| `200 OK` | Sucesso |

---

## Find By Id

Retorna uma casa pelo identificador.

### Endpoint

```http
GET /v1/house-hold/{id}
```

### Path Parameters

| Parâmetro | Tipo | Descrição |
|---|---|---|
| `id` | Long | Identificador da casa |

### Exemplo

```http
GET /v1/house-hold/1
```

### Response

```json
{
  "description": "Casa 1",
  "observation": "Observação",
  "regionalKwhPrice": 0.65
}
```

### Status

| Código | Descrição |
|---|---|
| `200 OK` | Sucesso |
| `404 Not Found` | Casa não encontrada |

---

## Create

Cria uma nova casa.

### Endpoint

```http
POST /v1/house-hold
```

### Request Body

```json
{
  "description": "Casa 1",
  "observation": "Observação da casa",
  "regionalKwhPrice": 0.65
}
```

### Response

```json
{
  "id": 1,
  "description": "Casa 1",
  "observation": "Observação da casa",
  "regionalKwhPrice": 0.65
}
```

### Status

| Código | Descrição |
|---|---|
| `201 Created` | Criado com sucesso |
| `400 Bad Request` | Dados inválidos |

---

## Update

Atualiza uma casa existente.

### Endpoint

```http
PUT /v1/house-hold/{id}
```

### Path Parameters

| Parâmetro | Tipo | Descrição |
|---|---|---|
| `id` | Long | Identificador da casa |

### Request Body

```json
{
  "description": "Casa Atualizada",
  "observation": "Nova observação",
  "regionalKwhPrice": 0.72
}
```

### Response

```json
{
  "description": "Casa Atualizada",
  "observation": "Nova observação",
  "regionalKwhPrice": 0.72
}
```

### Status

| Código | Descrição |
|---|---|
| `200 OK` | Atualizado com sucesso |
| `404 Not Found` | Casa não encontrada |
| `400 Bad Request` | Dados inválidos |

---

## Delete

Remove uma casa do sistema.

### Endpoint

```http
DELETE /v1/house-hold/{id}
```

### Path Parameters

| Parâmetro | Tipo | Descrição |
|---|---|---|
| `id` | Long | Identificador da casa |

### Exemplo

```http
DELETE /v1/house-hold/1
```

### Status

| Código | Descrição |
|---|---|
| `204 No Content` | Removido com sucesso |
| `404 Not Found` | Casa não encontrada |

---

# Tratamento de exceções

O projeto possui um `ControllerAdvice` global para tratamento de exceções.

Atualmente está implementado:

- `NotFoundException`

## Exemplo de resposta

```json
{
  "method": "findById",
  "message": "HouseHold not found"
}
```

---

# Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven

---

# Roadmap

Funcionalidades planejadas:

- Cadastro de cômodos
- Cadastro de itens elétricos
- Cálculo de consumo energético
- Consumo por cômodo
- Consumo total da residência
- Relatórios
- Dashboard
- Autenticação
- Testes automatizados

---

# Status do projeto

🚧 Em desenvolvimento