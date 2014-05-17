package org.interviewproblems.EoPI;

public class P6_20RabinCarp {
   static int base = 31, mod = 997;

   public static int search(String text, String what) {
      if (what.equals("")) return 0;
      if (text.equals("") || text.length() < what.length()) return -1;
      int hcWhat = what.charAt(0);
      int hcText = text.charAt(0);
      int pow = 1;
      for (int i = 1; i < what.length(); i++) {
         hcWhat = (hcWhat * base + what.charAt(i)) % mod;
         hcText = (hcText * base + text.charAt(i)) % mod;
         pow = pow * base % mod;
      }


      for (int i = 0; i < text.length() - what.length() + 1; i++) {
         if (hcWhat == hcText && text.substring(i, i + what.length()).equals(what))
            return i;
         hcText -= (pow * text.charAt(i)) % mod;
         if (hcText < 0) hcText += mod;
         if (i + what.length() >= text.length())
            return -1;
         hcText = (hcText * base + text.charAt(i + what.length())) % mod;
      }
      return -1;
   }

   public static void main(String[] args) {
      String text = "baabbaaaaaaabbaaaaabbabbababaabbabbbbbabbabbbbbbabababaabbbbbaaabbbbabaababababbbaabbbbaaabbaababbbaabaabbabbaaaabababaaabbabbababbabbaaabbbbabbbbabbabbaabbbaa";
//      String text = "abbaaaababa";
      String what = "bbaaaababa";
      int search = search(text, what);
      System.out.println("search = " + search);
   }

}
