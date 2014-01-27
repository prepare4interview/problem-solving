package org.interviewproblems.l1binarysearch;

/**
 * Problem: Given A a sorted array, find out an i such that A[i] == i
 */
public class P3ElementEqualIndex {

   public int find(int[] in) {
      return find(in, 0, in.length - 1);
   }

   /**
    * O(n) - search (sublinear). O(n) is given by the fact that the array is not strictly monotonical,
    * e.g. considering {1,1,1,1,6,6,6}, after looking at the element in the middle, both two resulting
    * sub-arrays can contain an match and should be investigated: {1,1,1} & {1,6,6,6}.
    *
    * I guess we can narrow it down to O(log(n)) if the array is strictly monotonical.
    *
    * O(1) - space complexity
    */
   public int find2(int[] in) {
      int lo = 0, hi = in.length - 1;
      while (lo <= hi) {
         if (in[lo] == lo) {
            return lo;
         } else if (in[lo] > lo) {
            lo = in[lo];
         } else {
            lo++;
         }

         if (in[hi] == hi) {
            return hi;
         } else if (in[hi] < hi) {
            hi = in[hi];
         } else {
            hi--;
         }
      }
      return -1;
   }

   // O(n) - search (sublinear)
   // O(1) space
   private int find(int[] in, int lo, int hi) {
      if (lo > hi)
         return -1;
      if (lo == hi)
         return in[lo] == lo ? lo : -1;
      int mid = lo + (hi - lo) / 2;
      if (in[mid] == mid)
         return mid;

      if (in[mid] > mid) {
         int res = find(in, in[mid], hi);
         if (res >= 0) return res;
         return find(in, lo, mid - 1);
      } else {
         int res = find(in, lo, in[mid]);
         if (res >= 0) return res;
         return find(in, mid + 1, hi);
      }
   }
}
