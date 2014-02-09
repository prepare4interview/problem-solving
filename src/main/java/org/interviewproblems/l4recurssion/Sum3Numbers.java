package org.interviewproblems.l4recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum3Numbers {

   public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
      ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

      if (num.length < 3) return result;

      Map<Integer, List<List<Integer>>> cache = new HashMap<Integer, List<List<Integer>>>();
      for (int i = 1; i < num.length; i++) {
         for (int j = i + 1; j < num.length; j++) {
            int sum = num[i] + num[j];
            List<List<Integer>> integers = cache.get(sum);
            if (integers == null) {
               integers = new ArrayList<List<Integer>>();
               cache.put(sum, integers);
            }
            integers.add(Arrays.asList(i,j));
         }
      }

      for (int i = 0; i < num.length; i++) {
         List<List<Integer>>  list = cache.get(-num[i]);
         if (list == null) continue;
         for (List<Integer> sol: list) {
            if (sol != null && sol.get(0) > i) {
               ArrayList<Integer> solution = new ArrayList<Integer>();
               solution.add(num[i]);
               solution.add(num[sol.get(0)]);
               solution.add(num[sol.get(1)]);
               result.add(solution);
            }
         }
      }
      return result;
   }

   public static void main(String[] args) {
      int[] numbers = new int[]{0, 7, -4, -7, 0, 14, -6, -4, -12, 11, 4, 9, 7, 4, -10, 8, 10, 5, 4, 14, 6, 0, -9, 5, 6, 6, -11, 1, -8, -1, 2, -1, 13, 5, -1, -2, 4, 9, 9, -1, -3, -1, -7, 11, 10, -2, -4, 5, 10, -15, -4, -6, -8, 2, 14, 13, -7, 11, -9, -8, -13, 0, -1, -15, -10, 13, -2, 1, -1, -15, 7, 3, -9, 7, -1, -14, -10, 2, 6, 8, -6, -12, -13, 1, -3, 8, -9, -2, 4, -2, -3, 6, 5, 11, 6, 11, 10, 12, -11, -14};
      System.out.println("numbers.length = " + numbers.length);
      long start = System.currentTimeMillis();
      System.out.println("new Solution().threeSum(numbers); = " + new Sum3Numbers().threeSum(numbers).size());
      System.out.println("Duration: " + (System.currentTimeMillis() - start));

   }
}
