package coding.challenge;

import java.util.Set;

public final class FiveTower {
    protected static final int GRID_SIZE = 5; // (5x5)

    private FiveTower() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void buildTowers(int row, Integer[] columns, Set<Integer[]> solutions) {
        if (row < 0) {
            throw new IllegalArgumentException("The row cannot be negative");
        }

        if (columns == null || columns.length != GRID_SIZE) {
            throw new IllegalArgumentException("The columns array length must be " + GRID_SIZE);
        }

        if (solutions == null) {
            throw new IllegalArgumentException("The solutions array cannot be null");
        }

        if (row == GRID_SIZE) {
            solutions.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (canBuild(columns, row, col)) {
                    // 탑을 세웁니다.
                    columns[row] = col;

                    // 다음 행으로 넘어갑니다.
                    buildTowers(row + 1, columns, solutions);
                }
            }
        }
    }

    private static boolean canBuild(Integer[] columns, int nextRow, int nextColumn) {
        for (int currentRow = 0; currentRow < nextRow; currentRow++) {
            int currentColumn = columns[currentRow];

            // 다른 탑과 같은 열에 탑을 세울 수 없습니다.
            if (currentColumn == nextColumn) {
                return false;
            }

            int columnsDistance = Math.abs(currentColumn - nextColumn);
            int rowsDistance = nextRow - currentRow;

            // 다른 탑과 같은 대각선에 탑을 세울 수 없습니다.
            if (columnsDistance == rowsDistance) {
                return false;
            }
        }

        return true;
    }
}