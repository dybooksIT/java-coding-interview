package coding.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTree<T> {
    private Node root = null;

    private class Node {
        private Node left;
        private Node right;

        private final T element;

        public Node(T element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }

        public Node(Node left, Node right, T element) {
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

    // 재귀 기반으로 주어진 이진 트리의 대각선 요소를 출력합니다.
    public void printDiagonalRecursive() {
        // 대각선 맵
        Map<Integer, List<T>> map = new HashMap<>();

        // 전위 순회로 트리를 순회하면서 Map을 채웁니다.
        printDiagonal(root, 0, map);

        // 현재 대각선을 출력합니다.
        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.get(i));
        }
    }

    // 트리를 재귀 방식으로 전위 순회하며 Map에 대각선 요소를 넣습니다.
    private void printDiagonal(Node node, int diagonal, Map<Integer, List<T>> map) {
        if (node == null) {
            return;
        }

        // 현재 노드를 대각선에 삽입합니다.
        if (!map.containsKey(diagonal)) {
            map.put(diagonal, new ArrayList<>());
        }

        map.get(diagonal).add(node.element);

        // 대각선을 1만큼 증가시키고 왼쪽 하위 트리로 이동합니다.
        printDiagonal(node.left, diagonal + 1, map);

        // 현재 대각선을 유지하고 오른쪽 하위 트리로 이동합니다.
        printDiagonal(node.right, diagonal, map);
    }

    // 반복 기반으로 주어진 이진 트리의 대각선 요소를 출력합니다.
    public void printDiagonalIterative() {
        Queue<Node> queue = new ArrayDeque<>();

        // 더미 null 값으로 대각선의 끝을 표시합니다.
        Node dummy = new Node(null);

        // 이진 트리에서 첫 번째 대각선의 모든 노드를 큐에 넣습니다.
        while (root != null) {
            queue.add(root);
            root = root.right;
        }

        // 각 대각선에서 마지막에 더미 노드를 큐에 넣습니다.
        queue.add(dummy);

        // 더미만 남을 때까지 반복합니다.
        while (queue.size() != 1) {
            Node front = queue.poll();

            if (front != dummy) {
                // 현재 노드를 출력합니다.
                System.out.print(front.element + " ");

                // 다음 대각선의 노드를 큐에 넣습니다.
                Node node = front.left;
                while (node != null) {
                    queue.add(node);
                    node = node.right;
                }
            } else {
                // 현재 대각선에서 마지막에 더미 노드를 큐에 넣습니다.
                queue.add(dummy);

                System.out.println();
            }
        }
    }
}