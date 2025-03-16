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

    public final int tipo;
    public final String texto;

    public Token(int tipo, String texto) {
        this.tipo = tipo;
        this.texto = texto;
    }
}