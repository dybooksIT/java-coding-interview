package coding.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph<T> {
    // 인접 리스트는 Map으로 표시됩니다.
    private final Map<T, List<T>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    // 두 요소 사이에 새로운 간선을 추가합니다.
    public boolean addEdge(T from, T to) {
        if (from == null || to == null) {
            return false;
        }

        List<T> adjacents = adjacencyList.get(from);

        // 지금까지 간선이 없었던 요소를 추가하므로
        // 요소를 추가한 후 인접 요소를 담을 빈 List를 만들어야 합니다.
        if (adjacents == null) {
            List list = new ArrayList<>();
            list.add(to);

            adjacencyList.put(from, list);
        } else {
            // 기존 요소에 간선을 추가합니다.
            adjacents.add(to);
        }

        return true;
    }

    public boolean isPath(T from, T to) {
        if (from == null || to == null) {
            return false;
        }

        if (from == to) {
            return true;
        }

        Queue<T> queue = new ArrayDeque<>();
        Set<T> visited = new HashSet<>();

        // 'from' 노드에서 시작합니다.
        visited.add(from);
        queue.add(from);

        while (!queue.isEmpty()) {
            T element = queue.poll();

            List<T> adjacents = adjacencyList.get(element);
            if (adjacents != null) {
                for (T t : adjacents) {
                    if (t != null && !visited.contains(t)) {
                        visited.add(t);
                        queue.add(t);

                        // 목적지 노드인 'to' 노드에 도달했습니다.
                        if (t.equals(to)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}