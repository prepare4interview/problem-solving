package org.interviewproblems.l4recurssion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

   public ArrayList<ArrayList<Integer>> permute(int[] num) {
      List<Integer> numList = new ArrayList<Integer>();
      for (int i : num) numList.add(i);
      return _permute(numList);
   }

   public ArrayList<ArrayList<Integer>> _permute(List<Integer> num) {
      ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
      if (num.size() == 1) {
         ArrayList<Integer> al = new ArrayList<Integer>(Collections.singletonList(num.get(0)));
         solutions.add(al);
         return solutions;
      }
      for (int i = 0; i < num.size(); i++) {
         List<Integer> remaining = new ArrayList<Integer>(num);
         Integer pivot = remaining.remove(i);
         ArrayList<ArrayList<Integer>> subSols = _permute(remaining);
         for (ArrayList<Integer> al : subSols) {
            al.add(0, pivot);
            solutions.add(al);
         }
      }
      return solutions;
   }

   public static void main(String[] args) {
      ArrayList<ArrayList<Integer>> permute = new Permutations().permute(new int[]{1, 2, 3});
      System.out.println("permute = " + permute);
   }
}
