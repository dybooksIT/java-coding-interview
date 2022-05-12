package coding.challenge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    // 시작: O(n^2) 시간 복잡도의 재귀 기반 풀이법
    public void spiralOrderTraversalRecursive() {
        if (root == null) {
            return;
        }

        int level = 1;
        boolean flip = false;

        // printLevel의 실행 결과가 true를 반환하면
        // 출력할 레벨이 더 남아 있다는 의미입니다.
        while (printLevel(root, level++, flip = !flip)) {
            // 빈 블록입니다.
        };
    }

    // 주어진 레벨의 모든 노드를 출력합니다.
    private boolean printLevel(Node root, int level, boolean flip) {
        if (root == null) {
            return false;
        }

        if (level == 1) {
            System.out.print(root.element + " ");
            return true;
        }

        if (flip) {
            // 왼쪽 자식 노드를 오른쪽 자식 노드보다 먼저 처리합니다.
            boolean left = printLevel(root.left, level - 1, flip);
            boolean right = printLevel(root.right, level - 1, flip);

            return left || right;
        } else {
            // 오른쪽 자식 노드를 왼쪽 자식 노드보다 먼저 처리합니다.
            boolean right = printLevel(root.right, level - 1, flip);
            boolean left = printLevel(root.left, level - 1, flip);

            return right || left;
        }
    }
    // 종료: O(n^2) 시간 복잡도의 재귀 기반 풀이법

    // 시작: 시간 복잡도와 공간 복잡도가 O(n)이면서 2개 스택을 사용하는 반복 기반 풀이법
    public void spiralOrderTraversalTwoStacks() {
        if (root == null) {
            return;
        }

        printSpiralTwoStacks(root);
    }

    private void printSpiralTwoStacks(Node node) {
        if (node == null) {
            return;
        }

        // 레벨을 저장할 2개의 스택 생성
        Stack<Node> rl = new Stack<>(); // 오른쪽에서 왼쪽
        Stack<Node> lr = new Stack<>(); // 왼쪽에서 오른쪽

        // 첫 번째 레벨을 첫 번째 스택 'rl'에 푸시
        rl.push(node);

        // 스택에 노드가 더 없을 때까지 출력
        while (!rl.empty() || !lr.empty()) {
            // 'rl'에 있는 현재 레벨의 노드를 출력하고 다음 레벨의 노드를 'lr'에 푸시
            while (!rl.empty()) {
                Node temp = rl.peek();
                rl.pop();

                System.out.print(temp.element + " ");

                if (temp.right != null) {
                    lr.push(temp.right);
                }

                if (temp.left != null) {
                    lr.push(temp.left);
                }
            }

            // 'lr'에 있는 현재 레벨의 노드를 출력하고 다음 레벨의 노드를 'rl'에 푸시
            while (!lr.empty()) {
                Node temp = lr.peek();
                lr.pop();

                System.out.print(temp.element + " ");

                if (temp.left != null) {
                    rl.push(temp.left);
                }
                if (temp.right != null) {
                    rl.push(temp.right);
                }
            }
        }
    }
    // 종료: 시간 복잡도와 공간 복잡도가 O(n)이면서 2개 스택을 사용하는 반복 기반 풀이법

    // 시작: 시간 복잡도와 공간 복잡도가 O(n)이면서 Deque를 사용하는 풀이법
    public void spiralOrderTraversalDeque() {
        if (root == null) {
            return;
        }

        printSpiralDeque(root);
    }

    private void printSpiralDeque(Node root) {
        if (root == null) {
            return;
        }

        // 빈 이중 종료 큐를 생성합니다.
        Deque<Node> deque = new ArrayDeque<>();

        // 루트 노드 삽입
        deque.addFirst(root);

        // 홀수 또는 짝수 레벨인지 확인
        boolean oddEvenFlag = false;

        while (!deque.isEmpty()) {
            // 현재 레벨의 노드 수는 Deque의 크기로 지정됩니다.
            int nodesNo = deque.size();

            // 왼쪽에서 오른쪽 노드를 출력합니다.
            if (oddEvenFlag) {
                // 현재 레벨의 각 노드를 처리하고
                // 비어 있지 않은 왼쪽 및 오른쪽 자식 노드를 큐에 넣습니다.
                while (nodesNo > 0) {
                    Node currentNode = deque.pollFirst();
                    System.out.print(currentNode.element + " ");

                    // 왼쪽 자식 노드를 끝까지 이동시킨 후
                    // 오른쪽 자식 노드를 끝까지 이동시킵니다.
                    if (currentNode.left != null) {
                        deque.addLast(currentNode.left);
                    }

                    if (currentNode.right != null) {
                        deque.addLast(currentNode.right);
                    }

                    nodesNo--;
                }
            // 오른쪽에서 왼쪽 노드를 출력합니다.
            } else {
                // 현재 레벨의 각 노드를 처리하고
                // 비어 있지 않은 오른쪽 및 왼쪽 자식 노드를 큐에 넣습니다.
                while (nodesNo > 0) {
                    // 'oddEvenFlag'가 false면 뒤에서 팝합니다.
                    Node currentNode = deque.pollLast();

                    System.out.print(currentNode.element + " ");

                    // 오른쪽 자식 노드를 끝까지 이동시킨 후 왼쪽 자식 노드를 끝까지 이동시킵니다.
                    if (currentNode.right != null) {
                        deque.addFirst(currentNode.right);
                    }

                    if (currentNode.left != null) {
                        deque.addFirst(currentNode.left);
                    }

                    nodesNo--;
                }
            }

            // 다음 레벨을 위해 'oddEvenFlag'를 뒤집습니다.
            oddEvenFlag = !oddEvenFlag;
        }
        // 시작: 시간 복잡도와 공간 복잡도가 O(n)이면서 Deque를 사용하는 풀이법
    }
}