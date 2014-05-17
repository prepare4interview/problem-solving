package org.interviewproblems.play;

public class DutchFlag {


   public static void dutchFlag(int[] in, int p) {
      // 0, lo-1 < n
      // lo, eq-1 == n
      // eq,hi-1 -- unprocessed
      // hi, length-1 >= n

      int lo = 0, eq = 0, hi = in.length-1;
      while (eq <= hi) {
         if (in[eq] < p) {
            swap(in, eq++, lo++);
         } else if (in[eq] == p) {
            eq++;
         } else { //in[eq] > p
            swap(in, eq, --hi);
         }
      }
   }

   private static void swap(int[] in, int i, int i1) {
      // TODO: Customise this generated block
   }
}
