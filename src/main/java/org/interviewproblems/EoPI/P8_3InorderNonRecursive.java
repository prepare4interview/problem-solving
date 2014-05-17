package org.interviewproblems.EoPI;


import java.util.ArrayDeque;
import java.util.Deque;

class Node {
   Node left;
   Node right;
   int value;

   Node(Node left, Node right, int value) {
      this.left = left;
      this.right = right;
      this.value = value;
   }
}

abstract class Operation {
   Node n;

   abstract void process(Deque<Operation> stack);
}

class PrintOperation extends Operation {
   public PrintOperation(Node n) {
      super.n = n;
   }

   public void process(Deque<Operation> stack) {
      System.out.println(n.value);
   }
}


class VisitOperation extends Operation {
   public VisitOperation(Node node) {
      super.n = node;
   }

   public void process(Deque<Operation> stack) {
      if (n.right != null) stack.push(new VisitOperation(n.right));
      stack.push(new PrintOperation(this.n));
      if (n.left != null) stack.push(new VisitOperation(n.left));
   }
}

public class P8_3InorderNonRecursive {

   static void inorderTraversal(Node n) {
      Deque<Operation> stack = new ArrayDeque<Operation>();
      new VisitOperation(n).process(stack);
      while (!stack.isEmpty()) {
         stack.pop().process(stack);
      }
   }

   static void inorder(Node n) {
      if (n == null) return;
      inorder(n.left);
      System.out.println(n.value);
      inorder(n.right);
   }


   public static void main(String[] args) {
      Node n4 = new Node(null, null, 4);
      Node n6 = new Node(null, null, 6);
      Node n9 = new Node(null, null, 9);
      Node n8 = new Node(null, n9, 8);
      Node n7 = new Node(n6, n8, 7);
      Node n5 = new Node(n4, n7, 5);
      Node n10 = new Node(n5, null, 10);
      Node n11 = new Node(n10, null, 11);

      P8_3InorderNonRecursive.inorder(n11);
      System.out.println("org.interviewproblems.EoPI.P8_3InorderNonRecursive.main");
      P8_3InorderNonRecursive.inorderTraversal(n11);
   }

}
