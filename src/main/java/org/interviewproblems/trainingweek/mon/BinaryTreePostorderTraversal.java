package org.interviewproblems.trainingweek.mon;

import org.interviewproblems.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreePostorderTraversal {

   static enum State {
      ADDED, LEFT_VISITED, RIGHT_VISITED
   }

   static class Node {
      TreeNode tn;
      State state;

      Node(TreeNode tn, State st) {
         this.tn = tn;
         this.state = st;
      }
   }

   public ArrayList<Integer> postorderTraversal(TreeNode root) {
      ArrayList<Integer> result = new ArrayList<Integer>();
      _postorder2(root, result);
      return result;
   }

   void _postorder(TreeNode root, ArrayList<Integer> result) {
      if (root == null) return;
      _postorder(root.left, result);
      _postorder(root.right, result);
      result.add(root.val);
   }

   void _postorder2(TreeNode root, ArrayList<Integer> result) {
      Deque<Node> stack = new LinkedList<Node>();
      stack.add(new Node(root, State.ADDED));
      while (!stack.isEmpty()) {
         Node n = stack.pop();
         if (n.tn == null) continue;
         switch (n.state) {
            case ADDED : {
               n.state = State.LEFT_VISITED;
               stack.push(n);
               stack.push(new Node(n.tn.left, State.ADDED));
               break;
            }
            case LEFT_VISITED : {
               n.state = State.RIGHT_VISITED;
               stack.push(n);
               stack.push(new Node(n.tn.right, State.ADDED));
               break;
            }
            case RIGHT_VISITED : {
               result.add(n.tn.val);
               break;
            } default : {
               throw new RuntimeException();
            }
         }
      }
   }

}
