public class  Tree{
    private String[] tree;
    private int capacity;

    public Tree(int size){
        this.capacity = size;
        this.tree = new String[size];
    }

    public void setRoot(String key){
        tree[0] = key;
    } 

    public void setLeft(String key, int parentIndex){
        int leftIndex = (2* parentIndex) + 1;

        if(tree[parentIndex]== null){
            System.out.println("Can't set left child: No parent exists at index" + parentIndex);
            return;
        }
        if(leftIndex < capacity){
            tree[leftIndex] = key;
        }

        else {
            System.out.println("Tree is full! Cannot insert" + key);
        }

    }

    public void setRight(String key, int parentIndex){
        int rightIndex = (2 * parentIndex) + 2;

        if(tree[parentIndex]==null){
            System.out.println("Can't set right chich: No Parent exists at index" + parentIndex);
            return;
        }

        if (rightIndex < capacity){
            tree[rightIndex] = key;
        } else {
            System.out.println("Tree is full! Cannot insert" + key);

        }
    }

    public void printTree(){
        System.out.print("Raw Tree Array: [");
        for (int i = 0; i < capacity; i++){
            if (tree[i] != null){
                System.out.print(tree[i] + " ");
            } else {
                System.out.print("- ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        Tree t = new Tree(10);

        t.setRoot("A");
        t.setLeft("B", 0);
        t.setRight("C", 0);
        t.setLeft("D", 1);
        t.setRight("E", 1);

        t.printTree();
    }

    
}