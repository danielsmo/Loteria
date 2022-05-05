# API DE LOTERIA
## Objetivo do Projeto
O cliente, dono de uma agência lotérica, solicitou que fosse construída uma aplicação web que permitisse os usuários apostarem de forma automática em sua loteria, bastando informar Nome e CPF.

## Tecnologias utilizadas
- Java
- Mysql
- Spring
  - Spring Boot
  - Starter Data JPA
  - Validation
  - Swagger UI

## Especificações
- Devem ser utilizadas duas tabelas, uma para cadastro dos usuários, outra para registro das apostas.
- O número gerado deve conter 4 dígitos e ser gerado de forma automática.
- Não pode haver dois números iguais gerados para o mesmo usuário.
- Deve ser permitido buscar todas as apostas de um usuário específico.

## Pendências
- Documentar a API com Swagger
- Realizar testes unitários com Junit
- Subir a aplicação para AWS
