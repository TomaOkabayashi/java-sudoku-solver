public class SudokuSolver {

    private static final int GRID_SIZE = 9;
    public static void main (String[] args) {
        
        int[][] board = {
        {0, 9, 5, 0, 0, 1, 0, 7, 4}, //from random sudoku generator online
        {0, 0, 1, 0, 7, 0, 9, 0, 8},
        {0, 7, 0, 0, 0, 8, 5, 0, 0},
        {0, 0, 4, 0, 0, 0, 8, 0, 9},
        {9, 2, 0, 0, 0, 6, 0, 0, 0},
        {1, 0, 7, 9, 5, 0, 2, 0, 0},
        {3, 0, 9, 5, 4, 2, 7, 0, 0},
        {7, 0, 2, 0, 0, 0, 3, 4, 0},
        {0, 4, 0, 7, 6, 3, 0, 0, 2} 
      };

      System.out.println("Before:");
      printBoard(board);

      if (solveBoard(board)) {
        System.out.println("Solved successfully!!!");
      } else {
        System.out.println("Un-solvable board!!!");
      }

      System.out.println("After:");
      printBoard(board);
    }

    private static void printBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0 ) {
                System.out.println("-----------");
            }
            for (int coloumn = 0; coloumn < GRID_SIZE; coloumn++) {
                if (coloumn % 3 == 0 && coloumn != 0 ) {
                System.out.print("|");
            }
                System.out.print(board[row][coloumn]);
            }
            System.out.println();
        }
    }
    

    private static boolean isNumberInRow(int[][] board, int number, int row) { //board, number to check, row number 0-8
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == number) { //if the board that was passed in, at the current coloumn of 'i'
                return true; // If we find number we are checking, return true
            }
        }

        return false; //when you don't find number in the row
    } 

    private static boolean isNumberInColumn(int[][] board, int number, int column) { 
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][column] == number) {
                return true;
            }
        }

        return false;
    }

    private static boolean isNumberInBox(int[][] board, int number, int row, int column) { 
        //gives top left location of box
        int localBoxRow = row - row % 3; //eg. on row 1, 1%3 = remainder of 1. Therefore localBoxRow = 0
        int localBoxColumn = column - column % 3;
        
        for (int i = localBoxRow; i < localBoxRow + 3; i++) { //+3, three rows in the grid
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }

        return false;
    } 

    private static boolean isValidPlacement (int[][] board, int number, int row, int column) {
        return !isNumberInRow(board, number, row) && 
            !isNumberInColumn(board, number, column) &&
            !isNumberInBox(board, number, row, column);
    }

    private static boolean solveBoard (int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) { 
                if (board[row][column] == 0) { //if grid not populated. Tries every number 1-9 till one is valid
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isValidPlacement(board, numberToTry, row, column)) {
                            board[row][column] = numberToTry;

                            if (solveBoard(board)) {
                                return true;
                            } else {
                                board[row][column] = 0;
                                //found number in a certain spot was valid, so tried placing it there
                                //finds board is impossible to solve with that placement, thus clears
                                //position back to 0. Then goes to for loop above
                            }
                        }
                    }
                    
                    return false;
                }
            }
        }

        return true;
    }
}