package org.interviewproblems.trainingweek.fri;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree of n nodes, find all the pair of nodes whose sum is equal to a given number k in O(n) time
 * and constant space.(algo+code)
 */
public class SumInBinarySearchTree {

   static class Node {
      int val;
      Node left;
      Node right;
      Node parent;

      Node next() {
         Node next;
         if (right != null) {
            return goLeft(right);
         }
         if (parent.left == this) return parent;
         next = this;
         while (next.parent != null && next.parent.right == next) {
            next = next.parent;
         }
         return next.parent;
      }

      Node prev() {
         Node prev;
         if (left != null) {
            prev = left;
            while (left.right != null) left = left.right;
            return prev;
         }

         return parent;
      }


      static class Pair {
         Node n1, n2;

         Pair(Node n1, Node n2) {
            this.n1 = n1;
            this.n2 = n2;
         }
      }

      static Node goLeft(Node next) {
         while (next.left != null) {
            next = next.left;
         }
         return next;
      }


      public List<Pair> findPairs(Node root, int sum) {
         Node lo = goLeft(root);
         Node hi = goLeft(root);

         List<Pair> result = new ArrayList<Pair>();

         while (hi != null && lo.val + hi.val < sum) hi = hi.next();
         if (hi == null)
            return result;

         while (true) {
            if (lo.val + hi.val == sum) result.add(new Pair(lo, hi));
            lo = lo.next();
            while (lo.val + hi.val > sum) {
               hi = hi.prev();
               if (hi == lo) return result;
            }
         }
      }

   }
}
