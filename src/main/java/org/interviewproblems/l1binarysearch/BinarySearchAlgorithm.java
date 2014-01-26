package org.interviewproblems.l1binarysearch;

/**
 * Theory: a solid implementation of the binary search algorithm.
 */
public class BinarySearchAlgorithm {

   // invariant: input[lo] < nr <= input[hi]
   // in case of multiple occurrences, this results in the leftmost matching index being returned
   public int binarySearch(int[] input, int nr) {
      int lo = -1, hi = input.length, mid;
      while (hi - lo > 1) {
         mid = lo + (hi - lo) / 2;
         if (input[mid] < nr) {
            lo = mid;
         } else {
            hi = mid;
         }
      }
      if (hi == input.length || input[hi] != nr)
         return -1;
      return hi;
   }
}
