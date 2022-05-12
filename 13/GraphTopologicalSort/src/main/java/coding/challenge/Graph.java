package coding.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Graph<T> {
    // 인접 리스트는 Map으로 표시됩니다.
    private final Map<T, List<T>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    // 두 요소 사이에 새로운 간선(edge) 추가
    public boolean addEdge(T from, T to) {
        if (from == null || to == null) {
            return false;
        }

        List<T> adjacents = adjacencyList.get(from);

        // 지금까지 간선이 없었던 요소를 추가하므로
        // 요소를 추가한 후 인접 요소의 빈 리스트를 만들어야 합니다.
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

    // 재귀 기반 깊이 우선 탐색(RDFS) 위상(Topological) 정렬
    public Stack<T> topologicalSort(T startElement) {
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();
        topologicalSort(startElement, visited, stack);

        return stack;
    }

    private void topologicalSort(T currentElement, Set<T> visited, Stack<T> stack) {
        visited.add(currentElement);

        List<T> adjacents = adjacencyList.get(currentElement);
        if (adjacents != null) {
            for (T t : adjacents) {
                if (t != null && !visited.contains(t)) {
                    topologicalSort(t, visited, stack);
                    visited.add(t);
                }
            }
        }

        stack.push(currentElement);
    }
}