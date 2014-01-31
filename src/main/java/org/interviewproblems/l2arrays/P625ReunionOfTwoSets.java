package org.interviewproblems.l2arrays;

import java.util.Arrays;

/**
 * Design an algorithm to compute the reunion of two given sets, both of size O(n). The sets are given as arrays of
 * elements. The output should be an array of distinct elements that form the union of the sets. Worst case running
 * should be O(n * log(n));
 */
public class P625ReunionOfTwoSets {

   public int[] reunion(int[] a, int[] b) {
      int[] result = new int[a.length + b.length];
      System.arraycopy(b, 0, result, 0, b.length);
      int size = b.length;
      Arrays.sort(b);
      for (int i : a) {
         if (Arrays.binarySearch(b, i) < 0) {
            result[size++] = i;
         }
      }
      int[] actualResult = new int[size];
      System.arraycopy(result, 0, actualResult, 0, size);
      return actualResult;
   }
}
