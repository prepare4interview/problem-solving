package org.interviewproblems.l1binarysearch;

/**
 * Problem: given a real number x, find out it’s cubic root.
 *
 * Q: complexity seems linear based on the epsilon, cannot put my finer on it though
 */
public class P2CubicRoot {

   //post:    nr - epsilon <= result*result <= nr + epsilon
   public float cubicRoot(float nr, float epsilon) {
      float signum = Math.signum(nr);
      nr = Math.abs(nr);

      float lo, hi, result;
      if (nr >= 1) {
         lo = 1; hi = nr; result = 1;
      } else {
         lo = nr; hi = 1; result = 0;
      }
      int loopCount = 0;
      //complexity: (hi - r) / 2^p = Eps [r, real value, p is the number of iterations, Eps is the approximation]
      // complexity = 2^p = (hi - r) / Eps <=> p = log2((hi-r) /Eps)
      while (!((result * result * result >= nr - epsilon) && (result * result * result) <= nr + epsilon)) {
         loopCount++;
         float mid = (lo + hi) / 2;
         if (mid * mid * mid < nr) {
            lo = mid;
         } else {
            hi = mid;
         }
         result = (lo + hi) / 2;
      }
      System.out.printf("epsilon = %s, loop count = %s \n", epsilon, loopCount);
      return result * signum;
   }
}
