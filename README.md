## API de controle de horas em atividades

A API permite ao usuário criar uma tarefa, marcar o horário de início e o horário de término, para manter um controle das horas utilizadas em determinada tarefa.

###Execução local

Para executar este projeto localmente é necessário ter o maven instalado e um banco de dados, sendo assim.

É necessário modificar o arquivo hours-control\src\main\resources\application.properties com a configuração do seu banco de dados.

E então utilizar o comando ***mvn springboot:run*** na raiz do projeto.

###Rotas

#### Projects

- **POST** /api/v1/project -> necessita de json na requisição com os campos *projectName* e *projectDescription*. Exemplo de requisição:
```
{
    "projectName" : "Projeto controle de horas",
    "projectDescription" : "projeto para controle de horas em determinado projeto"
}
```

Resposta esperada:
```
{
    "message": "Projeto criado com sucesso"
}
```
- **GET** /api/v1/project/{id} -> retorna os dados de um projeto. Exemplo de resposta:
```
{
    "projectId": 3,
    "projectName": "Projeto controle de horas",
    "projectDescription": "projeto para controle de horas em determinado projeto",
    "tasks": [
        {
            "taskId": 4,
            "taskName": "Iniciar projeto",
            "taskDescription": "Iniciar projeto no start io do springboot",
            "activities": [
                {
                "activityId": 4,
                "description": "teste",
                "startTime": "2022-01-06T18:30:59.013+00:00",
                "endTime": "2022-01-06T18:31:10.223+00:00"
                }
            ]
        }
    ]
}
```


- **GET** /api/v1/project -> retorna todos os projetos. Exemplo de resposta:
````
[
    {
    "projectId": 1,
    "projectName": "Projeto controle de horas",
    "projectDescription": "projeto para controle de horas em determinado projeto",
    "tasks": [
            {
                "taskId": 1,
                "taskName": "Iniciar projeto",
                "taskDescription": "Iniciar projeto no start io do springboot",
                "activities": [
                    {
                        "activityId": 1,
                        "description": "teste",
                        "startTime": "2022-01-06T18:30:59.013+00:00",
                        "endTime": "2022-01-06T18:31:10.223+00:00"
                    }
                ]
            }
        ]
    }
]
````
####Task

- **POST** /api/v1/task -> necessita de json na requisição com os campos *taskName* e *taskDescription*. Exemplo de requisição:

```
{
    "taskName" : "Iniciar projeto",
    "taskDescription" : "Iniciar projeto no start io do springboot"
}
```
Resposta esperada:
```
{
    "message": "Tarefa criada com sucesso"
}
```

- **GET** /api/v1/task/{id} -> retorna os dados da tarefa, como mostrado abaixo.
```
{
    "id": 1,
    "taskName": "Iniciar projeto",
    "taskDescription": "Iniciar projeto no start io do springboot",
    "activities": []
}
```

-**GET** /api/v1/task -> retorna os dados de todas as tarefas. Exemplo de resposta:
```
[
    {
        "id": 1,
        "taskName": "Iniciar projeto",
        "taskDescription": "Iniciar projeto no start io do springboot",
        "activities": []
    }
]
```

- **PUT** /api/v1/task/{id} -> Permite alterar o nome e a descrição da tarefa. Exemplo de requisição:
```
{
    "taskName" : "Criar put request",
    "taskDescription" : "Criar requisição put para as tarefas"
}
```

Resposta esperada:
```
{
    "message": "Tarefa atualizada com sucesso"
}

```
- **Delete** /api/v1/task/{id} -> Exclui uma tarefa.

####Activities

- **POST** /api/v1/activity -> cria uma atividade e marca o início da atividade. Exemplo de requisição:
```
{
    "taskId" : 1
}
```

Em que *taskId* é o id da tarefa relacionada a atividade.
Resposta esperada:
```
{
    "message": "Atividade iniciada com sucesso ",
    "activityId": 1
}
```
- **PATCH** /api/v1/activity/{id} -> Marca o tempo de término da atividade dando a ela uma descrição. Exemplo de requisição:
```
{
    "description" : "teste"
}
```

Resposta esperada:

```
{
    "message": "Atividade encerrada com sucesso"
}

```
- **GET** /api/vi/activity -> Retorna todas as atividades. Exemplo de resposta
```
[
    {
        "activityId": 1,
        "description": "teste",
        "startTime": "2021-12-30T13:19:41.540+00:00",
        "endTime": "2021-12-30T13:20:05.966+00:00"
    }
]
```
- **GET** /api/v1/activity/{id} -> Retorna a atividade correspondente ao id. Exemplo de resposta
```
{
    "activityId": 1,
    "description": "teste",
    "startTime": "2021-12-30T13:19:41.540+00:00",
    "endTime": "2021-12-30T13:20:05.966+00:00"
}
```
- **PUT** /api/v1/activity/{id} -> Altera os dados de uma atividade. Exemplo de requisição:
```
{
    "description" : "testando put",
    "startTime" : "2020-12-30 13:20:00",
    "endTime" : "2020-12-30 14:40:00",
    "taskId" : 1
}
```

Resposta esperada: 

```
{
    "message": "Atividade alterada com sucesso"
}
```
- **Delete** /api/v1/activity/{id} -> Exclui uma atividade.


