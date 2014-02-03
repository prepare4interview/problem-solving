package org.interviewproblems.l3stacksqueuesheaps;

import java.util.*;

/**
 * Given a sequence of n numbers find the minimum for each compact subsequence of length k.
 */
public class P5FindMinSubsequence {


   /**
    * This runs in O( n * k).
    */
   public int[] minSequence(int[] in, int k) {
      int it = 0;
      int[] result = new int[in.length - k + 1];
      while (it + k <= in.length) {
         int min = Integer.MAX_VALUE;
         for (int i = it; i < it + k; i++) {
            min = Math.min(min, in[i]);
         }
         result[it] = min;
         it++;
      }
      return result;
   }


   /**
    * This runs in O( n * log(k)).
    */
   public int[] minSequenceBetter(int[] in, int k) {
      int[] result = new int[in.length - k + 1];
      TreeSet<Integer> bst = new TreeSet<Integer>();
      for (int i = 0; i < k; i++) {
         bst.add(in[i]);
      }
      result[0] = bst.first();
      for (int it = k; it < in.length; it++) {
         bst.remove(in[it - k]);
         bst.add(in[it]);
         result[it - k + 1] = bst.first();
      }
      return result;
   }
}
