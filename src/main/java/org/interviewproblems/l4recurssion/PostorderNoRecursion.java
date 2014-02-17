package org.interviewproblems.l4recurssion;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PostorderNoRecursion {

   public static class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;

      public TreeNode(int x) {
         val = x;
      }
   }

   public ArrayList<Integer> postorderTraversal(TreeNode root) {
      ArrayList<Integer> result = new ArrayList<Integer>();
      _postorder(root, result);
      return result;
   }

   void _postorder(TreeNode root, ArrayList<Integer> result) {
      if (root == null) return;
      _postorder(root.left, result);
      _postorder(root.right, result);
      result.add(root.val);
   }

   void _postorder2(TreeNode root, ArrayList<Integer> result) {
      Deque<TreeNode> stack = new LinkedList<TreeNode>();

      TreeNode it = root;
      do {
         while (it.left != null) {
            stack.push(it);
            it = it.left;
         }

         TreeNode parent;
         while ((parent = stack.peekFirst()) != null && parent.left == it && parent.right == null) {
            result.add(it.val);
            it = stack.pop();
         }

         if (it.right != null) {
            stack.push(it);
            it = it.right;
         } else {
            while ((parent = stack.peekFirst()) != null && parent.right == it) {
               result.add(it.val);
               it = stack.pop();
            }
            result.add(it.val);
            while ((parent = stack.peekFirst()) != null && parent.left == it && parent.right == null) {
               result.add(it.val);
               it = stack.pop();
            }
            if (!stack.isEmpty()) {
               it = stack.peekFirst().right;
            }
         }
      } while (!stack.isEmpty());
   }
}
