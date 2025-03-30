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
INTEIRO = {DIGITO}+
FLOAT = {INTEIRO}\.{INTEIRO}
LETRA  = [a-zA-Z]
ID     = {LETRA}({LETRA}|{DIGITO})*
STRINGGammar = [Ss]tring
CHARGrammar = [Cc]har
FLOATGrammar = [Ff]loat
INTGrammar = [Ii]nt

// Estados léxicos (opcional)
%%

// Regras léxicas
{INTGrammar}      { return new Token(Token.PALAVRA_CHAVE, yytext()); }
{FLOATGrammar}    { return new Token(Token.PALAVRA_CHAVE, yytext()); }
{CHARGrammar}     { return new Token(Token.PALAVRA_CHAVE, yytext()); }
{STRINGGammar}   { return new Token(Token.PALAVRA_CHAVE, yytext()); }

"if"       { return new Token(Token.IF, yytext()); }
"else"     { return new Token(Token.ELSE, yytext()); }
"while"    { return new Token(Token.WHILE, yytext()); }
{ID}       { return new Token(Token.ID, yytext()); }
{INTEIRO}  { return new Token(Token.NUMERO, yytext()); }
{FLOAT}    { return new Token(Token.FLOAT, yytext()); }
'[^']'     { return new Token(Token.STRING, yytext()); }
\"*\"    { return new Token(Token.ASPAS_DUPLAS, yytext()); }
"="        { return new Token(Token.IGUAL, yytext()); }
"+"        { return new Token(Token.MAIS, yytext()); }
"-"        { return new Token(Token.MENOS, yytext()); }
"*"        { return new Token(Token.MULTIPLICACAO, yytext()); }
"/"        { return new Token(Token.DIVISAO, yytext()); }
";"        { return new Token(Token.DELIMITADOR, yytext()); }
[ \t\n\r]  { /* Ignorar espaços em branco */ }
.          { throw new Error("Caractere ilegal: " + yytext()); }