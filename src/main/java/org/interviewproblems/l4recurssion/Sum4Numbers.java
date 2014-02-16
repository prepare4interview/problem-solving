package org.interviewproblems.l4recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sum4Numbers {

   public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
      Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
      if (num.length < 4)
         return toResult(result);

      Arrays.sort(num);
      //invariant a < b < c < d

      for (int a = 0; a < num.length - 3; a++) {
         for (int b = a + 1; b < num.length - 2; b++) {
            int remaining = target - (num[a] + num[b]);
            int c = b + 1;
            int d = num.length - 1;

            while (c < d) {
               while (num[c] + num[d] > remaining && d > c) {
                  d--;
               }
               if (d == c) break;
               if (num[c] + num[d] == remaining) {
                  Integer[] ints = {num[a], num[b], num[c], num[d]};
                  Arrays.sort(ints);
                  result.add(new ArrayList<Integer>(Arrays.asList(ints)));
               }
               c++;
            }
         }
      }

      return toResult(result);
   }

   private ArrayList<ArrayList<Integer>> toResult(Set<ArrayList<Integer>> result) {
      return new ArrayList<ArrayList<Integer>>(result);
   }

   public static void main(String[] args) {
      ArrayList<ArrayList<Integer>> arrayLists = new Sum4Numbers().fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);
      System.out.println("arrayLists = " + arrayLists);
   }
}
