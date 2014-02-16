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

   public int minDistance2(String word1, String word2) {
      if (word1.length() == 0 || word2.length() == 0) return word1.length() + word2.length();

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

         int posInWord2 = -1;

         while ((posInWord2 = word2.indexOf(matchingSeq, posInWord2 + 1)) >= 0) {
            String w1 = word1.substring(0, i);
            String w2 = word2.substring(0, posInWord2);
            int md1 = minDistance(w1, w2);

            w1 = word1.substring(i + sequenceSize);
            w2 = word2.substring(posInWord2 + sequenceSize);
            int md2 = minDistance(w1, w2);
            minDist = Math.min(minDist, md1 + md2);
         }
         i += sequenceSize;
      }

      return Math.min(minDist, word2.length());
   }

   public static void main(String[] args) {
      long start = System.currentTimeMillis();
      String w1 = "industry"; //dustry
      String w2 = "interest"; //terest
      int i = new EditDistance().minDistance(w1, w2);
      System.out.println("It took:" + (System.currentTimeMillis() - start));
      System.out.println("i = " + i);
   }
}
