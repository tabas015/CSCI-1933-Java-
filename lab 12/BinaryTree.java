public class BinaryTree<V extends Comparable<V>> {
    private Node<V> root;
    private V []array;
    public BinaryTree(Node<V> root) {

        this.root = root;
        this.array = (V[]) new Comparable[5];

    }

    public Node<V> getRoot() {
        return this.root;
    }

    public void printInOrder() {
        printInOrderHelper(root);
    }
    private void printInOrderHelper(Node<V> node) {
        if (node != null)
        {
            printInOrderHelper(node.getLeft());
            System.out.print(node.getValue()+" ");
            printInOrderHelper(node.getRight());
        }
        // TODO: Fill in definition
    }

    public void printPreorder(){
        printPreorderHelper(root);
    }
    private void printPreorderHelper(Node<V> node) {
        if (node != null)
        {
            System.out.print(node.getValue()+" ");
            printPreorderHelper(node.getLeft());
            printPreorderHelper(node.getRight());
        }
        // TODO: Fill in definition
    }

    public void printPostorder() {
        printPostorderHelper(root);
    }
    private void printPostorderHelper(Node<V> node) {
        if (node == null) {
            return;
        }
        printPostorderHelper(node.getLeft());
        printPostorderHelper(node.getRight());
        System.out.printf("%s ", node.getValue());

        }

        // TODO: Fill in definition
        private void printPostorderHelper2(Node<V> node) {
            if (node.getRight() == null && node.getLeft() == null) {
                arrayMake(node.getValue());
                return;
            }
            else {
                if (node.getLeft() != null) {
                    printPostorderHelper2(node.getLeft());
                }
                if (node.getRight() != null) {
                    printPostorderHelper2(node.getRight());
                    arrayMake(node.getValue());
                }
            }
        }
    public void arrayMake(V element){
        for(int i = 0; i < array.length;i++){
            if(array[0] == null){
                array[0] = element;
            }
            else if(!array[0].equals(element)&& array[1] == null){
                array[1] = element;
            }
            else if(!array[0].equals(element)&& !array[1].equals(element) && array[2] == null){
                array[2] = element;
            }
            else if(!array[0].equals(element)&& !array[1].equals(element)&& !array[2].equals(element) && array[3]==null){
                array[3] = element;
            }
            else if(!array[0].equals(element)&& !array[1].equals(element)&& !array[2].equals(element) && !array[3].equals(element) && array[4] == null){
                array[4] = element;
            }
            else{

            }
        }
    }

    public V[] flatten() {
       printPostorderHelper2(root);
       for(int i = 0; i <array.length; i++){
           for(int j = 1; j < array.length-i; j++){
               if((array[j]).compareTo((array[j-1])) == -1){
                   V temp = array[j];
                   array[j] = array[j-1];
                   array[j-1] = temp;
               }
           }
       }
        // TODO: Fill in definition

        return array;
    }
    public String Subtree(String s, Node<V> node) {
        Node<V>  nodeCurrent = node;
        if(nodeCurrent != null){
            s += Subtree(s, nodeCurrent.getLeft());
            s += nodeCurrent.getValue();
            s += Subtree(s, nodeCurrent.getRight());
        }
        return s;
    }

    public boolean containsSubtree(BinaryTree<V> other) {
        if(other == null){
            return true;
        }
         String otherString = Subtree("", other.getRoot());
         String rootString =  Subtree("", root);
         return rootString.contains(otherString);

          }




    public static void main (String args[]) {
        // Tree given for testing on
        BinaryTree<Integer> p1Tree = new BinaryTree<Integer>(new Node<Integer>(1,
                new Node<Integer>(2,
                        new Node<Integer>(4, null, null),
                        new Node<Integer>(5, null, null)),
                new Node<Integer>(3, null, null)));

        System.out.println("Milestone 1");
        // Milestone 1
        p1Tree.printInOrder();      // expected output: 4 2 5 1 3
        System.out.println();
        p1Tree.printPreorder();     // expected output: 1 2 4 5 3
        System.out.println();
        p1Tree.printPostorder();    // expected output: 4 5 2 3 1

        System.out.println();

        System.out.println( "\n" + "Milestone 2");
        // Milestone 2 -- expected output: 1 2 3 4 5

        Comparable[] array_representation = p1Tree.flatten();
        for (int i = 0; i < array_representation.length; i++) {
            System.out.print(array_representation[i] + " ");
        }
        System.out.println();

        System.out.println("\n" + "Milestone 3");
//         Milestone 3

        BinaryTree<Integer> p2Tree = new BinaryTree<Integer>(new Node<Integer>(2,
                new Node<Integer>(4, null, null),
                new Node<Integer>(5, null, null)));
        BinaryTree<Integer> p3Tree = new BinaryTree<Integer>(new Node<Integer>(1,
                new Node<Integer>(2, null, null),
                new Node<Integer>(3, null, null)));
        BinaryTree<Integer> p4Tree = null;

        System.out.println(p1Tree.containsSubtree(p2Tree)); // expected output: true
        System.out.println(p1Tree.containsSubtree(p3Tree)); // expected output: false
        System.out.println(p1Tree.containsSubtree(p4Tree)); // expected output: true

    }
}
