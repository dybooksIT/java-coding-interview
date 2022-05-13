package coding.challenge;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

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
             21
           /    \
          14     45
         /  \     \
        7    3    44
       /  \      /  \
      5    2    9    6
               /
             11
    */
    private void buildTree() {
        root = new Node(21);
        root.left = new Node(14);
        root.right = new Node(45);
        root.left.left = new Node(7);
        root.left.right = new Node(3);
        root.left.left.left = new Node(5);
        root.left.left.right = new Node(2);
        root.right.right = new Node(44);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(6);
        root.right.right.left.left = new Node(11);
    }

    public void verticalSum() {
        // 트리를 생성하는 헬퍼 메서드
        buildTree();

        // 키: 루트에서 현재 노드까지의 수평 거리
        // 값: 동일한 수평 거리에 존재하는 모든 노드의 합
        Map<Integer, Integer> map = new TreeMap<>();

        // 트리 탐색을 사전에 실행하고 map을 채웁니다.
        verticalSum(root, map, 0);

        // 결과를 출력합니다.
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    // 'dist'는 루트부터의 수평 거리를 나타냅니다.
    private void verticalSum(Node root, Map<Integer, Integer> map, int dist) {
        if (root == null) {
            return;
        }

        if (!map.containsKey(dist)) {
            map.put(dist, 0);
        }

        map.put(dist, map.get(dist) + root.element);

        // 함수형 스타일로 구현하려면
        /*
        BiFunction<Integer, Integer, Integer> distFunction
          = (distOld, distNew) -> distOld + distNew;
        map.merge(dist, root.element, distFunction);
        */

        // 수평 거리를 1 감소시키고 왼쪽으로 이동합니다.
        verticalSum(root.left, map, dist - 1);

        // 수평 거리를 1 증가시키고 오른쪽으로 이동합니다.
        verticalSum(root.right, map, dist + 1);
    }
}