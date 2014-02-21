package org.interviewproblems.trainingweek.fri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given n, find the smallest number for which product of the digits is n, if no such number exists, print -1.
 */
public class SmallestNumber {

   public int smallestNumber(int n) {
      if (n < 10) return n;
      int two = count(2, n), three = count(3, n), five = count(5, n), seven = count(7, n);

      if (Math.pow(2,two) * Math.pow(3,three) * Math.pow(5, five) * Math.pow(7, seven) != n)
         return -1;

      List<Integer> digits = new ArrayList<Integer>();

      if (three % 2 == 1 && two % 3 > 0) {
         digits.add(6);
         three--;
         two--;
      }

      digits.addAll(Collections.nCopies(two / 3, 8));
      digits.addAll(Collections.nCopies(two % 3, 2));
      digits.addAll(Collections.nCopies(three / 2, 9));
      digits.addAll(Collections.nCopies(two % 3, 3));
      digits.addAll(Collections.nCopies(five, 5));
      digits.addAll(Collections.nCopies(seven, 7));
      Collections.sort(digits);

      StringBuilder res = new StringBuilder();
      for (int i : digits) res.append(i);
      return Integer.valueOf(res.toString());
   }

   private int count(int f, int n) {
      int res = 0;
      while (n % f == 0 && n > 0) {
         res++;
         n /= f;
      }
      return res;
   }
}
