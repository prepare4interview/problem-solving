package org.interviewproblems.trainingweek.mon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

   public boolean wordBreak(String s, Set<String> dict) {
      if (dict.contains(s) || s.length() == 0)
         return true;

      for (int i = 1; i < s.length(); i++) {
         if (dict.contains(s.substring(0, i)) && decorateWordBreak(s.substring(i), dict))
            return true;
      }
      return false;
   }

   HashMap<String, Boolean> cache = new HashMap<String, Boolean>();

   private boolean decorateWordBreak(String s, Set<String> dict) {
      if (cache.containsKey(s)) return cache.get(s);
      boolean b = wordBreak(s, dict);
      cache.put(s, b);
      System.out.println("S = " + s + " ->" + b);
      System.out.println("cache = " + cache.size());
      return b;
   }

   public static void main(String[] args) {
      String w1 = "abcdefgh"; Set<String> dictionary = new HashSet<String>();
      dictionary.add("a");
      dictionary.add("ab");
      dictionary.add("abc");
      dictionary.add("abcd");
      dictionary.add("abcde");
      dictionary.add("abcdef");
      dictionary.add("abcdefg");
      dictionary.add("b");
      dictionary.add("bc");
      dictionary.add("bcd");
      dictionary.add("bcde");
      dictionary.add("bcdef");
      dictionary.add("bcdefg");
      dictionary.add("bc");
      dictionary.add("bcd");
      dictionary.add("bcde");
      dictionary.add("bcdef");
      dictionary.add("bcdefg");
      dictionary.add("c");
      dictionary.add("d");
      dictionary.add("e");
      dictionary.add("f");
      dictionary.add("g");
      dictionary.add("xxxxxxxxxxxxxxxxxxx");

      boolean b = new WordBreak().wordBreak(w1, dictionary);
      System.out.println("b = " + b);

   }
}
