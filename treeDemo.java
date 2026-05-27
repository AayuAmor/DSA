
public class treeDemo {

    private String[] tree;
    private int capacity;

    // Constructor to initialize the tree with a maximum size
    public treeDemo(int size) {
        this.capacity = size;
        this.tree = new String[size];
    }

    // Set the root node
    public void setRoot(String key) {
        tree[0] = key;
    }

    // Set the left child of a parent at a specific index
    public void setLeft(String key, int parentIndex) {
        int leftIndex = (2 * parentIndex) + 1;

        if (tree[parentIndex] == null) {
            System.out.println("Can't set left child: No parent exists at index " + parentIndex);
            return;
        }

        if (leftIndex < capacity) {
            tree[leftIndex] = key;
        } else {
            System.out.println("Tree is full! Cannot insert " + key);
        }
    }

    // Set the right child of a parent at a specific index
    public void setRight(String key, int parentIndex) {
        int rightIndex = (2 * parentIndex) + 2;

        if (tree[parentIndex] == null) {
            System.out.println("Can't set right child: No parent exists at index " + parentIndex);
            return;
        }

        if (rightIndex < capacity) {
            tree[rightIndex] = key;
        } else {
            System.out.println("Tree is full! Cannot insert " + key);
        }
    }

    // Print the raw array representation of the tree
    public void printTree() {
        System.out.print("Raw Tree Array: [ ");
        for (int i = 0; i < capacity; i++) {
            if (tree[i] != null) {
                System.out.print(tree[i] + " ");
            } else {
                System.out.print("- "); // Represents an empty slot
            }
        }
        System.out.println("]");
    }

    // Main method to execute the code
    public static void main(String[] args) {
        // Create a tree with space for 10 nodes
        treeDemo t = new treeDemo(10);

        /* Let's build this tree structure:
                 A (0)
               /       \
             B (1)     C (2)
            /     \
          D (3)   E (4)
         */
        t.setRoot("A");          // Index 0
        t.setLeft("B", 0);       // Index 1 (2*0 + 1)
        t.setRight("C", 0);      // Index 2 (2*0 + 2)

        t.setLeft("D", 1);       // Index 3 (2*1 + 1)
        t.setRight("E", 1);      // Index 4 (2*1 + 2)

        // Print the structural result
        t.printTree();
    }
}
