package org.interviewproblems.play;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Combinations2 {

   static Collection<List<Integer>> combinatios(int n, int k) {
      Collection<List<Integer>> result = new ArrayList<List<Integer>>();
      _combinatios(1, n, k, result, new ArrayDeque<Integer>());
      return result;
   }

   static void _combinatios(int start, int n, int k, Collection<List<Integer>> res, ArrayDeque<Integer> current) {
      if (current.size() == k) {
         ArrayList<Integer> e = new ArrayList<Integer>(current);
         Collections.reverse(e);
         res.add(e);
         return;
      }
      for (int i = start; i <= n; i++) {
         current.push(i);
         _combinatios(i + 1, n, k, res, current);
         current.pop();
      }
   }

   public static void main(String[] args) {
      System.out.println("combinatios(11, 2) = " + combinatios(11, 2));
      System.out.println("combinatios(11, 2) = " + combinatios(11, 2).size());
   }

}
