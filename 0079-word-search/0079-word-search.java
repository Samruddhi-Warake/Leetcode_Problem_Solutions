class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (find(i, j, 0, board, word, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean find(int row, int col, int idx, char[][] board, String word, boolean[][] visited) {
        if (idx == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || 
            board[row][col] != word.charAt(idx) || visited[row][col]) {
            return false;
        }
        
        visited[row][col] = true;
        
        boolean found = find(row - 1, col, idx + 1, board, word, visited) ||
                        find(row + 1, col, idx + 1, board, word, visited) ||
                        find(row, col - 1, idx + 1, board, word, visited) ||
                        find(row, col + 1, idx + 1, board, word, visited);
        
        visited[row][col] = false;
        return found;
    }


}