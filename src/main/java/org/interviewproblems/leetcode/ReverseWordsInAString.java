package org.interviewproblems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInAString {

   public String reverseWords(String s) {
      if (s.length() == 0) return s;
      String[] words = s.split(" ");
      StringBuilder res = new StringBuilder();
      for (int i = words.length -1 ; i >= 0; i--) {
         String word = words[i];
         if (word.equals("")) continue;
         if (i < words.length - 1) res.append(" ");
         res.append(word);
      }
      return res.toString();
   }

   public static void main(String[] args) {
      String s = new ReverseWordsInAString().reverseWords(" 1");
      System.out.println("s = '" + s + "'");
   }
}
