package org.interviewproblems.l4recurssion;

import java.util.List;

public class LinkedListSort {

   static class ListNode {
      int val;
      ListNode next;

      ListNode(int x, ListNode next) {
         val = x;
         this.next = next;
      }
   }

   public ListNode sortList(ListNode head) {
      int size = size(head);
      return _sortList(head, size);
   }

   ListNode _sortList(ListNode head, int size) {
      if (size <= 1) {
         if (head!=null) head.next = null;
         return head;
      }

      ListNode[] splits = split(head, size / 2);
      int size1 = size / 2;
      int size2 = size - size1;
      splits[0] = _sortList(splits[0], size1);
      splits[1] = _sortList(splits[1], size2);

      ListNode merge;
      if (splits[0].val <= splits[1].val) {
         merge = splits[0];
         splits[0] = splits[0].next;
         size1--;
      } else {
         merge = splits[1];
         splits[1] = splits[1].next;
         size2--;
      }

      ListNode result = merge;

      while (size1 > 0 && size2 > 0) {
         if (splits[0].val <= splits[1].val) {
            merge.next = splits[0];
            splits[0] = splits[0].next;
            size1--;
         } else {
            merge.next = splits[1];
            splits[1] = splits[1].next;
            size2--;
         }
         merge = merge.next;
      }

      while (size1 > 0) {
         merge.next = splits[0];
         merge = merge.next;
         splits[0] = splits[0].next;
         size1--;
      }

      while (size2 > 0) {
         merge.next = splits[1];
         merge = merge.next;
         splits[1] = splits[1].next;
         size2--;
      }
      return result;
   }

   private ListNode[] split(ListNode head, int size) {
      ListNode[] result = new ListNode[2];
      result[0] = head;
      result[1] = head;
      for (int i = 0; i < size; i++) {
         result[1] = result[1].next;
      }
      return result;
   }

   int size(ListNode n) {
      if (n == null) return 0;
      int s = 1;
      while ((n = n.next) != null) s++;
      return s;
   }

   public static void main(String[] args) {
      //4,19,14,5,-3,1,8,5,11,15

      ListNode n = new ListNode(15, null);
      n = new ListNode(11, n);
      n = new ListNode(5, n);
      n = new ListNode(8, n);
      n = new ListNode(1, n);
      n = new ListNode(-3, n);
      n = new ListNode(5, n);
      n = new ListNode(14, n);
      n = new ListNode(19, n);
      n = new ListNode(4, n);

      ListNode listNode = new LinkedListSort().sortList(n);
      while (listNode != null) {
         System.out.print(listNode.val + " ");
         listNode = listNode.next;
      }
   }

}
