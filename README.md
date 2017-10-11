# Avaliação Técnica

[![drawing](https://i1.wp.com/novidadesdetudo.com.br/wp-content/uploads/2015/09/SOLICITAR-CART%C3%83O-CALCARD.png?fit=347%2C222)](http://www.calcard.com.br/)

Desenvolver uma aplicação web que realize o cadastro de proposta de crédito para um determinado cliente, efetue a análise de dados e efetive a aprovação ou negação de um limite de crédito para o mesmo.

A proposta de crédito consiste em um formulário contendo informações de cadastro de cliente. Ex.: nome, idade, sexo, renda.
A partir deste cadastro é possível criar um algoritmo de análise para avaliar e decidir um limite de crédito para o cliente cadastrado.

  - O sistema deve realizar a análise do cliente baseado nas informações cadastrais da proposta.
  - O sistema deve gravar o cadastro da proposta no banco de dados.
  - O sistema deve efetuar a tomada de decisão da proposta, aprovando-a ou negando-a.   
  - Após o cadastro da proposta e tomada de decisão, o sistema deve apresentar o resultado da análise. 
  - Aprovação da proposta deve estar composta com valor de limite de crédito sugerido pelo sistema.
  - A Negação deve estar composta pelo motivo da não aprovação.
  - O sistema deve permitir a consulta de aprovação/negação do cliente pelo cpf.
  - Dados de entrada do formulário: Nome, idade, sexo, estado civil, dependentes, estado, ocupação, renda mensal.

### Requisitos

  - Frontend: [AngularJS 1.6], [Html5], [Bootstrap]
  - Backend: [Java], [Spring-boot]
  - Integrações: [Rest] conceito Restful
  - Documentação: [Swagger]
  - Banco de dados: [H2-DB] 


### Resultado da Análise  

| NOME   | IDADE  | SEXO   | ESTADO CIVIL | DEPENDENTES | ESTADO | OCUPAÇÃO  | RENDA  |        | ANÁLISE   | LIMITE | 
| ------ | ------ | ------ | ------       | ------      | ------ | ------    | ------ | ------ | ------    | ------ |        
| Lucas	 | 28     | M      | solteiro     |	0	        | SC	 | autonomo	 | 3000   |	       | Aprovado  | entre 1000 - 1500 |
| Ana	 | 17     | F	   | solteiro     |	0	        | SP	 | estudante | 500    |	       | Aprovado  | entre 100 - 200   |
| Pedro	 | 68     | M      | casado	      | 4	        | SC	 | aposentado| 5000   |	       | Aprovado  | entre 1000 - 1200 |
| Paula	 | 61     | F      | casado	      | 3	        | RJ	 | professor | 5000   |	       | Aprovado  | entre 1000 - 1500 |
| João	 | 56     | M      | divorciado   |	2	        | RJ	 | autonomo	 | 2000   |	       | Reprovado ||	
| Maria	 | 45     | F      | viuva	      | 1	        | SP	 | professor | 2000   |	       | Reprovado ||
| José	 | 30     | M      | divorciado   |	2	        | MA	 | médico	 | 8000   |	       | Aprovado  | entre 4000 - 5500 |
| Dinae  | 33     | F      | casado	      | 1	        | SP	 | médico	 | 10000  |	       | Aprovado  | superior 6000     |
| Marcos | 19     | M      | solteiro     |	1	        | SC	 | estudante | 400    |	       | Reprovado ||	
| Suzan  | 63     | F      | viuva	      | 3	        | MA	 | aposentado| 1500   |	       | Reprovado ||


### Arquitetura

  - Frontend/Backend.
  - Backend com conceito de Api contendo documentação swagger dos endpoints.
  - Aplicação frontend deverá se comunicar com o backend via rest.
  - O backend deverá realizar as integrações via rest com as demais APIs.
  - O sistema deverá conter uma aplicação FrontEnd e duas APIs Backend.
  - API para gravação e consulta das propostas.
  - API motor de crédito que efetuará a análise da proposta e realizará a tomada de decisão do limite de crédito.
  - Aplicação Frontend.

### Desafios

  - Criar inteligência de decisão do motor de crédito.
  - Disponibilizar o projeto com configurações para execução em docker. 

### Observações 

> A apresentação dos dados no frontend é livre.
> Padrões de projeto, código limpo, melhores práticas, documentação swagger e documentação do código fazem parte do escopo do projeto.
> A criação do algoritmo de análise de crédito e tomada de decisão é responsabilidade do desenvolvedor. A criatividade será avaliada.  
> Disponibilizar documentação para execução do sistema.
> Surpreenda-nos. 
  
### Publicação

O projeto deve estar documentado e publicado no github.
Favor nos enviar o endereço do repositório do projeto para o e-mail: 


License
----

Calcard Administradora de Cartões


**Boa sorte!**

   [AngularJS 1.6]: <http://angularjs.org>	
   [Html5]: <https://www.w3.org/TR/html5/>
   [Bootstrap]: <http://getbootstrap.com/>
   [Java]: <http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html>
   [Spring-boot]: <https://projects.spring.io/spring-boot/>
   [Rest]: <https://www.w3.org/2001/sw/wiki/REST>
   [Swagger]: <https://swagger.io/>
   [H2-DB]: <http://www.h2database.com/html/main.html>   
   