class Token {
    public static final int IF = 1;
    public static final int ELSE = 2;
    public static final int WHILE = 3;
    public static final int ID = 4;
    public static final int NUMERO = 5;
    public static final int MAIS = 6;
    public static final int MENOS = 7;
    public static final int MULTIPLICACAO = 8;
    public static final int DIVISAO = 9;
    public static final int DELIMITADOR = 10;
    public static final int FLOAT = 11;
    public static final int STRING = 12;
    public static final int IGUAL = 13;
    public static final int PALAVRA_CHAVE = 14;
    public static final int ASPAS_DUPLAS = 15;
    public static final int E_PARENTESES = 16;
    public static final int R_PARENTESES = 17;
    public static final int MINOR = 18;
    public static final int MINOR_EQUALS = 19;
    public static final int MAJOR = 20;
    public static final int MAJOR_EQUALS = 21;
    public static final int R_KEYS = 22;
    public static final int E_KEYS = 23;
    public final int tipo;
    public final String texto;

    public Token(int tipo, String texto) {
        this.tipo = tipo;
        this.texto = texto;
    }
}