package org.interviewproblems.l1binarysearch;


/**
 * Given A, a sorted int array of length n. How many times the value x occur in A.
 *
 * @see org.interviewproblems.l1binarysearch.BinarySearchAlgorithm
 */
public class P1CountOccurrences {

   public int countOccurrences(int[] in, int nr) {
      //invariant: in[lo] < nr <= in[hi]
      int lo = -1, hi = in.length, mid;
      while (hi - lo > 1) {
         mid = lo + (hi - lo) / 2;
         if (in[mid] < nr) {
            lo = mid;
         } else {
            hi = mid;
         }
      }
      if (hi == in.length || in[hi] != nr) {
         return 0;
      }
      int result = 1;
      while (++hi < in.length && in[hi] == nr) {
         result++;
      }
      return result;
   }
}
