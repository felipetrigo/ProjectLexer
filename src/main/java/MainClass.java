import java.io.FileReader;
import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {
        try {
            Lexer lexer = new Lexer(new FileReader("src/main/resources/teste.codigobom"));
            Token token;
            while ((token = lexer.yylex()) != null) {
                System.out.println("Token: " + token.texto + " Tipo: " + token.tipo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
