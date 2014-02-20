package org.interviewproblems.trainingweek.thu;

import org.interviewproblems.l4recurssion.PostorderNoRecursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class InorderTraversal {

   enum State {
      INIT, LEFT_VISITED;
   }

   static class Node {
      State s;
      PostorderNoRecursion.TreeNode t;
      Node(State s, PostorderNoRecursion.TreeNode t) {
         this.s = s; this.t = t;
      }
   }

   public ArrayList<Integer> inorderTraversal(PostorderNoRecursion.TreeNode root) {
      ArrayList<Integer> result = new ArrayList<Integer>();
      if (root == null) return result;
      Deque<Node> stack = new ArrayDeque<Node>();
      Node r = new Node(State.INIT, root);
      stack.push(r);
      while (!stack.isEmpty()) {
         Node n = stack.pop();
         switch (n.s) {
            case INIT: {
               n.s = State.LEFT_VISITED;
               stack.push(n);
               if (n.t.left != null)
                  stack.push(new Node(State.INIT, n.t.left));
               break;
            } case LEFT_VISITED: {
               result.add(n.t.val);
               if (n.t.right != null)
                  stack.push(new Node(State.INIT, n.t.right));
               break;
            }
         }
      }

      return result;
   }
}
