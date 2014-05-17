package org.interviewproblems.EoPI;

import java.util.Arrays;

public class P6_13RotateAnArrayInplace {

   public static void rotateInplace(int[] in, int k) {
      rotate(in, k, k, in[0], 0);
      for (int i = 1; i < k; i++) {
         boolean done = false;
         for (int j = 0; j < i; j++) {
            if (alreadyProcessed(in, j + k, k, j, i)) {
               done = true;
               break;
            }
         }
         if (!done) rotate(in, i + k, k, in[i], i);
      }
   }

   private static boolean alreadyProcessed(int[] in, int pos, int k, int start, int target) {
      if (pos == target) return true;
      if (pos == start) return false;
      return alreadyProcessed(in, (pos + k) % in.length, k, start, target);
   }

   private static void rotate(int[] in, int pos, int k, int val, int start) {
      int aux = in[pos];
      in[pos] = val;
      if (pos == start) return;
         rotate(in, (pos + k) % in.length, k, aux, start);
   }

   public static void main(String[] args) {
      int[] in = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
      rotateInplace(in, 3);
      System.out.println("Arrays.toString(in) = " + Arrays.toString(in));
      in = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
      rotateInplace(in, 1);
      System.out.println("Arrays.toString(in) = " + Arrays.toString(in));
   }
}
