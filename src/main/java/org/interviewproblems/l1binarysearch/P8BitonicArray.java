package org.interviewproblems.l1binarysearch;

/**
 * An array is bitonic if it is comprised of an increasing sequence of integers followed immediately by a decreasing
 * sequence of integers. Write a program that, given a bitonic array of N distinct int values, determines whether a
 * given integer is in the array.
 */
public class P8BitonicArray {

   public boolean searchBitonicArray(int in[], int k) {
      int lo = 0, hi = in.length - 1;
      while (hi - lo > 1) {
         int mid = lo + (hi - lo) / 2;
         if (in[mid] > in[mid + 1]) {
            hi = mid;
         } else {
            lo = mid;
         }
      }

      int ascending = binarySearch(in, k, 0, lo + 1, true);
      if (ascending == -1) {
         return binarySearch(in, k, hi, in.length, false) != -1;
      } else {
         return true;
      }
   }

   private int binarySearch(int[] in, int k, int start, int end, boolean ascending) {
      if (start == end) return -1;
      int lo = start - 1, hi = end + 1;
      while (hi - lo > 1) {
         int mid = lo + (hi - lo) / 2;
         if (ascending) {
            if (in[mid] < k) {
               lo = mid;
            } else {
               hi = mid;
            }
         } else {
            if (in[mid] > k) {
               lo = mid;
            } else {
               hi = mid;
            }
         }
      }
      if (hi < end + 1 && in[hi] == k) {
         return hi;
      }
      return -1;
   }
}
