# Desafio Codenation - Java
Desafio da Aceleração em Java - Criptografia de Júlio César

# Introdução

O desafio de aceleração em Java consiste em desenvolver um código com o objetivo de traduzir uma frase com base em informações disponibilizadas pela Codenation, usando a seguinte logica:
- Se a letra da frase cifrada for C, e o número de casas for igual a 1, a letra traduzida será igual a B

## Etapas:

1- Acessar o site disponibilizado pela Codenation, com um token individual

2- Gerar um arquivo .json a partir do site

3- Traduzir a frase disponibilizada no arquivo, com base no número de casas requisitado

4- Gerar uma criptografia extra, chamada Sha1

5- Atualizar o arquivo .json com as informações geradas

6- Enviar o arquivo para outro site, com o mesmo token de acesso

## Resultado

Ao enviar o arquivo, cada participante recebia um score, sendo que a nota máxima e a nota de corte do desafio eram iguais a 100

Nota recebida: 100

## Oportunidades de melhoria

- Somente a requisição GET foi feita diretamente pelo código desenvolvido, sendo que o POST do json foi realizado via Postman

- Criar métodos gerais para a atualização e recebimento de valores das chaves do json, no lugar dos métodos particulares (GetN e GetCypher, por exemplo), para garantir adaptabilidade ao código




