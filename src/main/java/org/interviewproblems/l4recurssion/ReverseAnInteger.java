package org.interviewproblems.l4recurssion;

public class ReverseAnInteger {

   public int reverse(int x) {
      int signum = (int) Math.signum(x);
      x = Math.abs(x);
      int result = 0;
      while (x != 0) {
         int toAdd = x % 10;
         x = x / 10;
         result = result * 10 + toAdd;
      }
      return result * signum;
   }
}
