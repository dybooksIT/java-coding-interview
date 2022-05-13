package coding.challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void leafDistance(int dist) {
        // 트리 만들기
        buildTree();

        // 루트를 단말 노드 경로에 저장하는 리스트
        List<Node> pathToLeaf = new ArrayList<>();

        // 단말 노드를 기준으로 주어진 거리에 있는 고유 노드를 저장하기 위해 빈 집합을 생성합니다.
        Set<Node> nodesAtDist = new HashSet<>();

        // 단말 노드를 기준으로 주어진 거리에 있는 모든 노드를 찾습니다.
        leafDistance(root, pathToLeaf, nodesAtDist, dist);

        // 결과를 출력합니다.
        for (Node nd : nodesAtDist) {
            System.out.print(nd.element + " ");
        }
    }

    private void leafDistance(Node node, List<Node> pathToLeaf,
      Set<Node> nodesAtDist, int dist) {
        if (node == null) {
            return;
        }

        // 각 단말 노드에 대해 거리 'dist'만큼 떨어져 있는 노드를 저장합니다.
        if (isLeaf(node) && pathToLeaf.size() >= dist) {
            nodesAtDist.add(pathToLeaf.get(pathToLeaf.size() - dist));

            return;
        }

        // 현재 경로에 현재 노드를 추가합니다.
        pathToLeaf.add(node);

        // 재귀로 왼쪽 및 오른쪽 하위 트리로 이동합니다.
        leafDistance(node.left, pathToLeaf, nodesAtDist, dist);
        leafDistance(node.right, pathToLeaf, nodesAtDist, dist);

        // 현재 경로에서 현재 노드를 제거합니다.
        pathToLeaf.remove(node);
    }

    private boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
}