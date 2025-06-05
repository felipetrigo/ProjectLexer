# Analisador Léxico com JFlex

Este projeto é um exemplo simples de um analisador léxico desenvolvido com JFlex dentro do Ubuntu. 
O analisador léxico reconhece padrões básicos em um código-fonte, como palavras-chave, 
identificadores, números inteiros e operadores aritméticos laços e condicionais.

## Requisitos

- Intellij IDEA Community Edition
- Java Development Kit (JDK) 11 ou superior
- JFlex (instalado e configurado no ubuntu)

## Instalação jflex

abra o terminal com o comando ``` ctrl + alt + T ``` ou busque pelo app na barra de pesquisa
no terminal insira o codigo
bash
```bash 
sudo apt install jflex
```
e pronto após a instalação você esta pronto para desenvolver compiladores.
## Como foi feito

o compilador gerado foi através do arquivo ```src/main/resources/MeuCompilador.flex ```
usando o comando abaixo na pasta do arquivo
```bash
jflex lexer.flex
```
que por sua vez gerou o arquivo ```Lexer.java``` que usei na classe principal para 
identificar os tokens no arquivo teste.codigobom.

## Como seguir para execução

### Passo 1: Clonar o repositório

Clone este repositório para o seu ambiente local:

```bash
git clone https://github.com/seu-usuario/analisador-lexico-jflex.git
```
### Passo 2: Executar
após o clone abra o intellij e selecione o seu projeto na pasta de clone e execute a classe MainClass.

Atentamente<br>
Felipe Knöner Trigo