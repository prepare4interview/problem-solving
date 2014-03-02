package org.interviewproblems.l1binarysearch;

/**
 * Given the +,-,*,/,sqrt operations and a real number x find an algorithm to get log2x.
 */
public class P4Log2 {

   public static float logBase2(float x) {
      float pow = 1;
      float aprox = 2;
      while (aprox * aprox <= x) {
         aprox *= aprox;
         pow *= 2;
      }

      float convergeToX = 1;
      float y = 0;
      while (pow > 1E-10) {
         //convergeToX is 2^p, and we refine p =: pow + pow/i + .. + pow/j
         if (convergeToX * aprox <= x) {
            convergeToX *= aprox;
            y += pow;
         }
         aprox = (float) Math.sqrt(aprox); // invariant: aprox = 2^pow
         pow /= 2;
      }

      return y;
   }


   public static void main(String[] args) {
      System.out.println(logBase2(0.4f));
   }
}
