package org.interviewproblems.l1binarysearch;

/**
 * Given two sorted arrays of length n and m, find out the kth element of their sorted union
 */
public class P7SortUnion {

   public int findK(int[] first, int[] second, int k) {
      assert first.length + second.length > k;

      int current = -1;
      int indexFirst = 0, indexSecond = 0;
      while (k >= 0) {
         if (indexFirst < first.length) {
            if (indexSecond < second.length) {
               if (first[indexFirst] <= second[indexSecond]) {
                  current = first[indexFirst++];
               } else {
                  current = second[indexSecond++];
               }
            } else {
               current = first[indexFirst++];
            }
         } else {
            current = second[indexSecond++];
         }
         k--;
      }
      return current;
   }

   /**
    * this executes in (lonN) ^ 2.
    *
    * @param k - a zero based index of the element in the reunion
    */
   public int findKLogNSquare(int[] a, int[] b, int k) {

      if (k == 0) {
         return Math.min(a[0], b[0]);
      }

      int sizeA = Math.min(a.length, k + 1);
      int lo = -1, hi = sizeA;
      // x in a, pos(x,b) + index(x,a) == k + 1 <=> x is the result
      //invariant pos[lo,b] + lo < k - 1
      while (hi - lo > 1) {
         int mid = (lo + hi) / 2;
         int pos = position(b, a[mid], k);
         if (pos + mid < k) {
            lo = mid;
         } else {
            hi = mid;
         }
      }

      if (hi == sizeA) { //all elements in A are in the reunion
         return b[k - hi];
      }

      int pos = position(b, a[hi], k);
      if (pos + hi == k)
         return a[hi];

      if (pos + hi > k)
         return b[pos - 1];

      throw new IllegalStateException();
   }

   public int position(int[] b, int e, int k) {
      int lo = -1, hi = Math.min(b.length, k + 1);
      //invariant b[lo] < e
      while (hi - lo > 1) {
         int mid = (lo + hi) / 2;
         if (b[mid] <= e) {
            lo = mid;
         } else {
            hi = mid;
         }
      }
      return hi;
   }
}
