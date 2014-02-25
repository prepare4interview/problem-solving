package org.interviewproblems.mocks.m1;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * find a subset that sums to S from 1000 elements up to 1000. code it, return the set explained the O(n) memory
 * algorithm.
 */
public class Pb2Subset {

   static Set<Integer> subset(int[] in, int index, int s) {
      if (s == 0) return new HashSet<Integer>();
      if (index == in.length - 1) {
         if (in[index] == s) {
            System.out.println("Last element is " + in[index] + " sum  is " + s);
            return new HashSet<Integer>();
         } else return null;
      }
      Set<Integer> result = subset(in, index + 1, s - in[index]);
      if (result != null) {
         System.out.println("index = " + index);
         result.add(in[index]);
         return result;
      }
      Set<Integer> subset = subset(in, index + 1, s);
      result = subset;
      if (result != null) {
         return result;
      }
      return null;
   }

   static class Pair {
      int i, j;
      int val;

      Pair(int i, int j, int val) {
         this.i = i;
         this.j = j;
         this.val = val;
      }

      boolean isEnd() {
         return i == -1 && j == -1;
      }
   }

   //got the idea from here: http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
   public static Set<Integer> subsetDynamic(int in[], int s) {
      Pair[][] result = new Pair[s + 1][in.length + 1];
      for (int i = 0; i <= in.length; i++) result[0][i] = new Pair(-1, -1, 0);

      for (int i = 1; i <= s; i++) {
         for (int j = 1; j <= in.length; j++) {
            if (result[i][j - 1] != null) {
               result[i][j] = result[i] [j-1];
            } else {
               if (i >= in[j - 1]) {
                  int diff = i - in[j - 1];
                  if (result[diff][j - 1] != null)
                     result[i][j] = new Pair(diff, j - 1, in[j-1]);
               }
            }
         }
      }

      Pair p = result[s][in.length];
      if (p == null) return Collections.emptySet();
      Set<Integer> r = new HashSet<Integer>();
      while (!p.isEnd()) {
         r.add(p.val);
         p = result[p.i][p.j];
      }
      return r;
   }

   public static void main(String[] args) {
      int LENGTH = 30;
      int[] in = new int[LENGTH];
      Random r = new Random();
      for (int i = 0; i < LENGTH; i++)
         in[i] = r.nextInt(10000);

      int sum = in[7] + in[12] + in[19];

      long start = System.currentTimeMillis();
      Set<Integer> subset = subsetDynamic(in, sum);
      System.out.println("It took: " + (System.currentTimeMillis() - start));
      int sumCheck = 0;
      for (int i : subset) sumCheck += i;
      System.out.printf("Sum is %s, check is %s, correct? %s\n", sum, sumCheck, (sum == sumCheck));
      System.out.println("subset = " + subset);
      System.out.println("subset.size() = " + subset.size());
   }
}
