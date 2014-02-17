package org.interviewproblems.trainingweek.mon;

import java.util.HashMap;
import java.util.Set;

public class WordBreak {

   public boolean wordBreak(String s, Set<String> dict) {
      if (dict.contains(s) || s.length() == 0)
         return true;
      int maxWord = 0;
      for (String w : dict)
         maxWord = Math.max(maxWord, w.length());

      for (int i = Math.min(s.length(), maxWord); i > 0; i--) {
         if (dict.contains(s.substring(0, i)) && decorateWordBreak(s, dict, i))
            return true;
      }
      return false;
   }

   HashMap<String, Boolean> cache = new HashMap<String, Boolean>();

   private boolean decorateWordBreak(String s, Set<String> dict, int i) {
      if (cache.containsKey(s)) return cache.get(s);
      boolean b = wordBreak(s.substring(i), dict);
      cache.put(s, b);
      return b;
   }
}
