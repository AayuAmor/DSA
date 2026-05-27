public class TreeLinkedList{
    private TreeNode root;

    public TreeLinkedList(){
        this.root = null;
    }

public void displayTree() {
        printStructure(root, 0);
    }

    private void printStructure(TreeNode node, int level) {
        if (node != null) {
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(node.data);
            printStructure(node.left, level + 1);
            printStructure(node.right, level + 1);
        }
    }

    public static void main(String[] args) {
        TreeLinkedList tree = new TreeLinkedList();

        tree.root = new TreeNode("A");
        tree.root.left = new TreeNode("B");
        tree.root.right = new TreeNode("C");
        tree.root.left.left = new TreeNode("D");
        tree.root.left.right = new TreeNode("E");

        tree.displayTree();
    }
}