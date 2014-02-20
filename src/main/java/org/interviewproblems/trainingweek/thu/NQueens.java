package org.interviewproblems.trainingweek.thu;

import java.util.ArrayList;

public class NQueens {

   StringBuilder row;
   ArrayList<String[]> result = new ArrayList<String[]>();


   public ArrayList<String[]> solveNQueens(int n) {
      row = new StringBuilder();
      for (int i = 0; i < n - 1; i++)
         row.append('*');
      _solveNQueens(new int[n], 0);
      return result;
   }

   public void _solveNQueens(int[] board, int pos) {
      if (pos == board.length) {
         String[] r = new String[board.length];
         for (int i = 0; i < board.length; i++) {
            r[i] = new StringBuilder(row).insert(board[i], 'Q').toString();
         }
         result.add(r);
         return;
      }
      for (int i = 0; i < board.length; i++) {
         board[pos] = i;
         boolean conflict = false;
         for (int j = 0; j < pos; j++) {
            boolean sameColumn = board[j] == board[pos];
            boolean diagonal = Math.abs(board[j] - board[pos]) == Math.abs(j - pos);
            if (sameColumn || diagonal) {
               conflict = true;
               break;
            }
         }
         if (!conflict) _solveNQueens(board, pos + 1);
      }
   }

   public static void main(String[] args) {
      new NQueens().solveNQueens(3);
   }
}
