package org.interviewproblems.play;

//http://oj.leetcode.com/problems/distinct-subsequences/
public class DistinctSubsequences {

   public int numDistinct(String s, String t) {
      int[][] v = new int[s.length() + 1][t.length() + 1];
      for (int i = 0; i < v[0].length; i++) v[0][i] = 0;
      for (int i = 0; i < v.length; i++) v[i][0] = 1;

      for (int i = 1; i <= s.length(); i++) {
         for  (int j = 1; j <= t.length(); j++) {
            v[i][j] = v[i-1] [j] + (s.charAt(i - 1) == t.charAt(j - 1) ? v[i-1][j-1] : 0);
         }
      }

      return v[s.length()][t.length()];
   }
}
