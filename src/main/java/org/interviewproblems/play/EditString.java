package org.interviewproblems.play;

public class EditString {

   public static int distance(String a, String b) {
      int[][] dis = new int[a.length() + 1][b.length() + 1];
      for (int i = 0; i <= b.length(); i++) dis[0][i] = i;
      for (int i = 0; i <= a.length(); i++) dis[i][0] = i;
      for (int i = 1; i <= a.length(); i++) {
         for (int j = 1; j <= b.length(); j++) {
            int diag = dis[i - 1][j - 1];
            if (a.charAt(i - 1) != b.charAt(j - 1)) diag++;
            dis[i][j] = Math.min(Math.min(dis[i - 1][j], dis[i][j - 1]) + 1, diag);
         }
      }
      return dis[a.length()][b.length()];
   }

   public static void main(String[] args) {
      System.out.println("org.interviewproblems.play.EditString.main");
      System.out.println(distance("tataliga", "mataliga"));
   }
}
