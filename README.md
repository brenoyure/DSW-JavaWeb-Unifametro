# Projeto AP1 da Cadeira de Desenvolvimento de Sistemas para Web da Unifametro

Projeto da AP1 do Professor Alandson, hospedado em: https://github.com/brenoyure/DSW-JavaWeb-Unifametro

## Resumo Breve
O projeto é um mini-jogo que recebe 5 números do usuário através de um formulário HTML e apresenta uma página mostrando qual o maior e qual o menor.

1. Ao acessar o url principal do projeto, como localhost:8080/AP1-SW/ o sistema apresentará a tela de boas vindas, e em seguida você será direcionado para a página de cadastro do jogador.
2. O usuário deverá fornecer seu Nome e Idade, esta não podendo ser um número negativo.
3. Após o cadastro o usuário será apresentado à pagina do jogo, em que o usuário escolherá 5 números.
4. Na página seguinte, o jogo apresentará a página de resultados, em que será exibido qual o maior número e qual o menor, com opção de jogar novamente ou voltar à página inicial.

## Requisitos
- Para compilar ou executar. é necessário o Java JDK17 x64

- Para compilar é necessário o Maven;

- Apenas executar, basta algum Servlet Container, como o Tomcat.

## Compilar o Projeto
É necessário o Maven.

- Abra um prompt de comando na pasta raiz (nesta pasta) do projeto e digite, sem as aspas, "mvn clean compile package"

- E pronto, o Maven criará um arquivo AP1-SW.war dentro da pasta target.

## Executar o Projeto
Necessário algum servidor JavaEE ou Servlet Container.
Utilizaremos o Tomcat no passo-a-passo.

- Colocar o arquivo AP1-SW.war que fica na pasta target, dentro da pasta webapps do Tomcat.

- Em seguida, ir na pasta bin do Tomcat e executar o startup.cmd ou startup.sh (dependendo do seu sistema).

- Após este procedimento, basta ir no navegador e digitar localhost:8080/AP1-SW/
