<p align="center">
  <img align="center" src="./images/logo-reciclaville.png"
       alt="Logo do Reciclaville"
       width="400">
</p>

## Sobre:

O Reciclaville, criado em 2025, é uma API desenvolvida com JDK 24.0.2 e Spring, utilizando PostgreSQL como banco de dados, que possibilita o registro de materiais recicláveis em pontos de coleta pelo país.

## Execução

- IDE utilizada IntelliJ IDEA 2025.2.1:
    https://www.jetbrains.com/pt-br/idea/download/?section=windows
- Para utilizar os endpoints da API use Postman ou Insomnia:
    https://www.postman.com/downloads/

- **Porta de acesso do Spring**
    ```mermaid
    http://localhost:8080
    ```

### Endpoints

- GET /materiais - lista materiais
- GET /materiais/{id} - lista material pelo id
- POST /materiais - cadastra material
- PUT /materiais/{id} - atualiza material pelo id
- DELETE /materiais/{id} - deleta material pelo id

    **Exemplo GET**
`http://localhost:8080/materiais`

    **Exemplo de resposta**
```json
    {
      "id": 1,
      "nome": "Papel",
      "percCompensacaoMaterial": 10
    }
```

- GET /clientes - lista clientes
- GET /clientes/{id} - lista cliente pelo id
- POST /clientes - cadastra cliente
- PUT /clientes/{id} - atualiza cliente pelo id
- DELETE /clientes/{id} - deleta cliente pelo id

  **Exemplo PUT**
`http://localhost:8080/clientes/1`

- GET /declaracoes - lista declaracoes
- GET /declaracoes/{id} - lista declaracao pelo id
- POST /declaracoes - cadastra declaracao
- DELETE /declaracoes/{id} - deleta declaracao pelo id

## Considerações finais

Faz o cadastro de todas as entidades no banco de dados após executado
