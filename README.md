
# Vote API








































## Resumo

API para contagem de votos

A API(vote-api) tem como função ser o backend de um aplicativo mobile, cuja função
é auxiliar no cooperativismo, onde as tomadas de descisões são definidas através de 
votações. O propósito da API é facilitar a criação dessas sessões de votos onde é 
realizado o gerenciamento das mesmas, tendo as tarefas de criação de pautas, associados,
regras como o caso de um indivíduo poder votar uma única vez e o tempo de sessão para
o voto.

No desenvolvimento da API foi definida uma arquitetura que possui Repository, Controller e Model.
Nas classes de Repositório, foi utilizada a extensão JPA Repository para abstrair o 
acesso a dados, e a partir disso uma fácil e objetiva manipulação e tratamento dos dados
através das Controllers. As Models, como padrão, foram usadas para definir as propriedades
das entidades.

&nbsp;

## Documentação - Código e API

Na API, existem os pacotes de Model, Controller, Repository e DTO. Onde cada pacote
armazena classes das quais o próprio nome faz referência. 

Foram criadas três entidades como Models: Schedule(Pauta), Associate(Associado) e Vote(Voto).

Somente duas Controllers foram utilizadas: ScheduleController e AssociateController.
A Controller de Schedule, possui a criação de Votos, onde foi adotado o modelo DTO, para 
ser o voto em si (VoteDTO), tendo como propriedade o associado que votou e se o voto foi Positivo ou
Negativo (Sim ou Não). Possui também a biblioteca de ScheduledExecutorService para fazer
a sessão de voto, onde foi definido a duração de 1 minuto.
E a Controller de Associate possui somente métodos básicos de listagem, criação e buscar por ID.
## API Reference

#### Listar todas as Pautas

```http
  GET /schedules
```

#### Criar Pauta 

```http
  POST /schedules
```

| Payload | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`    | `string` | Nome da pauta |
| `date`    | `date` | Data da pauta (dd/MM/yyyy) |

#### Criar Voto 

```http
  POST /schedules/{id}/votes
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`    | `number` | ID da Pauta |

| Payload | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `associate`    | `number` | ID do Associado |
| `positive`    | `boolean` | Voto (True ou False) |

#### Exibir Pauta 

```http
  GET /schedules/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`    | `number` | ID da Pauta |

#### Listar todos os Associados

```http
  GET /associates
```

#### Criar Associado 

```http
  POST /associates
```

| Payload | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`    | `string` | Nome do Associado |

#### Exibir Associado 

```http
  GET /associates/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`    | `number` | ID do Associado |

  
## Demo

https://ls-vote-api.herokuapp.com

  
