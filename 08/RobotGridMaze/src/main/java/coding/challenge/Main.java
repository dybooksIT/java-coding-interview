package coding.challenge;

import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /* R - 로봇, # - 미로, T - 도달 위치
        (m, n) +           +
               |R| | | | | |
               |R|R| | | | |
               |#|R|R|R|R| |
               |#|#|#|#|R| |
               | | | | |R| |
               | | | | |R|T|
               +           + (0, 0)
        */

        // LinkedHashSet에 경로를 저장합니다.
        Set<Point> path = new LinkedHashSet<>();

        // 미로를 정의합니다.
        boolean[][] maze  = new boolean[6][6];
        maze[2][0]=true;
        maze[3][0]=true;
        maze[3][1]=true;
        maze[3][2]=true;
        maze[3][3]=true;

        // 경로를 계산하고 표시합니다.
        RobotGrid.computePath(5, 5, maze, path);

        System.out.println("Computed path (plain recursion):");
        path.forEach(System.out::println);

        // 방문한 칸을 저장하는 집합을 정의합니다.
        Set<Point> visited = new HashSet<>();

        // 경로를 계산하고 표시합니다.
        RobotGrid.computePath(5, 5, maze, path, visited);

        System.out.println("\nComputed path (Memoization):");
        path.forEach(System.out::println);
    }
}
