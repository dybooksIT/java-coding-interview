package coding.challenge;

public final class Words {
    private Words() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean exist(char[][] board, String word) {
        // 주어진 단어판을 바꾸면 단어 여러 개 검색이
        // 불가능하므로 단어판을 복사합니다.
        char[][] cloneBoard = new char[board.length][];
        for (int i = 0; i < board.length; i++) {
            cloneBoard[i] = board[i].clone();
        }

        int m = cloneBoard.length;
        int n = cloneBoard[0].length;

        boolean result = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(cloneBoard, word, i, j, 0)) {
                    result = true;
                }
            }
        }

        return result;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, int k) {
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }

        if (board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            board[i][j] = '#';

            if (k == word.length() - 1) {
                return true;
            } else if (dfs(board, word, i - 1, j, k + 1)
              || dfs(board, word, i + 1, j, k + 1)
              || dfs(board, word, i, j - 1, k + 1)
              || dfs(board, word, i, j + 1, k + 1)) {
                return true;
            }
            board[i][j] = temp;
        }

        return false;
    }
}