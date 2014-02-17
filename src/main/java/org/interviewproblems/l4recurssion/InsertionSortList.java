package org.interviewproblems.l4recurssion;

import org.interviewproblems.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class InsertionSortList {

   public ListNode insertionSortList(ListNode head) {
      Deque<ListNode> stack = new LinkedList<ListNode>();
      ListNode it = head;
      while (it != null) {
         stack.push(it);
         it = it.next;
      }

      while (!stack.isEmpty()) {
         ListNode current = stack.pop();
         ListNode prev = stack.peekFirst();
         ListNode next;
         if (stack.isEmpty()) head = current;
         while ((next = current.next) != null && current.val < next.val) {
            if (prev != null) {
               prev.next = next;
            } else {
               head = next;
            }
            prev = next;
            current.next = next.next;
            next.next = current;
         }
      }

      it = head;
      while (it != null) {
         stack.push(it);
         it = it.next;
      }

      head = stack.pop();
      it = head;
      while (!stack.isEmpty()) {
         it.next = stack.pop();
         it = it.next;
      }
      it.next = null;
      return head;
   }


   public static void main(String[] args) {
      ListNode node = new ListNode(1, null);
      node = new ListNode(2, node);
      node = new ListNode(3, node);
      node = new ListNode(4, node);
      node = new ListNode(9, node);
      ListNode listNode = new InsertionSortList().insertionSortList(node);
      while (listNode != null) {
         System.out.print(listNode.val + " ");
         listNode = listNode.next;
      }
      System.out.println();

   }
}
