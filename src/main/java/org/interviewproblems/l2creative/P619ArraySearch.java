package org.interviewproblems.l2creative;

/**
 * Given an array of integers A[0..n] such that for all i, 0 <= i < n - 1 we have |A[i]-A[i+1]| <= 1. Let A[0] = x and
 * A[n-1] = y, x < y. Design an efficient search algorithm so to find j such that A[j] = z for a given value z,
 * x<=z<=y.
 * <p/>
 * What is the maximum number of comparisons to z that your algorithm makes?
 */
public class P619ArraySearch {
   public int find(int[] in, int nr) {
      if (in[0] == nr)
         return 0;

      int lo = -1;
      int hi = in.length;
      //invariant in[lo]<nr<=in[hi]
      while (hi - lo > 1) {
         int mid = lo + (hi - lo) / 2;
         if (in[mid] < nr) {
            lo = mid;
         } else {
            hi = mid;
         }
      }
      assert hi < in.length;
      return hi;
   } //runs in O(log(n))
}
