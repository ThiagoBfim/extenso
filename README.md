## Número por extenso

### Objetivo
Projeto com o objetivo de forncer uma API para transformar o número por extenso. 

Idiomas suportados:
* Português
* Inglês

### Modo de uso
#### Como iniciliazar

Para inicializar o projeto é possível executando o arquivo <code>ExtensoApplication</code>

Ou com Docker, para isso é necessário  executar os seguintes comandos:

<code>
mvn clean install
</code>
<br/>
<code>
docker build -f Dockerfile -t thiago/extenso .
</code>
<br/>
<code>
docker run –p 8080:8080 thiago/extenso
</code>

#### Como utilizar

Esse projeto contém a seguinte rota para requisição GET:

* <i>http://localhost:8080/extenso/100</i>
<br/>Retorno : cem

* <i>http://localhost:8080/extenso/100?linguagem=EN</i>
<br/>Retorno : one hundred



### Tecnologias utilizadas:
* Spring Boot
* Spring MVC
* Java 08
