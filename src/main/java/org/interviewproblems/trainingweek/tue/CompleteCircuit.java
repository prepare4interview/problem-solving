package org.interviewproblems.trainingweek.tue;

public class CompleteCircuit {

   //solution form here: http://oj.leetcode.com/discuss/1722/spoiler-alert-java-gas-station-solution-what-you-guys-think
   public int canCompleteCircuit(int[] gas, int[] cost) {
      int start = 0;
      int sum = 0;
      for (int i = 0; i < gas.length * 2; i++) {
         sum += gas[i % gas.length] - cost[i % gas.length];
         if (sum < 0) {
            start = i + 1;
            sum = 0;
         }
      }

      if (start > gas.length) return -1;
      return start;
   }
}
