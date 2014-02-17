package org.interviewproblems.trainingweek.mon;

import java.util.HashMap;
import java.util.Map;

//http://oj.leetcode.com/problems/copy-list-with-random-pointer/
public class BinaryTreePreorderTraversal {

     class RandomListNode {
         int label;
         RandomListNode next, random;
         RandomListNode(int x) { this.label = x; }
     }


   public RandomListNode copyRandomList(RandomListNode head) {
      if (head == null) return null;
      RandomListNode clone = new RandomListNode(head.label);
      RandomListNode it = head.next, cloneIt = clone;
      Map<RandomListNode, Integer> node2index = new HashMap<RandomListNode, Integer>();
      Map<Integer, RandomListNode> index2node = new HashMap<Integer, RandomListNode>();

      node2index.put(head, 0);
      index2node.put(0, clone);

      int index = 1;
      while (it != null) {
         node2index.put(it, index);
         cloneIt.next = new RandomListNode(it.label);
         index2node.put(index++, cloneIt.next);
         it = it.next;
         cloneIt = cloneIt.next;
         index2node.put(0, clone);
      }

      it = head;
      cloneIt = clone;
      while (it != null) {
         RandomListNode rnd = it.random;
         cloneIt.random = index2node.get(node2index.get(rnd));
         it = it.next;
         cloneIt = cloneIt.next;
      }

      return clone;
   }

   public static void main(String[] args) {

   }
}
