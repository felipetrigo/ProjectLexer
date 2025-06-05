// src/main/resources/lexer.flex

%%

%class Lexer
%unicode
%line
%column
%type dto.Token
%function nextToken

%{
    private dto.Token token(String type, Object value) {
        return new dto.Token(type, value.toString(), yyline, yycolumn);
    }
%}

LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]

Digit = [0-9]
Letter = [a-zA-Z]
Identifier = {Letter}({Letter}|{Digit})*

%%

/* Palavras reservadas */
"if"       { return token("IF", yytext()); }
"else"     { return token("ELSE", yytext()); }
"while"    { return token("WHILE", yytext()); }
"int"      { return token("INT_TYPE", yytext()); }

/* Operadores */
"+"        { return token("PLUS", yytext()); }
"-"        { return token("MINUS", yytext()); }
"*"        { return token("MULT", yytext()); }
"/"        { return token("DIV", yytext()); }
"="        { return token("ASSIGN", yytext()); }
"=="       { return token("EQ", yytext()); }

/* Delimitadores */
"("        { return token("LPAREN", yytext()); }
")"        { return token("RPAREN", yytext()); }
"{"        { return token("LBRACE", yytext()); }
"}"        { return token("RBRACE", yytext()); }
";"        { return token("SEMICOLON", yytext()); }

/* Números e identificadores */
{Digit}+   { return token("NUMBER", yytext()); }
{Identifier} { return token("ID", yytext()); }

/* Espaços em branco */
{WhiteSpace} { /* Ignorar */ }

/* Erro */
.          { System.err.println("Caractere inválido: " + yytext()); }

<<EOF>>    { return token("EOF", "EOF"); }