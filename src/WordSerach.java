public class WordSerach {
    //https://leetcode.com/problems/word-search/
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(f(board, i, j, w ,0)) return true;
            }
        }
        return false;
    }

    private boolean f(char[][] board, int i, int j, char[] w, int k) {
        if(k == w.length){
            return true;
        }
        if(i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != w[k]){
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = 0;
        boolean ans = f(board, i - 1, j, w, k + 1) ||
                f(board, i + 1, j, w, k + 1) ||
                f(board, i, j + 1, w, k + 1) ||
                f(board, i, j - 1, w, k + 1);
        board[i][j] = tmp;
        return ans;
    }
    
}
