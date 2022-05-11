package coding.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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

    // 너비 우선 탐색(BFS) 알고리즘을 이용해 노드 삽입
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

    public List<List<T>> fetchAllLevels() {
        if (root == null) {
            return Collections.emptyList();
        }

        // 각 리스트는 하나의 레벨을 나타냅니다.
        List<List<T>> allLevels = new ArrayList<>();

        // 첫 번째 레벨은 루트만 포함합니다.
        Queue<Node> currentLevelOfNodes = new ArrayDeque<>();
        List<T> currentLevelOfElements = new ArrayList<>();

        currentLevelOfNodes.add(root);
        currentLevelOfElements.add(root.element);

        while (!currentLevelOfNodes.isEmpty()) {
            // 현재 레벨을 이전 레벨로 저장합니다.
            Queue<Node> previousLevelOfNodes = currentLevelOfNodes;

            // 최종 리스트에 레벨을 추가합니다.
            allLevels.add(currentLevelOfElements);

            // 다음 레벨을 현재 레벨로 설정합니다.
            currentLevelOfNodes = new ArrayDeque<>();
            currentLevelOfElements = new ArrayList<>();

            // 현재 레벨의 모든 노드를 순회합니다.
            for (Node parent : previousLevelOfNodes) {
                if (parent.left != null) {
                    currentLevelOfNodes.add(parent.left);
                    currentLevelOfElements.add(parent.left.element);
                }
                
                if (parent.right != null) {
                    currentLevelOfNodes.add(parent.right);
                    currentLevelOfElements.add(parent.right.element);
                }
            }
        }

        return allLevels;
    }
}