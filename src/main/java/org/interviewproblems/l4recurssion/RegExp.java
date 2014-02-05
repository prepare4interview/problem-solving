package org.interviewproblems.l4recurssion;

public class RegExp {
   public boolean isMatch(String s, String p) {
      if (s.length() == 0) {
         for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') return false;
         }
         return true;
      }
      if (p.length() == 0) return false;
      Character c = p.charAt(0);
      switch (c) {
         case '?' : {
            return isMatch(s.substring(1), p.substring(1));
         }
         case '*' : {
            int actualStart = -1;
            while (p.length() > actualStart + 1 && p.charAt(actualStart + 1) == '*') {
               actualStart ++;
            }
            for (int j = s.length(); j >= 0; j--) {
               if (isMatch(s.substring(j), p.substring(actualStart+1))) return true;
            }
            return false;         }
         default: {
            if (c != s.charAt(0)) return false;
            return isMatch(s.substring(1), p.substring(1));
         }

      }
   }

   public static void main(String[] args) {
      boolean c = new RegExp().isMatch("abbaabbbbababaababababbabbbaaaabbbbaaabbbabaabbbbbabbbbabbabbaaabaaaabbbbbbaaabbabbbbababbbaaabbabbabb", "***b**a*a*b***b*a*b*bbb**baa*bba**b**bb***b*a*aab*a**");
      System.out.println("c = " + c);
      assert c;
   }
}
