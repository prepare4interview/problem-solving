package org.interviewproblems.play;

import static org.testng.AssertJUnit.assertEquals;

public class BinarySearch {

   public int search(int[] in, int nr) {
      int lo = -1, hi = in.length;
      // inv: lo >= nr
      while (hi - lo > 1) {
         int mid = lo + (hi - lo) / 2;
         if (in[mid] >= nr) {
            lo = mid;
         } else {
            hi = mid;
         }
      }

      if (lo >= 0 && in[lo] == nr)
         return lo;

      return -1;
   }

   public static void main(String[] args) {
      int[] in = new int[100];
      for (int i = 0; i < 100; i++) {
         in[i] = i;
      }

      for (int i = 0; i < 100; i++) {
         assertEquals(in[i], i);
      }

      System.out.println("org.interviewproblems.play.BinarySearch.main");
   }
}
