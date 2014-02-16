package org.interviewproblems.l4recurssion;

import java.util.HashMap;

public class EditDistance {

   public int minDistance(String word1, String word2) {
      if (word1.length() > word2.length()) {
         return minDistance2(word2, word1);
      } else {
         return minDistance2(word1, word2);
      }
   }

   public int minDistance(String word1, String word2, int currentCost) {
      if (word1.length() < word2.length()) {
         int min = Integer.MAX_VALUE;
         for (int i = 0; i < word1.length(); i++) {
            String newWord1 = word1.substring(0, i) + word2.charAt(i) + word1.substring(i);
            min = Math.min(min, minDistance(newWord1, word2, currentCost + 1));
         }
         return min;
      }
      if (word1.length() == word2.length()) {
         for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) currentCost++;
         }
         return currentCost;
      }
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < word1.length(); i++) {
         String newWord1 = word1.substring(0, i) + word1.substring(i + 1);
         min = Math.min(min, minDistance(newWord1, word2, currentCost + 1));
      }
      return min;
   }

   HashMap<String, Integer> cache = new HashMap<String, Integer>();

   public int minDistance2(String word1, String word2) {
      if (word1.length() == 0 || word2.length() == 0) return word1.length() + word2.length();

      if (cache.containsKey(word1 + "_" + word2)) {
         return cache.get(word1 + "_" + word2);
      }

      int minDist = Integer.MAX_VALUE;

      int i = 0;
      while (i < word1.length()) {
         int sequenceSize = 0;
         while (i + sequenceSize + 1 <= word1.length() && word2.contains(word1.substring(i, i + sequenceSize + 1)))
            sequenceSize++;
         String matchingSeq = word1.substring(i, i + sequenceSize);

         if (sequenceSize == 0) {
            i++;
            continue;
         }

         int posInWord2 = word2.indexOf(matchingSeq);
         String w1 = word1.substring(0, i);
         String w2 = word2.substring(0, posInWord2);
         int md1 = minDistance2(w1, w2);
         cache.put(w1 + "_" + w2, md1);

         w1 = word1.substring(i + sequenceSize);
         w2 = word2.substring(posInWord2 + sequenceSize);
         int md2 = minDistance2(w1, w2);
         cache.put(w1 + "_" + w2, md2);
         minDist = Math.min(minDist, md1 + md2);
         i += sequenceSize;
      }

      if (minDist == Integer.MAX_VALUE) {
         return word2.length();
      }

      return minDist;
   }

   public static void main(String[] args) {
      long start = System.currentTimeMillis();
      String w1 = "ab";
      String w2 = "bc";
      int i = new EditDistance().minDistance(w1, w2);
      System.out.println("It took:" + (System.currentTimeMillis() - start));
      System.out.println("i = " + i);
   }
}
