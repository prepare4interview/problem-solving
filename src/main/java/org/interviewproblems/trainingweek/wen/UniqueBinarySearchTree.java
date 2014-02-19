package org.interviewproblems.trainingweek.wen;

//http://oj.leetcode.com/problems/unique-binary-search-trees/
public class UniqueBinarySearchTree {

   public int numTrees(int n) {
      if (n <= 1) return 1;
      int result = 0;
      for (int i = 0; i < n; i++) {
         result += numTrees(i) * numTrees(n - 1 - i);
      }
      return result;
   }

}
