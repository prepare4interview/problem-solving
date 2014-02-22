package org.interviewproblems.trainingweek.sat;

import java.util.ArrayDeque;
import java.util.Deque;

public class TweetsPerSecond {


   static class Pair {
      int pos;
      int val;

      Pair(int pos, int val) {
         this.pos = pos;
         this.val = val;
      }
   }

   public static void tweets_per_second(Integer[] tps, Integer k) {

      Deque<Pair> deq = new ArrayDeque<Pair>(k);

      for (int i = 0; i < tps.length; i++) {
         if (!deq.isEmpty() && deq.peekFirst().pos == i - k) {
            deq.removeFirst();
         }
         while (!deq.isEmpty() && deq.peekLast().val < tps[i]) deq.removeLast();
         deq.add(new Pair(i, tps[i]));
         System.out.println(deq.peekFirst().val);
      }
   }

   public static void main(String[] args) {
      tweets_per_second(new Integer[]{6, 9, 4, 7, 4, 1}, 3);
   }

}
