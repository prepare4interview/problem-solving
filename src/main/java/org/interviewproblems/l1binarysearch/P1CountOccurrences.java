package org.interviewproblems.l1binarysearch;


/**
 * Given A, a sorted int array of length n. How many times the value x occur in A.
 *
 * @see org.interviewproblems.l1binarysearch.BinarySearchAlgorithm
 */
public class P1CountOccurrences {

   public int countOccurrences(int[] in, int nr) {
      int left = leftmostOccurrence(in, nr);
      if (left == -1) return 0;
      int right = rightmostOccurrence(in, nr);
      return right - left + 1;
   }

   /**
    * invariant in[lo]< nr<= hi[lo].
    */
   private int leftmostOccurrence(int in[], int nr) {
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
         return -1;
      }
      return hi;
   }

   /**
    * invariant in[lo]<=nr<hi[lo].
    */
   private int rightmostOccurrence(int in[], int nr) {
      int lo = -1, hi = in.length, mid;
      while (hi - lo > 1) {
         mid = lo + (hi - lo) / 2;
         if (in[mid] > nr) {
            hi = mid;
         } else {
            lo = mid;
         }
      }
      if (lo == -1 || in[lo] != nr) {
         return -1;
      }
      return lo;
   }
}
