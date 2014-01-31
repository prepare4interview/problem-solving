package org.interviewproblems.l2creative;

/**
 * Given an ordered S of real numbers and a real number x. Design an algorithm that will find two elements of S which
 * have their sum equals to x. The algorithm should run in O(N) time.
 */
public class P622bSumSearchInOrderedSet {


   public int[] find(float[] in, float sum) {
      int size = in.length;
      float[] reversedDiff = new float[size];
      for (int i = 0; i < size; i++) {
         reversedDiff[size - i - 1] = sum - in[i];
      }

      int inIt = 0, reversedDiffIt = 0;

      while (true) {
         while ((in[inIt] < reversedDiff[reversedDiffIt]) || (size - reversedDiffIt - 1 == inIt)) {
            inIt++;
            if (inIt == size) return null;
         }

         while (reversedDiff[reversedDiffIt] < in[inIt] || (size - reversedDiffIt - 1 == inIt)) {
            reversedDiffIt++;
            if (reversedDiffIt == size) return null;
         }

         if (in[inIt] == reversedDiff[reversedDiffIt]) {
            int second = size - reversedDiffIt - 1;
            return new int[]{inIt, second};
         }
      }
   }
}
