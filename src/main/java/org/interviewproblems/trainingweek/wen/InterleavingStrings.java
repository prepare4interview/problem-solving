package org.interviewproblems.trainingweek.wen;

import java.util.HashMap;
import java.util.Map;

public class InterleavingStrings {

   /**
    * Reasoning about complexity. m = s1.length, n = s2.length; p = s3.length
    * - max number of recursions is 2 ^ p (leafs of a complete binary tree of depth p); At each substep I make a copy of a string of size p, so O(n) = p * 2^p ~= 2^p
    * - the cache contains contain m * n * p elements
    **/

   public boolean isInterleave(String s1, String s2, String s3) {
      if (s3.length() == 0)
         return s1.length() + s2.length() == 0;
      return (s1.length() > 0 && s1.charAt(0) == s3.charAt(0) && decorateIsInterleave(s1.substring(1), s2, s3.substring(1)))
            || (s2.length() > 0 && s2.charAt(0) == s3.charAt(0) && decorateIsInterleave(s1, s2.substring(1), s3.substring(1)));

   }

   Map<String, Boolean> cache = new HashMap<String, Boolean>();
   public boolean decorateIsInterleave(String s1, String s2, String s3) {
      String key = s1 + "-" + s2 +"-" + s3;
      if (cache.containsKey(key))
         return cache.get(key);
      boolean result = isInterleave(s1, s2, s3);
      cache.put(key, result);
      return result;
   }
}
