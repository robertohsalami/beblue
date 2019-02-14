# beblue
Desafio Beblue

- No MySQL criar o database
create database beblue;

- Importar o projeto e adiciona-lo no Tomcat. Start no projeto

- Utilizando o Postman, através da aplicação popular a base com os discos
url:
http://localhost:8081/desafiobeblue/rest/disco/inserirDisco
JSON:
arquivo inserirDiscos

- Utilizando o Postman, através da aplicação inserir dados de cashback
url:
http://localhost:8081/desafiobeblue/rest/cashback/inserirCashback
JSON:
arquivo inserirCashBack

- Testar a operação
Consultar o catálogo de discos de forma paginada, filtrando por gênero e ordenando de forma crescente pelo nome do disco;
url:
http://localhost:8081/desafiobeblue/rest/disco/catalogo/ROCK/1/3

- Testar a operação:
Consultar o disco pelo seu identificador;
url:
http://localhost:8081/desafiobeblue/rest/disco/consultarDisco/14

- Testar a operação:
Registrar uma nova venda de discos calculando o valor total de cashback considerando a tabela.
url:
http://localhost:8081/desafiobeblue/rest/venda/registrarVenda
JSON:
arquivo registrarVenda

- Testar a operação:
Consultar uma venda pelo seu identificador
url:
http://localhost:8081/desafiobeblue/rest/venda/1

- Testar a operação:
url:
Consultar todas as vendas efetuadas de forma paginada, filtrando pelo range de datas (inicial e final) da venda e ordenando de forma decrescente pela data da venda
http://localhost:8081/desafiobeblue/rest/venda/2019-02-14 00:00:00/2019-02-14 23:59:59/1/10


