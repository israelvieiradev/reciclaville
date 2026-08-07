<p align="center">
  <img src="./images/logo-reciclaville.png"
       alt="Logo do Reciclaville"
       width="400">
</p>

## Sobre:

O Reciclaville, criado em 2025, é uma API desenvolvida em Java e Spring, utilizando PostgreSQL como banco de dados, que possibilita o registro de materiais recicláveis em pontos de coleta pelo país.

## Endpoints

- GET /materiais - lista materiais
- GET /materiais/{id} - lista material pelo id
- POST /materiais - cadastra material
- PUT /materiais/{id} - atualiza material pelo id
- DELETE /materiais/{id} - deleta material pelo id

- GET /clientes - lista clientes
- GET /clientes/{id} - lista cliente pelo id
- POST /clientes - cadastra cliente
- PUT /clientes/{id} - atualiza cliente pelo id
- DELETE /clientes/{id} - deleta cliente pelo id

- GET /declaracoes - lista declaracoes
- GET /declaracoes/{id} - lista declaracao pelo id
- POST /declaracoes - cadastra declaracao
- DELETE /declaracoes/{id} - deleta declaracao pelo id

## Considerações finais

Faz o cadastro de todas as entidades no banco de dados após executado
