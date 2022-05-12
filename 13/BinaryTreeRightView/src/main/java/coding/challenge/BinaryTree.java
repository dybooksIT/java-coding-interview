package coding.challenge;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class BinaryTree<T> {
    private Node root = null;

    private class Node {
        private Node left;
        private Node right;

        private final int element;

        private Node(int element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }

        private Node(Node left, Node right, int element) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    /*
              40
            /    \
          47      45
         /  \    /
        11   3  44
       /  \   \
      7    5   9
     /
    2
    */
    private void buildTree() {
        root = new Node(40);
        root.left = new Node(47);
        root.right = new Node(45);
        root.left.left = new Node(11);
        root.left.right = new Node(3);
        root.right.left = new Node(44);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(5);
        root.left.right.right = new Node(9);
        root.left.left.left.left = new Node(2);
    }

    // 반복 기반 접근법: 올바른 트리 형태 출력
    public void printRightViewIterative() {
        buildTree();
        printRightViewIterative(root);
    }

    // 반복 기반 풀이법: 올바른 트리 형태 출력
    private void printRightViewIterative(Node root) {
        if (root == null) {
            return;
        }

        // 루트 노드 삽입
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        Node currentNode;
        while (!queue.isEmpty()) {
            // 현재 레벨의 노드 수는 큐의 크기로 지정됩니다.
            int size = queue.size();

            int i = 0;

            // 현재 레벨의 모든 노드를 순회하고
            // 비어 있지 않은 왼쪽 및 오른쪽 자식을 큐에 넣습니다.
            while (i < size) {
                i++;
                currentNode = queue.poll();

                // 현재 노드가 현재 레벨의 마지막 노드라면 출력합니다.
                if (i == size) {
                    System.out.print(currentNode.element + " ");
                }

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
    }

    // 재귀 기반 풀이법: 올바른 트리 형태 출력
    public void printRightViewRecursive() {
        buildTree();

        // 각 레벨의 마지막 노드를 저장합니다.
        Map<Integer, Integer> map = new HashMap<>();

        // 트리를 순회하면서 Map을 채웁니다.
        printRightViewRecursive(root, 1, map);

        // 올바른 형태의 트리를 출력합니다.
        for (int i = 1; i <= map.size(); i++) {
            System.out.print(map.get(i) + " ");
        }
    }

    // 재귀 기반 풀이법: 올바른 트리 형태 출력
    private void printRightViewRecursive(Node root, int level, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        // 현재 노드와 레벨을 Map에 삽입합니다.
        map.put(level, root.element);

        printRightViewRecursive(root.left, level + 1, map);
        printRightViewRecursive(root.right, level + 1, map);
    }
}