class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char [] row : board)
            Arrays.fill(row,'.');
        boolean [] col = new boolean [n];
        boolean [] diag = new boolean [n*2];
        boolean [] antiDiag= new boolean [n*2];
        queens(board,col,diag,antiDiag,0,ans);
        return ans;

    }
    static void queens(char[][]board,boolean []col,boolean []diag,boolean []antiDiag,int row,List<List<String>> ans){
        if (row == board.length){
            ans.add(build(board));
            return;
        }
        for(int c =0; c< board.length;c++){
            int d = row-c+board.length-1;
            int ad = row+c;
            if(col[c]||diag[d]||antiDiag[ad])continue;
            board[row][c]='Q';
            col[c]=diag[d]=antiDiag[ad]=true;
            queens(board,col,diag,antiDiag,row+1,ans);
            board[row][c]='.';
            col[c]=diag[d]=antiDiag[ad]=false;
            
        }

    }
    static List<String> build(char[][]board){
        List<String> res = new ArrayList<>();
        for(char [] row : board)
            res.add(new String(row));
        return res;    

    }
}