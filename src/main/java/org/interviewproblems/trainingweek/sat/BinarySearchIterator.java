package org.interviewproblems.trainingweek.sat;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchIterator {

   static class Node {
      int val;
      Node left;
      Node right;

      Node(int val, Node left, Node right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }

      @Override
      public String toString() {
         return "Node{" +
               "val=" + val +
               '}';
      }
   }

   static class BinarySearchIt {
      private Node current;
      private Deque<Node> parents = new ArrayDeque<Node>();
      private boolean init;

      BinarySearchIt(Node root) {
         current = root;
      }

      Node next() {
         if (!init) {
            init = true;
            while (current.left != null) {
               parents.push(current);
               current = current.left;
            }
            return current;
         }
         if (current == null) return null;
         if (current.right == null) {
            if (parents.isEmpty()) {
               current = null;
               return null;
            }
            Node parent = parents.pop();
            if (current == parent.left) {
               current = parent;
               return current;
            } else {
               current = parent;
               while (!parents.isEmpty()) {
                  boolean done = false;
                  if (parents.peek().left == current) done = true;
                  current = parents.pop();
                  if (done) return current;
               }
               current = null;
               return null;
            }
         } else {
            parents.push(current);
            current = current.right;
            while (current.left != null) {
               parents.push(current);
               current = current.left;
            }
            return current;
         }
      }

      Node prev() {
         if (!init) {
            throw new IllegalStateException();
         }
         if (current == null) return null;
         if (current.left == null) {
            if (parents.isEmpty()) {
               current = null;
               return null;
            }
            Node parent = parents.pop();
            if (current == parent.right) {
               current = parent;
               return current;
            } else {
               current = parent;
               while (!parents.isEmpty()) {
                  boolean done = false;
                  if (parents.peek().right == current) done = true;
                  current = parents.pop();
                  if (done) return current;
               }
               current = null;
               return null;
            }
         } else {
            parents.push(current);
            current = current.left;
            while (current.right != null) {
               parents.push(current);
               current = current.right;
            }
            return current;
         }
      }


   }

   public static void main(String[] args) {
      Node n4 = new Node(4, null, null);
      Node n6 = new Node(6, null, null);
      Node n8 = new Node(8, null, null);
      Node n10 = new Node(10, null, null);
      Node n7 = new Node(7, n6, n8);
      Node n5 = new Node(5, n4, n7);
      Node n9 = new Node(9, n5, n10);



      BinarySearchIt it = new BinarySearchIt(n9);
      for (int i = 0; i < 7; i++) {
         System.out.println("it.next() = " + it.next());
      }
      for (int i = 0; i < 6; i++) {
         System.out.println("it.prev() = " + it.prev());
      }
      Node n;
      while ((n = it.next()) != null) {
         System.out.println(n);
      }
   }
}
