package org.interviewproblems.play;

import java.text.DecimalFormat;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.abs;

public class Log2 {

   public static double log2(double in) {
      double log = 0, nr = 1d;
      while (nr * 2 < in) {
         nr *= 2;
         log += 1;
      }
      double aux = sqrt(2), pow = 0.5d;
      while (abs(nr - in) > 1E-10) {
         if (nr * aux < in) {
            log += pow;
            nr *= aux;
         }
         aux = sqrt(aux);
         pow /= 2;
      }
      return log;
   }

   public static void main(String[] args) {
      for (int i = 1; i < 200; i++) {
         System.out.println(new DecimalFormat().format(officialLog2(i)) + "=" + new DecimalFormat().format(log2(i)));
      }
   }

   private static double officialLog2(double n) {
      final double lo210 = 3.3219280948;
      return Math.log10(n) * lo210;
   }
}
