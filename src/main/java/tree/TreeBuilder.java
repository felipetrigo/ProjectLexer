package tree;

import dto.Token;

import java.util.Stack;

public class TreeBuilder {
    private Stack<TreeNode> nodeStack = new Stack<>();
    private TreeNode root = new TreeNode("PROGRAM", "");

    public TreeBuilder() {
        nodeStack.push(root);
    }

    public void processToken(Token token) {
        TreeNode currentNode = nodeStack.peek();

        switch (token.getType()) {
            case "INT_TYPE":
                TreeNode declNode = new TreeNode("VARIABLE_DECLARATION", "");
                currentNode.addChild(declNode);
                nodeStack.push(declNode);
                declNode.addChild(new TreeNode("TYPE", token.getValue()));
                break;

            case "ID":
                if (currentNode.getType().equals("VARIABLE_DECLARATION")) {
                    currentNode.addChild(new TreeNode("IDENTIFIER", token.getValue()));
                } else {
                    currentNode.addChild(new TreeNode("IDENTIFIER", token.getValue()));
                }
                break;

            case "ASSIGN":
                if (currentNode.getType().equals("VARIABLE_DECLARATION")) {
                    currentNode.addChild(new TreeNode("OPERATOR", token.getValue()));
                } else {
                    TreeNode assignNode = new TreeNode("ASSIGNMENT", "");
                    currentNode.addChild(assignNode);
                    nodeStack.push(assignNode);
                }
                break;

            case "NUMBER":
                currentNode.addChild(new TreeNode("LITERAL", token.getValue()));
                break;

            case "IF":
                TreeNode ifNode = new TreeNode("IF_STATEMENT", "");
                currentNode.addChild(ifNode);
                nodeStack.push(ifNode);
                break;

            case "LPAREN":
                TreeNode condNode = new TreeNode("CONDITION", "");
                currentNode.addChild(condNode);
                nodeStack.push(condNode);
                break;

            case "RPAREN":
                nodeStack.pop(); // Sair da condição
                break;

            case "LBRACE":
                TreeNode blockNode = new TreeNode("BLOCK", "");
                currentNode.addChild(blockNode);
                nodeStack.push(blockNode);
                break;

            case "RBRACE":
                nodeStack.pop(); // Sair do bloco
                if (!nodeStack.isEmpty() &&
                        (nodeStack.peek().getType().equals("IF_STATEMENT") ||
                                nodeStack.peek().getType().equals("BLOCK"))) {
                    nodeStack.pop(); // Sair do nó pai também
                }
                break;

            case "EQ":
            case "PLUS":
                currentNode.addChild(new TreeNode("OPERATOR", token.getValue()));
                break;

            case "SEMICOLON":
                if (!nodeStack.isEmpty() &&
                        (nodeStack.peek().getType().equals("VARIABLE_DECLARATION") ||
                                nodeStack.peek().getType().equals("ASSIGNMENT"))) {
                    nodeStack.pop();
                }
                break;
        }
    }

    public TreeNode getTree() {
        return root;
    }
}