package org.interviewproblems.play;

public class Sqrt {

   static public double sqrt(double nr) {

      double lo, hi;
      if (nr > 1) {
         lo = 1;
         hi = nr;
      } else {
         lo = nr;
         hi = 1;
      }

      //invariant: lo^2 < sqrt <= hi ^ 2
      while (1E-10 < Math.abs(nr - hi * hi)) {
         double mid = (lo + hi) / 2;
         if (mid * mid < nr) {
            lo = mid;
         } else {
            hi = mid;
         }
      }
      return hi;
   }

   public static void main(String[] args) {

//      for (int i = 1; i < 100; i++) {
//         System.out.println("Math.sqrt(nr) = " + Math.sqrt(i) + ":: " + sqrt(i));
//      }

      for (double i = .1; i <= 1; i += .1) {
         System.out.println(" Math.sqrt(" + i + ") = " + Math.sqrt(i) + ":: " + sqrt(i));
      }
   }
}
