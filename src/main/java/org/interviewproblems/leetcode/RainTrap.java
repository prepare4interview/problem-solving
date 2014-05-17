package org.interviewproblems.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RainTrap {

   static class Pair {
      int index;
      int val;

      Pair(int i, int v) {
         this.index = i;
         this.val = v;
      }
   }

   public int trap(int[] A) {
      int res = 0;
      Deque<Pair> stack = new ArrayDeque<Pair>();
      for (int i = 0; i < A.length; i++) {
         if (stack.isEmpty() || A[i] < stack.peek().val) {
            stack.push(new Pair(i, A[i]));
         } else {
            if (A[i] == stack.peek().val)
               stack.peek().index = i;
            else {
               int bottom = stack.pop().val;
               while (!stack.isEmpty() && stack.peek().val <= A[i]) {
                  Pair p = stack.pop();
                  res += (p.val - bottom) * (i - p.index - 1);
                  bottom = p.val;
               }
               if (!stack.isEmpty()) res += (A[i] - bottom) * (i - stack.peek().index - 1);
               stack.push(new Pair(i, A[i]));
            }
         }
      }
      return res;
   }

   public static void main(String[] args) {
      int trap = new RainTrap().trap(new int[]{4,2,0,3,2,5});
      System.out.println("trap = " + trap);
   }
}
