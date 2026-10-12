class Solution {
    public int totalNQueens(int n) {
     List<List<String>> list = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');      
        }
        queens(board, 0, list);
        return list.size();
    }
    static void queens(char[][] board, int row, List<List<String>> list){
        if(row == board.length){
            List<String> solution = new ArrayList<>();
            for (char[] rowArray : board) {
                solution.add(new String(rowArray));
            }
            list.add(solution);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                queens(board, row + 1, list);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        // check for vertical possibilities
        for(int i = 0; i < row; i++){
            if (board[i][col] == 'Q'){
                return false;
            }
        }
        //check for left diagonal
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row - i][col - i] == 'Q'){
                return false;
            }
        }
       // check for right diagonal
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row - i][col + i] == 'Q'){
                return false;
            }
        }
        return true;
    }
}