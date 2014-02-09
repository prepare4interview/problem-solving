package org.interviewproblems.l4recurssion;

import java.util.HashMap;
import java.util.Map;

//http://oj.leetcode.com/problems/two-sum/
public class ContainsKey {
   public int[] twoSum(int[] numbers, int target) {
      Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
      for (int i = 0; i < numbers.length; i++) {
         Integer sum = target - numbers[i];
         if (cache.containsKey(sum)) {
            return new int[]{cache.get(sum) + 1, i + 1};
         } else {
            cache.put(numbers[i], i);
         }
      }
      throw new IllegalArgumentException();
   }
}
