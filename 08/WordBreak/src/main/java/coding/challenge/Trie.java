package coding.challenge;
 
// 시간 복잡도: O(nz), z는 사전에서 가장 긴 단어
// 공간 복잡도 : O(트라이 자료구조의 공간 + str.length)
public class Trie {
    private static final int CHAR_SIZE = 26; // 알파벳 'a'부터 'z'까지

    private final Node head;

    public Trie() {
        this.head = new Node();
    }

    // 트라이(Trie) 노드
    private static class Node {

        private boolean leaf;
        private final Node[] next;

        private Node() {
            this.leaf = false;
            this.next = new Node[CHAR_SIZE];
        }
    };

    // 트라이에 문자열을 삽입합니다.
    public void insertTrie(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The given string cannot be null");
        }

        Node node = head;

        for (int i = 0; i < str.length(); i++) {
            if (node.next[str.charAt(i) - 'a'] == null) {
                node.next[str.charAt(i) - 'a'] = new Node();
            }

            node = node.next[str.charAt(i) - 'a'];
        }

        node.leaf = true;
    }

    // 주어진 문자열이 띄어쓰기로 구분되는 하나 이상의 사전 단어로 분리될 수 있는지 확인하는 메서드
    public boolean breakIt(String str) {
        // 문자열의 첫 i개 문자가 사전 단어로 분리될 수 있으면 table[i]는 true입니다.
        boolean[] table = new boolean[str.length() + 1];
        table[0] = true;

        for (int i = 0; i < str.length(); i++) {
            if (table[i]) {
                Node node = head;
                for (int j = i; j < str.length(); j++) {
                    if (node == null) {
                        break;
                    }

                    node = node.next[str.charAt(j) - 'a'];

                    // [0, i]: 이미 알고 있는 정보입니다.
                    // [i + 1, j]: 트라이에 있는 문자열을 사용합니다.
                    if (node != null && node.leaf) {
                        table[j + 1] = true;
                    }
                }
            }
        }

        // str에 있는 모든 문자가 사전 단어로 분리될 수 있으면 table[n]은 true입니다.
        return table[str.length()];
    }
}