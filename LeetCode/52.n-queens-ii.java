class Solution {
    public int totalNQueens(int n) {
        
       
        char[][] board = new char[n][n];
        for(char [] row : board)
            Arrays.fill(row,'.');
        boolean [] col = new boolean [n];
        boolean [] diag = new boolean [n*2];
        boolean [] antiDiag= new boolean [n*2];
        
        return queens(board,col,diag,antiDiag,0);

    }
    static int queens(char[][]board,boolean []col,boolean []diag,boolean []antiDiag,int row){
        if (row == board.length){
            
            return 1;
        }
        int count =0;
        for(int c =0; c< board.length;c++){
            int d = row-c+board.length-1;
            int ad = row+c;
            if(col[c]||diag[d]||antiDiag[ad])continue;
            board[row][c]='Q';
            col[c]=diag[d]=antiDiag[ad]=true;
            count+=queens(board,col,diag,antiDiag,row+1);
            board[row][c]='.';
            col[c]=diag[d]=antiDiag[ad]=false;
            
        }return count;
        

    }
}
