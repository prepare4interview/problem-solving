package org.interviewproblems.l2creative;

/**
 * Given two sets S1 and S2, and a real number x, find whether there exists an element from S1 and an element from S2,
 * where sum is exactly x. The algorithm should run in time O(n log(n)) where n is the total number of elements in both
 * sets.
 */
public class P623SumBetweenTwoArrays {

   public int[] search(double[] first, double[] second, double sum) {
      mergeSort(second);

      for (int i = 0; i < first.length; i++) {
         int pos = find(second, sum - first[i]);
         if (pos >= 0) {
            return new int[]{i, pos};
         }
      }
      return null;
   }

   private int find(double[] in, double val) {
      int lo = -1, hi = in.length;
      while (hi - lo > 1) {
         int mid = lo + (hi - lo) / 2;
         if (in[mid] < val) {
            lo = mid;
         } else {
            hi = mid;
         }
      }
      if (hi != in.length && in[hi] == val)
         return hi;
      return -1;
   }

   public void mergeSort(double[] in) {
      if (in.length <= 1)
         return;
      int mid = in.length / 2;
      double[] left = new double[mid];
      System.arraycopy(in, 0, left, 0, mid);
      int rightCount = in.length - mid;
      double[] right = new double[rightCount];
      System.arraycopy(in, mid, right, 0, rightCount);
      mergeSort(left);
      mergeSort(right);
      int leftIt = 0, rightIt = 0, pos = 0;
      while (pos < in.length) {
         while (leftIt < left.length && (rightIt == right.length || left[leftIt] < right[rightIt])) {
            in[pos++] = left[leftIt++];
         }
         while ((rightIt < right.length) && (leftIt == left.length || right[rightIt] <= left[leftIt])) {
            in[pos++] = right[rightIt++];
         }
      }
   }
}
