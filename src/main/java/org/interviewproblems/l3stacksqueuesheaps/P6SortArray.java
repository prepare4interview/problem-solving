package org.interviewproblems.l3stacksqueuesheaps;

import java.util.PriorityQueue;

/**
 * Sort an array of n elements where each element is at most k positions away from it's position in the sorted order.
 */
public class P6SortArray {

   //solves the problem in n * log(k)
   public void sort(int[] in, int k) {
      PriorityQueue<Integer> bst = new PriorityQueue<Integer>();
      for (int i = 0; i <= k; i++) {
         bst.add(in[i]);
      }
      int it = 0;
      while (it < in.length) {
         in[it] = bst.poll();
         it++;
         if (it + k < in.length) {
            bst.add(in[it + k]);
         }
      }
   }

}
