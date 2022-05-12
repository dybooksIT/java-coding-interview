package coding.challenge;

import java.util.ArrayDeque;
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

    // 너비 우선 탐색(BFS)을 이용해 트리에 노드 삽입
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

    public void printCorners() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            // 현재 레벨의 크기를 가져옵니다.
            int size = queue.size();
            int position = size;

            System.out.print("Level: " + level + ": ");
            level++;

            // 현재 레벨에 있는 모든 노드를 처리합니다.
            while (position > 0) {
                Node node = queue.poll();
                position--;

                // 양 끝 노드를 발견하면 출력합니다.
                if (position == (size - 1) || position == 0) {
                    System.out.print(node.element + " ");
                }

                // 현재 노드의 왼쪽과 오른쪽 자식을 큐에 삽입합니다.
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            // 레벨 순회를 마칩니다.
            System.out.println();
        }
    }
}