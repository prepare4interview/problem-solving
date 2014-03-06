package org.interviewproblems.leetcode;

import java.util.ArrayList;

public class RestoreIpAddress {

   public ArrayList<String> restoreIpAddresses(String s) {
      return restoreIpAddresses(s, 0, 1);
   }

   public ArrayList<String> restoreIpAddresses(String s, int pos, int nr) {
      ArrayList<String> result = new ArrayList<String>();
      if (nr == 4) {
         if (pos < s.length() && s.length() - pos <= 3) {
            String p = s.substring(pos);
            if (isValid(p)) result.add(s.substring(pos));
         }
         return result;
      }

      addSubstrings(result, s, pos, nr, 1);
      addSubstrings(result, s, pos, nr, 2);
      addSubstrings(result, s, pos, nr, 3);
      return result;
   }

   void addSubstrings(ArrayList<String> res, String s, int pos, int nr, int size) {
      if (pos + size > s.length()) return;
      if (isValid (s.substring(pos, pos + size)))
         for (String w : restoreIpAddresses(s, pos + size, nr + 1))
            res.add(s.substring(pos, pos + size) + "." + w);
   }

   public boolean isValid(String s) {
      if (s.equals("0")) return true;
      return s.charAt(0) != '0' && Integer.valueOf(s) <= 255;
   }

   public static void main(String[] args) {
      ArrayList<String> strings = new RestoreIpAddress().restoreIpAddresses("0279245587303");
      System.out.println("strings = " + strings);
   }
}
