// Definition of a single node in the Linked Tree
class TreeNode {
    String data;
    TreeNode left;
    TreeNode right;

    // Constructor to instantiate a node with data
    public TreeNode(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class TreeLinkedListDemo {
    // The starting point of our tree
    private TreeNode root;

    public TreeLinkedListDemo() {
        this.root = null;
    }

    // Helper method to visually print the tree structure in the terminal
    public void displayTree() {
        printStructure(root, "", true);
    }

    private void printStructure(TreeNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.data);
            printStructure(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printStructure(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    // Main method to construct and test the linked tree
    public static void main(String[] args) {
        TreeLinkedListDemo tree = new TreeLinkedListDemo();

        /* Manually wiring the nodes together via memory links:
                 A
               /   \
              B     C
             / \
            D   E
        */

        // 1. Create the root node
        tree.root = new TreeNode("A");

        // 2. Create and link children to the root
        tree.root.left = new TreeNode("B");
        tree.root.right = new TreeNode("C");

        // 3. Create and link children deeper down the hierarchy
        tree.root.left.left = new TreeNode("D");
        tree.root.left.right = new TreeNode("E");

        // Display the structural link map
        System.out.println("Linked Tree Structure:");
        tree.displayTree();
    }
}