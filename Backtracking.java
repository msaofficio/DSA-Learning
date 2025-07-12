public class Backtracking {

    private static void display(boolean[][] board) {
        for (boolean[] row : board) { //selecting a row in the matrix (array of array)
            for (boolean element : row) {  // selecting an element of array of array
                if (element == true)    
                    System.out.print("Q ");
                else
                    System.out.print("X ");
            }
            System.out.println();
        }
    }
    private static boolean isSafe(boolean[][] board, int row, int col) {

        // checking the vertical direction means the all rowcolumn it is on
        for (int i = 0; i <row; i++) {
            if (board[i][col] == true)
                return false;
        }
        // checking the right diagonal
        int maxright = Math.min(row, board[0].length - col - 1);  // total cols - the column where we are standing (reaching the border of the matrix right side )
        for (int i = 1; i <= maxright; i++) {
            if (board[row - i][col + i] == true) 
                return false;
        }

        // checking the left diagonal
        int maxleft = Math.min(row, col);   
        for (int i = 1; i <= maxleft; i++) {
            if (board[row - i][col - i] == true)
                return false;
        }
        return true;

    }
    static int NQueen(boolean[][] board, int row) {
    
        // this is the base case when we have placed the last queen in the last row
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;   // 
        }
        int count = 0; 
        // now here we'll place the queen and checking for every row and col
        for (int col = 0; col < board[0].length; col++) {
            // place the queen if its safe
            if (isSafe(board, row, col)) {
                board[row][col] = true; //this will mark the position true that means queen is placed there
                count += NQueen(board, row+1); // now move to the next row for next recursion call
                board[row][col] = false; // when the recusion call is complete(when you get out of the recusion call), revert all the changes (here mark the position as no queen is there now))
            }
        }
        return count; 
    }
    
     
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(NQueen(board, 0));
    }
}
