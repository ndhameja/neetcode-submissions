class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.'){
                    char curr = board[i][j];
                    if(!seen.add(curr+"row"+i)||
                    !seen.add(curr+"col"+j)||
                    !seen.add(curr+"box"+i/3+j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
