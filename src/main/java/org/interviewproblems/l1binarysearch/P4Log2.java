package org.interviewproblems.l1binarysearch;

/**
 * Given the +,-,*,/,sqrt operations and a real number x find an algorithm to get log2x.
 */
public class P4Log2 {


   /**
    * Post: log2(nr) - 10^(-precision) < result < log2(nr) + 10^(-precision)
    */
   public float log(float nr, int precision) {
      float epsilon = (float) Math.pow(10, -precision);
      float lo,hi;
      if (nr >= 2) {
         lo = 2; hi = nr;
      } else {
         lo = 0; hi = 2;
      }
      float result = (lo + hi) / 2;
//      while ()
      //how to calculate 2^(floating number) using just allowed operation
      return -1;
   }
}
