package org.interviewproblems.trainingweek.mon;

import org.interviewproblems.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

//http://oj.leetcode.com/problems/reorder-list/
public class ReorderList {

   public class Solution {
      public void reorderList(ListNode head) {
         if (head == null) return;
         Deque<ListNode> deq = new LinkedList<ListNode>();
         do {
            deq.addLast(head);
            head = head.next;
         } while (head != null);
         while (!deq.isEmpty()) {
            ListNode h = deq.pollFirst();
            ListNode t = deq.pollLast();
            h.next = t;
            if (t != null) {
               t.next = (!deq.isEmpty()) ? deq.peekFirst() : null;
            }
         }
      }
   }
}
