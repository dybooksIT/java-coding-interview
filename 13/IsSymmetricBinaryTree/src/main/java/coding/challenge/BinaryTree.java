package coding.challenge;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
    private Node root = null;

    private class Node {
        private Node left;
        private Node right;

        private final T element;

        private Node(T element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }

        private Node(Node left, Node right, T element) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    // 너비 우선 탐색(BFS)를 이용해 트리에 노드 삽입
    public boolean insert(T element) {
        if (element == null) {
            return false;
        }

        if (root == null) {
            root = new Node(element);

            return true;
        }

        insert(root, element);

        return true;
    }

    // 너비 우선 탐색(BFS) 알고리즘을 이용해 삽입
    private void insert(Node node, T element) {
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

    // 재귀 기반 풀이법
    public boolean isSymmetricRecursive() {
        if (root == null) {
            return true;
        }

        return isSymmetricRecursive(root.left, root.right);
    }

    private boolean isSymmetricRecursive(Node leftNode, Node rightNode) {
        boolean result = false;

        // 빈 트리는 서로 대칭입니다.
        if (leftNode == null && rightNode == null) {
            result = true;
        }
        
        // 조건 1, 2, 3
        if (leftNode != null && rightNode != null) {
            result = (leftNode.element.equals(rightNode.element))
              && isSymmetricRecursive(leftNode.left, rightNode.right)
              && isSymmetricRecursive(leftNode.right, rightNode.left);
        }

        return result;
    }

    // 반복 기반 풀이법
    public boolean isSymmetricIterative() {
        if (root == null) {
            return true;
        }

        boolean result = false;
        Queue<Node> queue = new LinkedList<>();

        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            Node left = queue.poll();
            Node right = queue.poll();

            if (left == null && right == null) {
                result = true;
            } else if (left == null || right == null || left.element != right.element) {
                result = false;
                break;
            } else {
                queue.offer(left.left);
                queue.offer(right.right);

                queue.offer(left.right);
                queue.offer(right.left);
            }
        }

        return result;
    }
}