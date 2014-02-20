package org.interviewproblems.trainingweek.thu;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

   public int longestConsecutive(int[] num) {
      if (num.length == 0) return 0;

      Set<Integer> nr = new HashSet<Integer>();
      for (int i : num) nr.add(i); //O(n)

      int longestSeq = 1;
      for (int i : num) {
         int seq = 1;
         int n = i;
         while (nr.contains(++n)) {
            seq++;
            nr.remove(n);
         }
         n = i;
         while (nr.contains(--n)) {
            seq++;
            nr.remove(n);
         }
         longestSeq = Math.max(seq, longestSeq);
         if (nr.isEmpty()) break;
      }
      return longestSeq;
   }
}
