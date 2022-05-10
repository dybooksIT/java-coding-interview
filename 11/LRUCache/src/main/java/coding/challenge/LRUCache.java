package coding.challenge;

import java.util.HashMap;
import java.util.Map;

public final class LRUCache {
    private final class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;

        @Override
        public String toString() {
            return "(" + key + ", " + value + ") ";
        }
    }

    private final Map<Integer, Node> hashmap;

    private Node head;
    private Node tail;

    // 캐시의 최대 크기는 5입니다.
    private static final int LRU_SIZE = 5;

    public LRUCache() {
        hashmap = new HashMap<>();
    }

    public int getEntry(int key) {
        Node node = hashmap.get(key);

        // 키가 이미 존재하는 경우 캐시에서 사용 시기를 업데이트합니다.
        if (node != null) {
            removeNode(node);
            addNode(node);

            return node.value;
        }

        // 정책에 따라 찾을 수 없는 데이터는 -1로 표시합니다.
        return -1;
    }

    public void putEntry(int key, int value) {
        Node node = hashmap.get(key);

        // 키가 이미 있는 경우 값을 업데이트하고 캐시의 맨 위로 이동합니다.
        if (node != null) {
            node.value = value;

            removeNode(node);
            addNode(node);
        } else {
            // 새로운 키인 경우
            Node newNode = new Node();
            newNode.prev = null;
            newNode.next = null;
            newNode.value = value;
            newNode.key = key;

            // 캐시의 최대 크기에 도달하면 최근에 가장 적게 사용한 항목을 제거해야 합니다.
            if (hashmap.size() >= LRU_SIZE) { 
                hashmap.remove(tail.key);
                removeNode(tail);

                addNode(newNode);
            } else {
                addNode(newNode);
            }

            hashmap.put(key, newNode);
        }
    }

    // 캐시의 맨 위에 노드를 추가하는 헬퍼 메서드
    private void addNode(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }
    }

    // 캐시에서 노드를 제거하는 헬퍼 메서드
    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    // 캐시를 출력하는 헬퍼 메서드
    public void print() {
        System.out.println("\nCache content: ");

        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}