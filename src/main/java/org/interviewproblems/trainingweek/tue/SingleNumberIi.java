package org.interviewproblems.trainingweek.tue;

public class SingleNumberIi {

   public int singleNumber(int[] a) {
      int result = 0;
      for (int i = 0; i < 32; i++) {
         int bit = 0;
         for (int j : a) {
            bit += (j >> i) & 1;
         }
         result |= (bit % 3) << i;
      }
      return result;
   }

   public int singleNumber2(int[] a) {
      int ones = 0, twos = 0, threes = 0;
      for (int i : a) {
         twos |= ones & i;
         ones ^= i;
         threes = ones & twos;
         ones &= ~threes;
         twos &= ~threes;
      }
      return ones;
   }

   public static void main(String[] args) {
      SingleNumberIi sn = new SingleNumberIi();
      System.out.println("sn.singleNumber(new int[]{1}); = " + sn.singleNumber(new int[]{1}));
      System.out.println("sn.singleNumber(new int[]{1}); = " + sn.singleNumber(new int[]{1,1,1,7}));
      System.out.println("sn.singleNumber(new int[]{1}); = " + sn.singleNumber(new int[]{1,1,1,7,7,7,-3}));
   }
}
