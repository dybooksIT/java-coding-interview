package coding.challenge;

public class HashTable<K, V> {
    private static final int SIZE = 10;

    private static class HashEntry<K, V> {
        K key;
        V value;

        HashEntry<K, V> next;

        HashEntry(K k, V v) {
            this.key = k;
            this.value = v;
            this.next = null;
        }

        @Override
        public String toString() {
            return "HashEntry{" + "key=" + key + ", value=" + value + ", next=" + next + '}';
        }
    }

    private final HashEntry[] entries = new HashEntry[SIZE];

    public void put(K key, V value) {
        int hash = getHash(key);

        final HashEntry hashEntry = new HashEntry(key, value);

        if (entries[hash] == null) {
            entries[hash] = hashEntry;
        } else { // 인덱스(해시) 충돌이 발생한 경우, 체이닝으로 이어집니다.
            HashEntry currentEntry = entries[hash];
            while (currentEntry.next != null) {
                currentEntry = currentEntry.next;
            }

            currentEntry.next = hashEntry;
        }
    }

    public V get(K key) {
        int hash = getHash(key);

        if (entries[hash] != null) {
            HashEntry currentEntry = entries[hash];

            // 항목 연결 리스트에서 주어진 키와 일치하는 항목을 검색합니다.
            while (currentEntry != null) {
                if (currentEntry.key.equals(key)) {
                    return (V) currentEntry.value;
                }

                currentEntry = currentEntry.next;
            }
        }

        return null;
    }

    private int getHash(K key) {        
        return Math.abs(key.hashCode() % SIZE);
    }
}