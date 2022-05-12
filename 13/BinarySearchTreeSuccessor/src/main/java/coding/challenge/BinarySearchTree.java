package coding.challenge;

public class BinarySearchTree {
    private Node root = null;

    private class Node {
        private final int element;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int element) {
            this.element = element;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    public void buildTreeSample() {
        root = new Node(70);
        Node n2 = new Node(50);
        Node n3 = new Node(75);
        Node n4 = new Node(40);
        Node n5 = new Node(55);
        Node n6 = new Node(72);
        Node n7 = new Node(77);
        Node n8 = new Node(35);
        Node n9 = new Node(54);
        Node n10 = new Node(60);
        Node n11 = new Node(58);
        Node n12 = new Node(59);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n4.left = n8;

        n5.left = n9;
        n5.right = n10;

        n10.left = n11;

        n11.right = n12;

        n2.parent = root;
        n3.parent = root;

        n4.parent = n2;
        n5.parent = n2;
        n6.parent = n3;
        n7.parent = n3;

        n8.parent = n4;
        n9.parent = n5;
        n10.parent = n5;
        n11.parent = n10;
        n12.parent = n11;
    }

    public void inOrderSuccessor() {
        // n12 노드를 선택합니다(요소 59가 있는 노드).
        Node node = root.left.right.right.left.right;

        System.out.println("\n\nIn-Order:");
        System.out.print("Start node: " + node.element);
        node = inOrderSuccessor(node);
        System.out.print(" Successor node: " + node.element);
    }

    private Node inOrderSuccessor(Node node) {
        if (node == null) {
            return null;
        }

        // (a)의 경우: 'node'에 오른쪽 하위 트리가 있고,
        // 오른쪽 하위 트리의 가장 왼쪽 노드를 반환합니다.
        if (node.right != null) {
            return findLeftmostNode(node.right);
        }

        // (b)의 경우 : 'node'에 오른쪽 하위 트리가 없습니다.
        // (b.1)의 경우: 'node'는 부모 노드의 왼쪽 자식 노드이며, 부모 노드를 반환합니다.
        // (b.2)의 경우: 'node'는 부모 노드의 오른쪽 자식 노드입니다.
        // 'node'가 부모노드의 왼쪽 자식 노드가 될 때까지 'node'는 위쪽으로 이동한 다음 부모 노드를 반환합니다.
        // (c)의 경우: 'node'는 순회했을 때의 마지막 노드입니다. 루트의 부모 노드를 반환합니다(예: null).
        while (node.parent != null && node.parent.right == node) {
            node = node.parent;
        }

        return node.parent;
    }

    public void preOrderSuccessor() {
        // n12 노드를 선택합니다(요소 59가 있는 노드).
        Node node = root.left.right.right.left.right;

        System.out.println("\n\nPre-Order:");
        System.out.print("Start node: " + node.element);
        node = preOrderSuccessor(node);
        System.out.print(" Successor node: " + node.element);
    }

    private Node preOrderSuccessor(Node node) {
        if (node == null) {
            return null;
        }

        // (a)의 경우: 'node'에 자식 노드가 있음:
        // 해당 자식 노드를 반환합니다(자식 노드가 존재하면 왼쪽, 그렇지 않으면 오른쪽).
        if (node.left != null) {
            return node.left;
        } else if (node.right != null) {
            return node.right;
        }

        // (b)의 경우: 'node'에 자식 노드가 없음:
        // 'node'는 오른쪽 자식('node'가 아님) 노드가 있는 부모 노드에 도달할 때까지
        // 위쪽으로 이동한 다음 오른쪽 자식 노드를 반환합니다.
        while (node.parent != null && (node.parent.right == null || node.parent.right == node)) {
            node = node.parent;
        }
        // (c)의 경우: 'node'는 순회했을 때의 마지막 노드입니다. 루트의 부모 노드를 반환합니다(예: null).
        if (node.parent == null) {
            return null;
        }

        return node.parent.right;
    }

    public void postOrderSuccessor() {
        // n12 노드를 선택합니다(요소 59가 있는 노드).
        Node node = root.left.right.right.left.right;

        System.out.println("\n\nPost-Order:");
        System.out.print("Start node: " + node.element);
        node = postOrderSuccessor(node);
        System.out.print(" Successor node: " + node.element);
    }

    private Node postOrderSuccessor(Node node) {
        // (a)의 경우: 'node'는 순회했을 때의 마지막 노드입니다.
        // 루트의 부모 노드를 반환합니다(예: null).
        if (node == null || node.parent == null) {
            return null;
        }

        // (b)의 경우: 'node'는 부모 노드의 왼쪽 자식 노드입니다. 부모 노드를 반환합니다.
        // (c)의 경우: 'node'는 부모 노드의 오른쪽 자식 노드입니다.
        // (c.1)의 경우: 부모 노드에 올바른 자식 노드가 없으면 부모 노드를 반환합니다.
        if (node.parent.right == node || node.parent.right == null) {
            return node.parent;
        }

        // (c.2)의 경우: 부모 노드가 오른쪽 자식 노드를 가지면
        // 부모 노드의 오른쪽 하위 트리의 가장 왼쪽 맨 아래 노드를 반환합니다.
        return findLeftmostNode(node.parent.right);
    }

    private Node findLeftmostNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}