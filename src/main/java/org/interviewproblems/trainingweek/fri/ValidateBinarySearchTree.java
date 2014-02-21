package org.interviewproblems.trainingweek.fri;

import org.interviewproblems.l4recurssion.PostorderNoRecursion;

//http://oj.leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {

   public boolean isValidBST(PostorderNoRecursion.TreeNode root) {
      return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }


   public boolean isValidBST(PostorderNoRecursion.TreeNode root, int min, int max) {
      if (root == null) return true;
      if (root.val <= min || root.val >= max) return false;
      if (root.left != null && root.left.val >= root.val) return false;
      if (root.right != null && root.right.val <= root.val) return false;
      return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
   }
}
