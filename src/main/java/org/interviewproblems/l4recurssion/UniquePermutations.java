package org.interviewproblems.l4recurssion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniquePermutations {

   public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
      long start = System.currentTimeMillis();
      List<Integer> numList = new ArrayList<Integer>();
      for (int i : num) numList.add(i);
      Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
      _permuteUnique(numList, result, num.length);
      try {
         return new ArrayList<ArrayList<Integer>>(result);
      } finally {
         System.out.println("It took:" + (System.currentTimeMillis() - start));
      }
   }

   public ArrayList<ArrayList<Integer>> _permuteUnique(List<Integer> num, Set<ArrayList<Integer>> solutions, int solSize) {
      ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
      if (num.size() == 1) {
         ArrayList<Integer> al = new ArrayList<Integer>();
         al.addAll(num);
         result.add(al);
         if (solSize == 1) {
            solutions.add(al);
         }
         return result;
      }
      Set<List<Integer>> submitted = new HashSet<List<Integer>>();

      for (int i = 0; i < num.size(); i++) {
         List<Integer> copy = new ArrayList<Integer>(num);
         Integer base = copy.remove(i);
         ArrayList<ArrayList<Integer>> partial = _permuteUnique(copy, solutions, solSize);
         if (submitted.contains(copy)) {
            continue;
         }
         submitted.add(copy);

         for (ArrayList<Integer> p : partial) {
            p.add(0, base);
            if (p.size() == solSize) {
               solutions.add(p);
            }
            result.add(p);
         }
      }
      return result;
   }

   public static void main(String[] args) {
      ArrayList<ArrayList<Integer>> result = new UniquePermutations().permuteUnique(new int[]{3, 3, 0, 0, 2, 3, 2});
      System.out.println(result.size());
   }
}
