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
- Make
- Docker

### Iniciar projeto

```shell
$ make run
```

### Finalizar Projeto

```shell
make stop
```
