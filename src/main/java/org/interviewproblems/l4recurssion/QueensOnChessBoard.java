package org.interviewproblems.l4recurssion;

import java.util.ArrayList;
import java.util.List;

// http://oj.leetcode.com/problems/n-queens/
public class QueensOnChessBoard {

   public ArrayList<String[]> solveNQueens(int n) {
      List<List<Integer>> solutions = new ArrayList<List<Integer>>();
      _solveNQueens(0, new int[n], solutions);
      ArrayList<String[]> result = new ArrayList<String[]>();
      for (List<Integer> sol : solutions) {
         result.add(buildString(sol));
      }
      return result;
   }

   private String[] buildString(List<Integer> s) {
      String[] result = new String[s.size()];
      for (int i = 0; i < s.size(); i++) {
         String row = "";
         for (int j = 0; j < s.size(); j++) {
            if (s.get(i) == j) {
               row += 'Q';
            } else {
               row += '.';
            }
         }
         result[i] = row;
      }
      return result;
   }

   public void _solveNQueens(int depth, int[] current, List<List<Integer>> solutions) {
      if (depth == current.length) {
         List<Integer> result = new ArrayList<Integer>();
         for (int aCurrent : current) {
            result.add(aCurrent);
         }
         solutions.add(result);
         return;
      }
      for (int i = 0; i < current.length; i++) {
         current[depth] = i;
         if (isPartialSolution(current, depth)) {
            _solveNQueens(depth + 1, current, solutions);
         }
      }
   }

   public boolean isPartialSolution(int[] current, int depth) {
      for (int i = 0; i < depth; i++) {
         if (current[i] == current[depth]) {
            return false; //same column
         }
         if (Math.abs(current[i] - current[depth]) == depth - i) {
            return false; //diagonal
         }
      }
      return true;
   }

   public static void main(String[] args) {
      List<String[]> res = new ArrayList<String[]>();
      res.add(new String[]{".Q.\n", "Q..", "..Q"});
      res.add(new String[]{".P.\n", "P..", "..P"});
      res.add(new String[]{".R.\n", "R..", "..R"});
      System.out.println("res = " + res);

      System.out.println(new QueensOnChessBoard().solveNQueens(4).size());
   }
}
