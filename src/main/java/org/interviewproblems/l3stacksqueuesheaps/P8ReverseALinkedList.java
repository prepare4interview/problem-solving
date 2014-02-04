package org.interviewproblems.l3stacksqueuesheaps;

import java.util.Deque;
import java.util.LinkedList;

//reverse a linked list
public class P8ReverseALinkedList {

   public static class Node {
      int value;
      Node next;

      public Node(int value, Node next) {
         this.value = value;
         this.next = next;
      }
   }

   public Node invertList(Node head) {
      Deque<Node> stack = new LinkedList<Node>();
      while (head != null) {
         stack.push(head);
         head = head.next;
      }
      head = stack.poll();
      Node last = head;
      while (!stack.isEmpty()) {
         last.next = stack.pop();
         last = last.next;
      }
      last.next = null;
      return head;
   }
}
