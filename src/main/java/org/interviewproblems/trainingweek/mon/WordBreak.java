package org.interviewproblems.trainingweek.mon;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

   Set<String> cache = new HashSet<String>();

   public boolean wordBreak(String s, Set<String> dict) {
      if (dict.contains(s) || s.length() == 0)
         return true;
      if (cache.contains(s)) return false;
      int maxWord = 0;
      for (String w : dict)
         maxWord = Math.max(maxWord, w.length());

      for (int i = Math.min(s.length(), maxWord); i > 0; i--) {
         if (dict.contains(s.substring(0, i)) && wordBreak(s.substring(i), dict))
            return true;
      }
      cache.add(s);
      return false;
   }
}
