package org.interviewproblems.play;

import java.util.Arrays;

public class SmallestMissingInteger {

//   Given an array of positive integers, print out the smallest integer that’s missing.
//
//   i.e:
//         [1,8,5,2,3,8,1000000000,4,6,3,6] = 7
//         [1,2,3,5,6,7,8,9,10] = 4


   public static int firstGap(int[] in) {
      int min = minimum(in);
      for (int i = 0; i < in.length; i++) {
         replace(in, min, in[i] - min);
      }
      for (int i = 0; i < in.length; i++) {
         if (in[i] > 0)
            return min + i;
      }
      return 1;
   }

   private static int minimum(int[] in) {
      int min = Integer.MAX_VALUE;
      for (int i : in) {
         if (i < min) min = i;
      }
      return min;
   }

   static void replace(int[] in, int min, int pos) {
      if (pos < 0 || pos >= in.length) return;
      if (in[pos] != -1) {
         int aux = in[pos];
         in[pos] = -1;
         replace(in, min, aux - min);
      }
   }

   public static void main(String[] args) {
      int[] in = new int[]{1,8,5,2,3,8,1000000000,4,6,3,6};
      System.out.println(firstGap(in));
   }
}
