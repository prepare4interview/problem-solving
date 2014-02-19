package org.interviewproblems.trainingweek.wen;

import java.util.HashMap;
import java.util.Map;

//http://oj.leetcode.com/problems/decode-ways/
public class DecodeWays {
   public int numDecodings(String s) {
      if (s.length() == 0) return 0;
      if (s.charAt(0) == '0') return 0;
      if (s.length() == 1)  return 1;
      if (s.length() == 2)  {
         int val = Integer.valueOf(s);
         if (val % 10 == 0) return val < 27 ? 1 : 0;
         return val < 27 ? 2 : 1;
      }

      int result = decorateNumDecodings(s.substring(1));

      int twoDigits = Integer.valueOf(s.substring(0,2));
      if (twoDigits < 27)
         result += decorateNumDecodings(s.substring(2));

      return result;
   }

   Map<String,Integer> cache = new HashMap<String, Integer>();
   private int decorateNumDecodings(String s) {
      if (cache.containsKey(s))
         return cache.get(s);
      int value = numDecodings(s);
      cache.put(s, value);
      return value;
   }
}
