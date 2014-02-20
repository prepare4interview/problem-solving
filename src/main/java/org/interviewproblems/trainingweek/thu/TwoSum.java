package org.interviewproblems.trainingweek.thu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {

   public int[] twoSum(int[] numbers, int target) {
      Map<Integer, Set<Integer>> num2index = new HashMap<Integer, Set<Integer>>();
      for (int i = 0; i < numbers.length; i++) {
         Set<Integer> s = num2index.get(numbers[i]);
         if (s == null) {
            s = new HashSet<Integer>();
            num2index.put(numbers[i], s);
         }
         s.add(i);
      }
      for (int i = 0; i < numbers.length; i++) {
         Set<Integer> m = num2index.get(target - numbers[i]);
         if (m != null) {
            for (int j : m) {
               if (j != i) return new int[] { i + 1, j + 1};
            }
         }
      }
      return null;
   }

}
