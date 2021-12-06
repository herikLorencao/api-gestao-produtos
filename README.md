# API de Gestão de Produtos

## Recursos

- Recuperar um registro por código
- Listar registros (com paginação)
- Inserir, editar e remover produto

## Escopo

- Código do produto (sequencial e não nulo)
- Descrição do produto (não nulo)
- Situação do produto (Ativo ou Inativo)
- Data de fabricação
- Data de validade
- Código do fornecedor
- Descrição do fornecedor
- CNPJ do fornecedor

## Rodando Projeto

Por padrão o projeto roda no endereço:

```
http://localhost:10000
```

### Requisitos

- Java
- Make
- Docker

### Iniciar projeto

```shell
$ make run
```

### Finalizar Projeto

```shell
$ make stop
```

### Endpoints

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/6420672-0c7f8347-351f-4696-8ea8-5ced81962e55?action=collection%2Ffork&collection-url=entityId%3D6420672-0c7f8347-351f-4696-8ea8-5ced81962e55%26entityType%3Dcollection%26workspaceId%3Dd42a8f07-e7ef-4d3f-9e11-92ca5a506bbf#?env%5BAmbiente%5D=W3sia2V5IjoiZGV2VXJsIiwidmFsdWUiOiJsb2NhbGhvc3Q6MTAwMDAiLCJlbmFibGVkIjp0cnVlfV0=)
