package org.interviewproblems.l4recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sum3Numbers {

   public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
      ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
      Set<ArrayList<Integer>> resultSet = new HashSet<ArrayList<Integer>>();

      if (num.length < 3) return result;

      Map<Integer, List<Integer>> cache = new HashMap<Integer, List<Integer>>();
      for (int i = 0; i < num.length; i++) {
         List<Integer> integers = cache.get(num[i]);
         if (integers == null) {
            integers = new ArrayList<Integer>();
            cache.put(num[i], integers);
         }
         integers.add(i);
      }

      for (int i = 0; i < num.length; i++) {
         for (int j = i + 1; j < num.length; j++) {
            List<Integer> match = cache.get(-num[i] - num[j]);
            if (match == null) continue;
            for (int k : match) {
               if (k > j) {
                  resultSet.add(new ArrayList<Integer>(Arrays.asList(num[i], num[j], num[k])));
                  break;
               }
            }
         }
      }


      result.addAll(resultSet);
      return result;
   }

   public static void main(String[] args) {
      int[] numbers = new int[]{-4,-5,-6,3,11,-13,3,14,1,-10,11,6,8,9,-6,-9,6,3,-15,-8,0,5,6,-8,14,-11,0,2,14,-15,14,-13,-5,-15,5,13,-13,-6,13,-4,-1,1,-13,14,-13,-12,-10,9,6,12,8,14,-5,-8,-9,-6,-4,-2,3,-5,-2,-6,-2,1,-5,-12,-1,-11,-11,-11,0,-4,-2,-5,-5,0,-2,-7,-14,-10,-10,10,-11,-8,-13,-13,1,-2,-7,11,8,6,-9,-9,14,1,-13,-9,-3,-9,-5,13,2,8,-7,13,-14,6,-9,-13,3,-12};
      System.out.println("numbers.length = " + numbers.length);
      long start = System.currentTimeMillis();
      ArrayList<ArrayList<Integer>> arrayLists = new Sum3Numbers().threeSum(numbers);
      Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(arrayLists);
      System.out.println("new Solution().threeSum(numbers); = " + arrayLists.size());
      System.out.println("new Solution().threeSum(numbers); = " + set.size());
      System.out.println("Duration: " + (System.currentTimeMillis() - start));

   }
}
