package coding.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph<T> {
    // 정점 리스트
    private final List<T> elements;

    public Graph() {
        this.elements = new ArrayList<>();
    }

    public boolean add(T element) {
        if (element == null) {
            return false;
        }

        elements.add(element);

        return true;
    }

    // 너비 우선 탐색(BFS)
    public void bfs(int[][] adjacencyMatrix, T startElement) {
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
            List<T> adjacents = findAdjacents(adjacencyMatrix, element);
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
    public void dfsStack(int[][] adjacencyMatrix, T startElement) {
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
            List<T> adjacents = findAdjacents(adjacencyMatrix, element);
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
    public void dfsRecursion(int[][] adjacencyMatrix, T startElement) {
        Set<T> visited = new HashSet<>();
        dfsRecursion(adjacencyMatrix, startElement, visited);
    }

    private void dfsRecursion(int[][] adjacencyMatrix, T currentElement, Set<T> visited) {
        // 1단계: 현재 노드(주어진 노드)에서 시작하여, 현재 노드를 방문한 노드로 저장하여 방문했다고 표시합니다.
        visited.add(currentElement);

        // 2단계: 현재 노드를 방문합니다.
        System.out.print(currentElement + " ");

        // 3단계: 재귀로 방문한 적이 없는 인접 정점을 순회합니다.
        List<T> adjacents = findAdjacents(adjacencyMatrix, currentElement);
        if (adjacents != null) {
            for (T t : adjacents) {
                if (t != null && !visited.contains(t)) {
                    dfsRecursion(adjacencyMatrix, t, visited);
                }
            }
        }
    }

    private List<T> findAdjacents(int[][] adjacencyMatrix, T element) {
        int tIndex = -1;

        List<T> adjacents = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).equals(element)) {
                tIndex = i;
                break;
            }
        }

        if (tIndex != -1) {
            for (int j = 0; j < adjacencyMatrix[tIndex].length; j++) {
                if (adjacencyMatrix[tIndex][j] == 1) {
                    adjacents.add(elements.get(j));
                }
            }
        }

        return adjacents;
    }
}