package org.interviewproblems.trainingweek.mon;

public class CopyListWithRandomPointer {

   class RandomListNode {
      int label;
      RandomListNode next, random;

      RandomListNode(int x) {
         this.label = x;
      }
   }

   public RandomListNode copyRandomList(RandomListNode head) {
      if (head == null) return null;
      RandomListNode clone = new RandomListNode(head.label);
      RandomListNode it = head, cloneIt = clone;
      while (it != null) {
         cloneIt.next = new RandomListNode(it.label);
         it = it.next;
         cloneIt = cloneIt.next;
      }

      it = head;
      cloneIt = clone;
      while (it != null) {
         RandomListNode rnd = it.random;
         if (rnd != null) {
            RandomListNode it2 = head;
            RandomListNode cloneIt2 = clone;
            while (it2 != rnd) {
               it2 = it2.next;
               cloneIt2 = cloneIt2.next;
            }
            cloneIt.random = cloneIt2;
         }
         it = it.next;
         cloneIt = cloneIt.next;
      }

      return clone;
   }
}
