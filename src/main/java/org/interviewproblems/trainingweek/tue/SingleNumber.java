package org.interviewproblems.trainingweek.tue;

public class SingleNumber {

   public int singleNumber(int[] A) {
      int ones = 0;
      for (int i : A) {
         ones = ones ^ i;
      }
      return ones;
   }

}
