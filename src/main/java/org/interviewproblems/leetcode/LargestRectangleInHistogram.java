package org.interviewproblems.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

//http://oj.leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleInHistogram {

   //http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
   public int largestRectangleArea(int[] histo) {
      Deque<Integer> stack = new ArrayDeque<Integer>();
      int max = 0;
      int i = 0;
      while (i < histo.length) {
         if (stack.isEmpty() || histo[stack.peek()]  <= histo[i]) {
            stack.push(i++);
         } else {
            int val = histo[stack.pop()];
            int left = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, val * (i - left - 1));
         }
      }

      while (!stack.isEmpty()) {
         int val = histo[stack.pop()];
         int left = stack.isEmpty() ? -1 : stack.peek();
         max = Math.max(max, val * (histo.length - left - 1));
      }

      return max;
   }

   public static void main(String[] args) {
      int[] in = {2, 1, 5, 6, 2, 3};
      int lrg = new LargestRectangleInHistogram().largestRectangleArea(in);
      System.out.println("lrg = " + lrg);

      in = new int[]{1};
      lrg = new LargestRectangleInHistogram().largestRectangleArea(in);
      System.out.println("lrg = " + lrg);
   }
}
