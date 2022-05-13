package coding.challenge;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BinarySearchTree {
    private Node root = null;

    private class Node {
        private final int element;

        private Node left;
        private Node right;

        public Node(Node left, Node right, int element) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    public boolean insert(int element) {
        root = insert(root, element);
        return true;
    }

    private Node insert(Node current, int element) {
        if (current == null) {
            return new Node(null, null, element);
        }

        if (element < current.element) {
            current.left = insert(current.left, element);
        } else {
            current.right = insert(current.right, element);
        }

        return current;
    }

    // 해싱을 이용한 구현
    public boolean findPairSumHashing(int sum) {
        if (sum <= 0) {
            return false;
        }

        return findPairSumHashing(root, sum, new HashSet());
    }

    private static boolean findPairSumHashing(Node node, int sum, Set<Integer> set) {
        // 종료 조건
        if (node == null) {
            return false;
        }

        // 왼쪽 하위 트리에서 쌍을 찾습니다.
        if (findPairSumHashing(node.left, sum, set)) {
            return true;
        }

        // 현재 노드와 쌍을 이루면 쌍을 출력하세요.
        if (set.contains(sum - node.element)) {
            System.out.print("\nPair (" + (sum - node.element) + ", "
              + node.element + ") = " + sum);
            return true;
        } else {
            set.add(node.element);
        }

        // 오른쪽 하위 트리에서 쌍을 찾습니다.
        return findPairSumHashing(node.right, sum, set);
    }

    // 2개의 스택을 사용한 구현
    public boolean findPairSumTwoStacks(int sum) {
        if (sum <= 0 || root == null) {
            return false;
        }

        return findPairSumTwoStacks(root, sum);
    }

    private static boolean findPairSumTwoStacks(Node node, int sum) {
        Stack<Node> fio = new Stack<>(); // fio - 정방향 중위 순회
        Stack<Node> rio = new Stack<>();  // rio - 역방향 중위 순회

        Node minNode = node;
        Node maxNode = node;

        while (!fio.isEmpty() || !rio.isEmpty()
          || minNode != null || maxNode != null) {
            if (minNode != null || maxNode != null) {
                if (minNode != null) {
                    fio.push(minNode);
                    minNode = minNode.left;
                }

                if (maxNode != null) {
                    rio.push(maxNode);
                    maxNode = maxNode.right;
                }
            } else {
                int elem1 = fio.peek().element;
                int elem2 = rio.peek().element;

                if (fio.peek() == rio.peek()) {
                    break;
                }

                if ((elem1 + elem2) == sum) {
                    System.out.print("\nPair (" + elem1 + ", " + elem2 + ") = " + sum);
                    return true;
                }

                if ((elem1 + elem2) < sum) {
                    minNode = fio.pop();
                    minNode = minNode.right;
                } else {
                    maxNode = rio.pop();
                    maxNode = maxNode.left;
                }
            }
        }

        return false;
    }

    // 트리를 출력해야 하면 printInOrder 메서드를 사용하세요.
    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(" " + node.element);
            printInOrder(node.right);
        }
    }
}