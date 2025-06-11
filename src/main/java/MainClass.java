import dto.Token;
import tree.TreeBuilder;

import java.io.FileReader;
import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {
        try {
            Lexer lexer = new Lexer(new FileReader("src/main/resources/teste.txt"));
            TreeBuilder treeBuilder = new TreeBuilder();
            Token token;

            System.out.println("Tokens encontrados:");
            do {
                token = lexer.nextToken();
                System.out.println(String.format("Tipo: %s, Valor: %s", token.getType(), token.getValue()));
                treeBuilder.processToken(token);
            } while (!token.getType().equals("EOF"));
            System.out.println("\n\n\n\n");
            System.out.println("\nÁrvore Léxica:");
            treeBuilder.getTree().printTree();

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}