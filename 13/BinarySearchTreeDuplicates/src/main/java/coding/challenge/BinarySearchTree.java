package coding.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root = null;

    private class Node {
        private T element;
        private int count;
        private Node left;
        private Node right;

        private Node(Node left, Node right, T element) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.count = 1;
        }
    }

    public enum TraversalOrder {
        PRE,
        IN,
        POST,
        LEVEL
    }

    public boolean insert(T element) {
        if (element == null) {
            return false;
        }

        root = insert(root, element);

        return true;
    }

    private Node insert(Node current, T element) {
        if (current == null) {
            return new Node(null, null, element);
        }

        // 시작: 삽입할 때 중복 처리
        if (element.compareTo(current.element) == 0) {
            current.count++;

            return current;
        }
        // 종료: 삽입할 때 중복 처리

        if (element.compareTo(current.element) < 0) {
            current.left = insert(current.left, element);
        } else {
            current.right = insert(current.right, element);
        }

        return current;
    }

    public boolean delete(T element) {
        if (element == null) {
            return false;
        }

        root = delete(root, element);

        return true;
    }

    private Node delete(Node node, T element) {
        if (node == null) {
            return null;
        }

        if (element.compareTo(node.element) < 0) {
            node.left = delete(node.left, element);
        } else if (element.compareTo(node.element) > 0) {
            node.right = delete(node.right, element);
        }

        if (element.compareTo(node.element) == 0) {
            // 시작: 삭제할 때 중복 처리
            if (node.count > 1) {
                node.count--;
                return node;
            }
            // 종료: 삭제할 때 중복 처리

            if (node.right == null) {
                Node left = node.left;

                node = null;
                return left;
            } else if (node.left == null) {
                Node right = node.right;

                node = null;
                return right;
            } else {
                Node leftmost = findLeftmostNode(node.right);

                node.element = leftmost.element;
                node.right = delete(node.right, node.element);
            }

        }

        return node;
    }

    private Node findLeftmostNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    public void print(TraversalOrder to) {
        if (root == null) {
            System.out.println("empty");
            return;
        }

        switch (to) {
            case IN:
                printInOrder(root);
                break;
            case PRE:
                printPreOrder(root);
                break;
            case POST:
                printPostOrder(root);
                break;
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
            System.out.print(" " + node.element + "(" + node.count + ")");
            printInOrder(node.right);
        }
    }

    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.element + "(" + node.count + ")");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    private void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(" " + node.element + "(" + node.count + ")");
        }
    }

    private void printLevelOrder(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(" " + current.element + "(" + current.count + ")");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}