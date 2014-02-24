package org.interviewproblems.trainingweek.sun;

import java.util.Arrays;

public class DutchFlag {

   public void dutchFlag(int[] in, int index) {

      // lo: 0 - (lo-1)
      // eq: lo - (eq-1)
      // unprocessed: eq - hi
      // hi: (hi + 1) - in.length - 1

      int val = in[index];
      int lo = 0, eq = 0, hi = in.length - 1;
      while (eq <= hi) {
         if (in[eq] < val) {
            swap(in, eq++, lo++);
         } else if (in[eq] == val) {
            eq++;
         } else { // in[eq] > val
            swap(in, eq, hi--);
         }
      }
   }

   private void swap(int[] in, int i, int j) {
      int a = in[i];
      in[i] = in[j];
      in[j] = a;
   }

   public static void main(String[] args) {
      int[] in = new int[]{6, 4, 4, 9, 8, 2, 7};

      new DutchFlag().dutchFlag(in, 2);
      System.out.println(Arrays.toString(in));
   }
}
