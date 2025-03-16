// Definição do analisador léxico

// Seção de código de usuário
%%

// Seção de opções e declarações
%class Lexer
%unicode
%line
%column
%type Token

// Definição de macros
DIGITO = [0-9]
LETRA  = [a-zA-Z]
ID     = {LETRA}({LETRA}|{DIGITO})*

// Estados léxicos (opcional)
%%

// Regras léxicas
"if"       { return new Token(Token.IF, yytext()); }
"else"     { return new Token(Token.ELSE, yytext()); }
"while"    { return new Token(Token.WHILE, yytext()); }
{ID}       { return new Token(Token.ID, yytext()); }
{DIGITO}+  { return new Token(Token.NUMERO, yytext()); }
"+"        { return new Token(Token.MAIS, yytext()); }
"-"        { return new Token(Token.MENOS, yytext()); }
"*"        { return new Token(Token.MULTIPLICACAO, yytext()); }
"/"        { return new Token(Token.DIVISAO, yytext()); }
[ \t\n\r]  { /* Ignorar espaços em branco */ }
.          { throw new Error("Caractere ilegal: " + yytext()); }