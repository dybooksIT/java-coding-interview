package coding.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<T> {
    private int nodeCount;
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

    public enum TraversalOrder {
        PRE,
        IN,
        POST,
        LEVEL
    }

    // 너비 우선 탐색(Breadth-first Search, BFS) 알고리즘을 이용해 트리에 노드 삽입
    public boolean insert(T element) {
        if (element == null) {
            return false;
        }

        if (root == null) {
            root = new Node(element);
            nodeCount++;

            return true;
        }

        insert(root, element);

        return true;
    }

    // 너비 우선 탐색 알고리즘을 이용해 삽입
    private void insert(Node node, T element) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.peek();
            queue.poll();

            if (node.left == null) {
                node.left = new Node(element);
                nodeCount++;
                break;
            } else {
                queue.add(node.left);
            }

            if (node.right == null) {
                node.right = new Node(element);
                nodeCount++;
                break;
            } else {
                queue.add(node.right);
            }
        }
    }

    // 깊이 우선 탐색(DFS)와 너비 우선 탐색(CFS)를 이용한 트리 출력
    public void print(TraversalOrder to) {
        if (size() == 0) {
            System.out.println("empty");
            return;
        }

        switch (to) {
            // 깊이 우선 탐색(DFS)
            case IN:
                printInOrder(root);
                break;
            case PRE:
                printPreOrder(root);
                break;
            case POST:
                printPostOrder(root);
                break;
            // 너비 우선 탐색(BFS)
            case LEVEL:
                printLevelOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized traversal order");
        }
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(" " + node.element);
            printInOrder(node.right);
        }
    }

    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.element);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    private void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(" " + node.element);
        }
    }

    private void printLevelOrder(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            // 1단계: 큐에서 첫 번째 노드를 현재 노드로 팝합니다.
            Node current = queue.poll();

            // 2단계: 현재 노드를 방문합니다.
            System.out.print(" " + current.element);

            // 3단계: 현재 노드에 왼쪽 노드가 있는 경우 해당 왼쪽 노드를 큐에 추가합니다.
            if (current.left != null) {
                queue.add(current.left);
            }

            // 4단계: 현재 노드에 오른쪽 노드가 있는 경우 해당 오른쪽 노드를 큐에 추가합니다.
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // 트리의 깊이 우선 탐색(DFS)과 너비 우선 탐색(BFS)의 순회로 List를 반환합니다.
    public List<T> asList(TraversalOrder to) {
        if (size() == 0) {
            return Collections.emptyList();
        }

        List<T> treeList = new ArrayList<>(size());

        switch (to) {
            // 깊이 우선 탐색(DFS)
            case IN:
                traverseInOrderAsList(root, treeList);
                break;
            case PRE:
                traversePreOrderAsList(root, treeList);
                break;
            case POST:
                traversePostOrderAsList(root, treeList);
                break;
            // 너비 우선 탐색(BFS)
            case LEVEL:
                traverseLevelOrderAsList(root, treeList);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized traversal order");
        }

        return treeList;
    }

    private void traverseInOrderAsList(Node node, List<T> treeList) {
        if (node != null) {
            traverseInOrderAsList(node.left, treeList);
            treeList.add(node.element);
            traverseInOrderAsList(node.right, treeList);
        }
    }

    private void traversePreOrderAsList(Node node, List<T> treeList) {
        if (node != null) {
            treeList.add(node.element);
            traversePreOrderAsList(node.left, treeList);
            traversePreOrderAsList(node.right, treeList);
        }
    }

    private void traversePostOrderAsList(Node node, List<T> treeList) {
        if (node != null) {
            traversePostOrderAsList(node.left, treeList);
            traversePostOrderAsList(node.right, treeList);
            treeList.add(node.element);
        }
    }

    private void traverseLevelOrderAsList(Node node, List<T> treeList) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            treeList.add(current.element);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // 자바 Iterator를 이용한 트리의 깊이 우선 탐색(DFS)과 너비 우선 탐색(BFS) 순회
    public Iterator<T> iterator(TraversalOrder to) {
        if (size() == 0) {
            return Collections.emptyIterator();
        }

        switch (to) {
            // 깊이 우선 탐색(DFS)
            case IN:
                return traverseInOrderAsIterator(root);
            case PRE:
                return traversePreOrderAsIterator(root);
            case POST:
                return traversePostOrderAsIterator(root);
            // 너비 우선 탐색(BFS)
            case LEVEL:
                return traverseLevelOrderAsIterator(root);
            default:
                throw new IllegalArgumentException("Unrecognized traversal order");
        }
    }

    private Iterator<T> traverseInOrderAsIterator(Node node) {
        final int expectedNodeCount = size();
        final Deque<Node> stack = new ArrayDeque<>();

        stack.push(node);

        return new Iterator<T>() {
            Node cursor = node;

            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                return node != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                while (cursor != null && cursor.left != null) {
                    stack.push(cursor.left);
                    cursor = cursor.left;
                }

                Node current = stack.pop();

                if (current.right != null) {
                    stack.push(current.right);
                    cursor = current.right;
                }

                return current.element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private Iterator<T> traversePreOrderAsIterator(Node node) {
        final int expectedNodeCount = size();
        final Deque<Node> stack = new ArrayDeque<>();

        stack.push(node);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                return node != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                Node current = stack.pop();

                if (current.right != null) {
                    stack.push(current.right);
                }

                if (current.left != null) {
                    stack.push(current.left);
                }

                return current.element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private Iterator<T> traversePostOrderAsIterator(Node node) {
        final int expectedNodeCount = size();

        final Deque<Node> stacka = new ArrayDeque<>();
        final Deque<Node> stackb = new ArrayDeque<>();

        stacka.push(node);

        while (!stacka.isEmpty()) {
            Node nodea = stacka.pop();
            if (nodea != null) {
                stackb.push(nodea);
                if (nodea.left != null) {
                    stacka.push(nodea.left);
                }
                if (nodea.right != null) {
                    stacka.push(nodea.right);
                }
            }
        }

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                return node != null && !stackb.isEmpty();
            }

            @Override
            public T next() {

                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                return stackb.pop().element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private Iterator<T> traverseLevelOrderAsIterator(Node node) {
        final int expectedNodeCount = size();
        final Queue<Node> queue = new ArrayDeque<>();

        queue.offer(node);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                return node != null && !queue.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                Node current = queue.poll();

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }

                return current.element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public T root() {
        if (root == null) {
            return null;
        }

        return root.element;
    }

    public int size() {
        return nodeCount;
    }
}