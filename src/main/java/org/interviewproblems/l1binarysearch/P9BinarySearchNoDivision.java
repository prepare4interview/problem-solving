package org.interviewproblems.l1binarysearch;

/**
 * Write a program that, given an array of N distinct int values in ascending order, determines whether a given integer
 * is in the array. You may use only additions and subtractions and a constant amount of extra memory. The running time
 * of your program should be proportional to log N in the worst case.
 */
public class P9BinarySearchNoDivision {

   public int binarySearch(int[] in, int k) {
      return binarySearch(in, k, 0, in.length - 1);
   }

   private int binarySearch(int[] in, int k, int start, int end) {
      if (start == end)
         return in[start] == k ? start : -1;

      if (in[start] == k)
         return start;


      int prevStep = 1;
      int step = 1;

      while (in[start + step] < k) {
         prevStep = step;
         step += step;
         if (step > end) {
            if (in[end] < k) return -1;
            step = end;
         }
      }

      return binarySearch(in, k, start + prevStep, start + step);
   }
}
