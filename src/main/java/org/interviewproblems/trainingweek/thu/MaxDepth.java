package org.interviewproblems.trainingweek.thu;

import org.interviewproblems.l4recurssion.PostorderNoRecursion;

//http://oj.leetcode.com/problems/balanced-binary-tree/
public class MaxDepth {

   int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

   public boolean isBalanced(PostorderNoRecursion.TreeNode root) {
      if (root == null) return true;
      return Math.abs(maxDepth(root.left, 0) - maxDepth(root.right, 0)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
   }

   int maxDepth(PostorderNoRecursion.TreeNode root, int depth) {
      if (root == null) return depth;
      return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
   }

}
