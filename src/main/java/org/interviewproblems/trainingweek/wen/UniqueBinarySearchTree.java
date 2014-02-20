package org.interviewproblems.trainingweek.wen;

//http://oj.leetcode.com/problems/unique-binary-search-trees/
public class UniqueBinarySearchTree {


   public int numTrees(int n) {
      if (n <= 1) return 1;
      int[] sol = new int[n+1];
      sol[0] = 1;
      sol[1] = 1;
      for (int i = 2; i <= n; i++) {
         for (int j = 0; j < i; j++) {
            sol[i] += sol[j] * sol[i- j - 1];
         }
      }
      return sol[n];
   }

   public int numTrees2(int n) {
      if (n <= 1) return 1;
      int result = 0;
      for (int i = 0; i < n; i++) {
         result += numTrees(i) * numTrees(n - 1 - i);
      }
      return result;
   }

}
