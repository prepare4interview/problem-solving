package org.interviewproblems.l1binarysearch;

/**
 * Let A be a sorted array with distinct elements. A is rotated k positions to the right
 * (k is unknown). Find out if A
 * contains a number x.
 */
public class P6RotatedArray {

   public int calculateRotation(int[] in) {
      int lo = 0, hi = in.length - 1;
      while (hi - lo > 1) {
         int mid = lo + (hi - lo) / 2;
         if (in[mid] > in[hi]) {
            lo = mid;
         } else {
            hi = mid;
         }
      }
      if (in[hi] < in[lo])
         return hi;
      return 0;
   }
}
