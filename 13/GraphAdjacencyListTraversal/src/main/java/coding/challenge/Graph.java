package coding.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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

    // 너비 우선 탐색(BFS)
    public void bfs(T startElement) {
        Queue<T> queue = new ArrayDeque<>();
        Set<T> visited = new HashSet<>();

        // 1단계: 시작 노드(현재 노드)를 방문한 노드로 저장하여
        // 방문했다고 표시하고 너비 우선 탐색 큐에 추가합니다.
        visited.add(startElement);
        queue.add(startElement);

        while (!queue.isEmpty()) {
            // 2단계: 큐에서 현재 노드를 팝합니다.
            T element = queue.poll();

            // 3단계: 현재 노드를 방문합니다.
            System.out.print(element + " ");

            // 4단계: 현재 노드의 인접 노드를 가져옵니다.
            List<T> adjacents = adjacencyList.get(element);
            if (adjacents != null) {
                // 5단계: 인접한 노드를 순회합니다. null이 아니고 방문한 적이 없는 노드에 대해 다음을 수행합니다.
                // 5-a단계: 노드를 방문한 노드로 저장하여 방문했다고 표시합니다.
                // 5-b단계: 노드를 큐에 추가합니다.
                for (T t : adjacents) {
                    if (t != null && !visited.contains(t)) {
                        visited.add(t);
                        queue.add(t);
                    }
                }
            }
        }
    }

    // 자바의 Stack을 이용해 반복 기반 깊이 우선 탐색(DFS)
    public void dfsStack(T startElement) {
        Stack<T> stack = new Stack<>();
        Set<T> visited = new HashSet<>();

        // 1단계: 현재 노드(주어진 노드)에서 시작하여 현재 노드를 Stack에 푸시합니다.
        stack.add(startElement);

        // 2단계: Stack이 빌 때까지 다음을 수행합니다.
        while (!stack.isEmpty()) {
            // 2-a단계: Stack에서 현재 노드를 팝합니다.
            T element = stack.pop();

            if (!visited.contains(element)) {
                // 2-b단계: 현재 노드를 방문합니다.
                System.out.print(element + " ");

                // 2-c단계: 현재 노드를 방문한 노드로 저장하여 방문했다고 표시합니다.
                visited.add(element);
            }

            // 2-d단계: 방문한 적이 없는 인접 정점을 Stack에 푸시합니다.
            List<T> adjacents = adjacencyList.get(element);
            if (adjacents != null) {
                for (T t : adjacents) {
                    if (t != null && !visited.contains(t)) {
                        stack.push(t);
                    }
                }
            }
        }
    }

    // 재귀 기반 깊이 우선 탐색(RDFS)
    public void dfsRecursion(T startElement) {
        Set<T> visited = new HashSet<>();
        dfsRecursion(startElement, visited);
    }

    private void dfsRecursion(T currentElement, Set<T> visited) {
        // 1단계: 현재 노드(주어진 노드)에서 시작하여, 현재 노드를 방문한 노드로 저장하여 방문했다고 표시합니다.
        visited.add(currentElement);

        // 2단계: 현재 노드를 방문합니다.
        System.out.print(currentElement + " ");

        // 3단계: 재귀로 방문한 적이 없는 인접 정점을 순회합니다.
        List<T> adjacents = adjacencyList.get(currentElement);
        if (adjacents != null) {
            for (T t : adjacents) {
                if (t != null && !visited.contains(t)) {
                    dfsRecursion(t, visited);
                }
            }
        }
    }
}