package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private String type;
    private String value;
    private List<TreeNode> children;

    public TreeNode(String type, String value) {
        this.type = type;
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public void printTree() {
        printTree(this, 0);
    }

    private void printTree(TreeNode node, int depth) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append("  ");
        }

        System.out.println(indent + (node.value.isEmpty() ? node.type : node.type + ": " + node.value));

        for (TreeNode child : node.children) {
            printTree(child, depth + 1);
        }
    }
}