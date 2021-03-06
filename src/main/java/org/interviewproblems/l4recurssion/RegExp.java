package org.interviewproblems.l4recurssion;


import java.util.HashSet;
import java.util.Set;

//http://oj.leetcode.com/problems/regular-expression-matching/
public class RegExp {

   public boolean isMatch(String s, String p) {
      return _isMatch(s, 0, p, 0);
   }

   private boolean _isMatch(String s, int is, String p, int ip) {

      if (p.length() == ip) return s.length() == is;

      if (nextIsStar(p, ip)) return _isMatchCache(s, is, p, ip + 1);

      if (p.charAt(ip) == '.') {
         return _isMatchCache(s, is + 1, p, ip + 1);
      }

      if (p.charAt(ip) == '*') {
         char prev = p.charAt(ip - 1);
         boolean a = _isMatchCache(s, is, p, ip + 1);
         boolean b = s.length() > is && (s.charAt(is) == prev || prev == '.') && _isMatchCache(s, is + 1, p, ip);
         return a || b;
      }

      //this is a literal
      return is < s.length() && s.charAt(is) == p.charAt(ip) && _isMatchCache(s, is + 1, p, ip + 1);
   }

   private boolean nextIsStar(String p, int ip) {
      return ip + 1 < p.length() && p.charAt(ip + 1) == '*';
   }

   Set<String> notMatching = new HashSet<String>();

   private boolean _isMatchCache(String s, int is, String p, int ip) {
      String key = s.substring(is) + "___" + p.substring(ip);
      if (notMatching.contains(key)) return false;
      boolean result = _isMatch(s, is, p, ip);
      if (!result) notMatching.add(key);
      return result;
   }

   public static void main(String[] args) {
      boolean match = new RegExp().isMatch("", ".");
      System.out.println("match = " + match);
   }
}
