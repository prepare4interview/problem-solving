package org.interviewproblems.trainingweek.tue;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

public class LongestIncreasingSubsequence {

   public static int longestSubsequence(int[] in) {
      int[] inc = new int[in.length];
      int[] prev = new int[in.length];
      inc[0] = 1;
      prev[0] = -1;

      int allMaxInc = Integer.MIN_VALUE;
      int allMaxIncPos = 0;
      for (int i = 1; i < in.length; i++) {
         prev[i] = -1;
         int maxInc = 1;
         for (int j = 0; j < i; j++) {
            if (in[j] < in[i] && maxInc < inc[j] + 1) {
               maxInc = inc[j] + 1;
               prev[i] = j;
            }
         }
         inc[i] = maxInc;
         if (allMaxInc < maxInc) {
            allMaxIncPos = i;
            allMaxInc = maxInc;
         }

      }
      Deque<Integer> sequence = new ArrayDeque<Integer>();
      while (allMaxIncPos != -1) {
         sequence.push(in[allMaxIncPos]);
         allMaxIncPos = prev[allMaxIncPos];
      }

      while (!sequence.isEmpty()) {
         System.out.print(sequence.pop() + "");
      }
      System.out.println();

      return allMaxInc;
   }

   public static void main(String[] args) {
      int in[] = new int[] {1,2,3,4,5,6};
      assertEquals(longestSubsequence(in), 6);
      in = new int[] {1,0,2,1,1,3,2,3,4,3,2,1,5,4,4,1,2,3,6,2,3};
      assertEquals(longestSubsequence(in), 7);
   }
}
