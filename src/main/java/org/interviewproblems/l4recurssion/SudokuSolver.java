package org.interviewproblems.l4recurssion;

//http://oj.leetcode.com/problems/sudoku-solver/
public class SudokuSolver {

   public void solveSudoku(char[][] board) {
      _solveSudoku(board, 0, 0);
   }

   boolean _solveSudoku(char[][] board, int row, int column) {
      if (row == board.length) {
         return true;
      }

      int nextRow;
      int nextColumn;
      if (column == board.length - 1) {
         nextRow = row + 1;
         nextColumn = 0;
      } else {
         nextRow = row;
         nextColumn = column + 1;
      }

      if (board[row][column] != '.') {
         return _solveSudoku(board, nextRow, nextColumn);
      } else {
         for (int i = 1; i <= 9; i++) {
            if (validateSolution(board, row, column, Character.forDigit(i, 10))) {
               board[row][column] = Character.forDigit(i, 10);
               if (_solveSudoku(board, nextRow, nextColumn)) {
                  return true;
               }
               board[row][column] = '.';
            }
         }
      }
      return false;
   }

   boolean validateSolution(char[][] board, int row, int column, char val) {
      //validate column uniqueness
      for (int i = 0; i < board.length; i++) {
         if (board[i][column] == val)
            return false;
      }

      //validate row uniqueness
      for (int i = 0; i < board.length; i++) {
         if (board[row][i] == val)
            return false;
      }

      //validate region
      int regionColumn = column / 3 * 3;
      int regionRow = row / 3 * 3;

      for (int i = regionColumn; i < regionColumn + 3; i++) {
         for (int j = regionRow; j < regionRow + 3; j++) {
            if (i == column && j == row) continue;
            if (board[j][i] == val)
               return false;
         }
      }

      return true;
   }

   public static void main(String[] args) {
      String a = "aaa";
      System.out.println("a.substring(3) = " + a.substring(3));
   }

}
