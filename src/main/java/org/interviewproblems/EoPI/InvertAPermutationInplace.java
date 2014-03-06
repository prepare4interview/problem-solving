package org.interviewproblems.EoPI;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//P6.10
public class InvertAPermutationInplace {

   public static void invert(int[] p) {
      if (p.length == 0) return;
      invert(p, p[0], 0, 0);
      for (int i = 1; i < p.length; i++) {
         if (!hasBeenProcessed(p, p[i], i)) invert(p, p[i], i, i);
      }
   }

   private static boolean hasBeenProcessed(int[] p, int i, int start) {
      if (i < start) return true;
      if (i == start) return false;
      return hasBeenProcessed(p, p[i], start);
   }

   private static void invert(int[] p, int index, int val, int start) {
      if (p[index] == val) return;
      int aux = p[index];
      p[index] = val;
      if (index != start)
         invert(p, aux, index, start);
   }


   public static void main(String[] args) {
      Random r = new Random();

      for (int i = 0; i < 1000; i++) {
         List<Integer> pList = new ArrayList<Integer>();
         for (int j = 0; j < r.nextInt(1000); j++)
            pList.add(j);
         Collections.shuffle(pList);
         int[] p = new int[pList.size()];
         for (int j = 0; j < pList.size(); j++)
            p[j] = pList.get(j);

         int[] pCopy = new int[p.length];
         System.arraycopy(p, 0, pCopy, 0, p.length);
         invert(p);
         for (int j = 0; j < p.length; j++) {
            assert pCopy[p[j]] == j : Arrays.toString(p);
         }

         System.out.println("p.length = " + p.length);

      }
      assert false : "check -ae";

   }
}
