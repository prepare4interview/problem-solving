package org.interviewproblems.trainingweek.mon;

public class EditDistanceDynamic {

   int editDistanceDynamic(String word1, String word2) {
      int[][] distanceMatrix = new int[word1.length()] [word2.length()];
      for (int i = 0; i < word1.length(); i++) {
         for  (int j = 0; j < word2.length(); j++) {
            int min = Integer.MAX_VALUE;
            min = Math.min(distance(i, j - 1, distanceMatrix) + 1, min);
            min = Math.min(distance(i - 1, j, distanceMatrix) + 1, min);
            int match = word1.charAt(i) == word2.charAt(j) ? 0 : 1;
            min = Math.min(distance(i - 1, j - 1, distanceMatrix) + match, min);
            distanceMatrix[i] [j] = min;
         }
      }
      return distanceMatrix[word1.length()-1] [word2.length()-1];
   }

   int distance(int row, int column, int[][] matrix) {
      if (row == -1 && column == -1) return 0;

      if (row == -1)  {
         return column + 1;
      }
      if (column == -1)  {
         return row + 1;
      }

      return matrix[row][column];
   }

   public static void main(String[] args) {
      EditDistanceDynamic ed = new EditDistanceDynamic();
      int i = ed.editDistanceDynamic("plasma", "altruism");
      System.out.println("i = " + i);
   }
}
