package org.interviewproblems.l1binarysearch;

/**
 * Problem: given a real number x, find out it’s cubic root.
 *
 * Q: complexity seems linear based on the epsilon, cannot put my finer on it though
 */
public class P2CubicRoot {

   //post:    nr - epsilon <= result*result <= nr + epsilon
   public float sqrt(float nr, float epsilon) {
      float lo, hi, result;
      if (nr > 1) {
         lo = 1; hi = nr; result = 1;
      } else {
         lo = nr; hi = 1; result = 0;
      }
      int loopCount = 0;
      while (!((result * result >= nr - epsilon) && (result * result) <= nr + epsilon)) {
         loopCount++;
         float mid = (lo + hi) / 2;
         if (mid * mid < nr) {
            lo = mid;
         } else {
            hi = mid;
         }
         result = (lo + hi) / 2;
      }
      System.out.printf("epsilon = %s, loop count = %s \n", epsilon, loopCount);
      return result;
   }
}
