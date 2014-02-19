package org.interviewproblems.trainingweek.wen;

public class DivideTwoIntegers {

   public int divide(int a, int b) {
      long dividend = a, divisor = b;
      int sign = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? -1 : 1;

      dividend = Math.abs(dividend);
      divisor = Math.abs(divisor);

      if (dividend < divisor) return 0;

      int result;
      if (dividend < 100) {
         result = 0;
         long sum = 0;

         while (sum  + divisor <= dividend) {
            sum += divisor;
            result++;
         }
      } else {
         result = 1;
         long sum = divisor;

         while (sum + sum < dividend) {
            sum += sum;
            result += result;
         }
         result += divide( (int) (dividend - sum), (int)divisor);
      }
      return sign > 0 ? result : -result;
   }

   public static void main(String[] args) {
      if (Integer.MIN_VALUE == -2147483648)
         System.out.println();
      System.out.println(new DivideTwoIntegers().divide(2147483647, 2));
   }
}
