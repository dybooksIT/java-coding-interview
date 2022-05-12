package coding.challenge;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root = null;
    private int max;

    private class Node {
        private Node left;
        private Node right;

        private final int element;

        public Node(int element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }

        public Node(Node left, Node right, int element) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    // 너비 우선 탐색(BFS)을 이용해 트리에 노드 삽입
    public boolean insert(int element) {
        if (root == null) {
            root = new Node(element);

            return true;
        }

        insert(root, element);

        return true;
    }

    // 너비 우선 탐색(BFS) 알고리즘을 이용해 삽입
    private void insert(Node node, int element) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.peek();
            queue.poll();

            if (node.left == null) {
                node.left = new Node(element);
                break;
            } else {
                queue.add(node.left);
            }

            if (node.right == null) {
                node.right = new Node(element);
                break;
            } else {
                queue.add(node.right);
            }
        }
    }

    public int maxPathSum() {
        maxPathSum(root);

        return max;
    }

    private int maxPathSum(Node root) {
        if (root == null) {
            return 0;
        }

        // 왼쪽 자식 노드의 최댓값과 0 사이의 최댓값
        int left = Math.max(0, maxPathSum(root.left));

        // 오른쪽 자식 노드의 최댓값과 0 사이의 최댓값
        int right = Math.max(0, maxPathSum(root.right));

        // 현재 노드의 최댓값(1, 2, 3, 4의 총 4가지 경우 최댓값)
        max = Math.max(max, left + right + root.element);

        // 왼쪽, 오른쪽 사이의 최댓값과 현재 노드를 반환합니다.
        return Math.max(left, right) + root.element;
    }
}