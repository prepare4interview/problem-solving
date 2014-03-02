package org.interviewproblems.play;

public class Logarithm {

   public static double log(double nr) {

      int scale = 1;
      int val = 2;
      while (nr * val < 2) {
         val *= val;
         scale*=2;
      }
      nr *= val;

      double pow = 1;
      double aprox = 2;
      while (aprox * aprox <= nr) {
         aprox *= aprox;
         pow *= 2;
      }

      double rez = pow;
      double converge = aprox;
      while (pow > 1E-10) {
         if (converge * aprox < nr) {
            rez += pow;
            converge *= aprox;
         }
         pow /= 2;
         aprox = Math.sqrt(aprox);
      }

      return rez - scale;
   }

   public static void main(String[] args) {

      System.out.println(officialLog2(.4));

      System.out.printf("log2(%s) is: %s -- %s \n", .4, officialLog2(.4), log(.4));

      for (double i = 0.01; i < .8; i += .02) {
         System.out.printf("log2(%s) is: %s -- %s \n", i, officialLog2(i), log(i));
      }
      for (double i = 3; i < 100; i += 1) {
         System.out.printf("log2(%s) is: %s -- %s \n", i, officialLog2(i), log(i));
      }
   }

   private static double officialLog2(double n) {
      final double lo210 = 3.3219280948;
      return Math.log10(n) * lo210;
   }
}
