package org.interviewproblems.trainingweek.mon;

import org.interviewproblems.l4recurssion.PostorderNoRecursion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreePreorderTraversal {

   public class Solution {

      public ArrayList<Integer> preorderTraversal(TreeNode root) {

         Deque<TreeNode> stack = new LinkedList<TreeNode>();
         ArrayList<Integer> result = new ArrayList<Integer>();

         if (root == null) return result;

         stack.push(root);

         while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            result.add(n.val);
            if (n.right != null) stack.push(n.right);
            if (n.left != null) stack.push(n.left);

         }
         return result;
      }
   }
}
