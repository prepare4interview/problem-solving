package org.interviewproblems.play;

import javax.smartcardio.Card;

public class EditTwoStrings {


   static class Edit {
      int val;
      Edit prev;

      Edit(int val, Edit prev) {
         this.val = val;
         this.prev = prev;
      }
   }


   static int editDistance(String s1, String s2) {
      Edit[][] edit = new Edit[s1.length() + 1][s2.length() + 1];

      for (int i = 0; i <= s1.length(); i++)
         edit[i][0] = new Edit(i, null);

      for (int i = 0; i <= s2.length(); i++)
         edit[0][i] = new Edit(i, null);

      for (int i = 1; i <= s1.length(); i++) {
         for (int j = 1; j <= s2.length(); j++) {
            int lo = 1 + edit[i - 1][j].val;
            int left = 1 + edit[i][j - 1].val;
            int min = Math.min(lo, left);
            int diag = s1.charAt(i - 1) == s2.charAt(j - 1) ? edit[i - 1][j - 1].val : edit[i - 1][j - 1].val + 1;
            min = Math.min(min, diag);

            if (diag == min) {
               edit[i][j] = new Edit(min, edit[i - 1][j - 1]);
            } else if (lo == min) {
               edit[i][j] = new Edit(min, edit[i - 1][j]);
            } else {
               edit[i][j] = new Edit(min, edit[i][j - 1]);
            }
         }
      }

      return edit[s1.length()][s2.length()].val;
   }

   public static void main(String[] args) {
      int d = editDistance("tata", "mata");
      System.out.println("d = " + d);
   }

}
