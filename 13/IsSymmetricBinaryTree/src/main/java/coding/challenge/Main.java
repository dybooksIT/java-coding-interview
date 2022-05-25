package coding.challenge;

public class Main {
    public static void main(String[] args) {
        /*
              50
            /    \
          45      45
         /  \    /  \
        41   3  3   41
        */
        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.insert(50);
        bt.insert(45);
        bt.insert(45);
        bt.insert(41);
        bt.insert(3);
        bt.insert(3);
        bt.insert(41);

        System.out.println("Symmetry check recursive: " + bt.isSymmetricRecursive());
        System.out.println("Symmetry check iterative: " + bt.isSymmetricIterative());
    }
}