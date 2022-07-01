package coding.challenge;

public class Main {
    public static void main(String[] args) {
        /*  최대 경로의 합계는 158입니다.
                    50
                /       \
               -2       -1
              / \       / \
            41    3    -7  70
                 /
                -5
        */
        BinaryTree bt = new BinaryTree();

        bt.insert(50);
        bt.insert(-2);
        bt.insert(-1);
        bt.insert(41);
        bt.insert(3);
        bt.insert(-7);
        bt.insert(70);
        bt.insert(0);
        bt.insert(0);
        bt.insert(-5);

        int max = bt.maxPathSum();

        System.out.println("Max: " + max);
    }
}