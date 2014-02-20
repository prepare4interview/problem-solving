package org.interviewproblems.trainingweek.thu;

//http://oj.leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {

   public boolean isPalindrome(String s) {
      int up = 0, down = s.length() - 1;
      while (up < s.length() && down >= 0) {
         while (up < s.length() && !isAlphaNumeric(s.charAt(up))) up++;
         while (down >= 0 && !isAlphaNumeric(s.charAt(down))) down--;

         if (up >= s.length()) return down < 0;
         if (down < 0) return false;

         if (toUpper(s.charAt(up++)) != toUpper(s.charAt(down--)))
            return false;
      }
      return true;
   }

   private boolean isAlphaNumeric(char c) {
      return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
   }

   private char toUpper(char c) {
      if(c >= 'a' && c <= 'z') return (char)('A' + c - 'a');
      return c;
   }
}
