package org.interviewproblems.trainingweek.fri;

import java.util.ArrayDeque;
import java.util.Deque;

public class SurroundedRegions {

   public class Solution {
      public void solve(char[][] board) {
         if (board.length <= 1) return;

         for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
         }
         for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
         }
         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
               if (board[i][j] == 'O') board[i][j] = 'X';
               if (board[i][j] == 'N') board[i][j] = 'O';
            }
         }
      }

      class Node {
         int r, c;
         Node (int r, int c) {this.r = r; this.c = c;};
      }

      private void dfs(char[][] board, int r, int c) {
         Deque<Node> stack = new ArrayDeque<Node>();
         stack.push(new Node(r, c));
         while (!stack.isEmpty()) {
            Node n = stack.pop();
            int row = n.r, column = n.c;
            if (row < 0 || row >= board.length ||
                  column < 0 || column >= board[0].length || board[row][column] != 'O') continue;
            board[row][column] = 'N';
            stack.push(new Node(row + 1, column));
            stack.push(new Node(row - 1, column));
            stack.push(new Node(row, column + 1));
            stack.push(new Node(row, column - 1));
         }
      }
   }
}
