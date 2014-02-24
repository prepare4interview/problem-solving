package org.interviewproblems.mocks.m1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//a + b = S from a list of 1000 positive ints up to 1000. code it.
public class Pb1Sum {

   // complexity: O(n)
   // space: O(n)
   // note: we can implement it with O(n*log(n)) complexity and 0 space complexity by sorting it.
   public static void impl(int[] in, int sum) {
      Map<Integer, List<Integer>> num2Index = new HashMap<Integer, List<Integer>>();
      for (int i = 0; i < in.length; i++) {
         List<Integer> nr = num2Index.get(in[i]);
         if (nr == null) {
            nr = new ArrayList<Integer>();
            num2Index.put(in[i], nr);
         }
         nr.add(i);
      }

      for (int i = 0; i < in.length; i++) {
         List<Integer> indexes = num2Index.get(sum - in[i]);
         if (indexes != null)
            for (int j : indexes) {
               if (i != j) {
                  System.out.printf("first index is %s and second index is %s ", i, j);
                  return;
               }
            }
      }
   }

   public static void main(String[] args) {
      int[] in = new int[1000];
      Random r = new Random();
      for (int i = 0; i < 1000; i++)
         in[i] = r.nextInt();

      int sum = in[7] + in[490];

      impl(in, sum);

   }
}
