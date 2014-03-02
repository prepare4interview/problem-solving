package org.interviewproblems.cracking;

import java.util.Arrays;

public class MatrixRotation {

   void rotate(int[][] matrix) {
      int size = matrix.length;
      for (int level = 0; level < size / 2; level++) {
         for (int i = level; i < size - level - 1; i++) {
            int aux = matrix[level][i];
            matrix[level][i] = matrix[size - i - 1][level];
            matrix[size - i - 1][level] = matrix[size - level - 1][size - i - 1];
            matrix[size - level - 1][size - i - 1] = matrix[i][size - level - 1];
            matrix[i][size - level - 1] = aux;
         }
      }
   }

   public static void main(String[] args) {
      int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
      new MatrixRotation().rotate(matrix);
      for (int[] i : matrix) {
         System.out.println(Arrays.toString(i));
      }
   }

}
