package org.interviewproblems.l4recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

//http://oj.leetcode.com/problems/combination-sum/
public class CombinationSum {
   public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
      Arrays.sort(candidates);
      ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
      Deque<Integer> currentSolution = new LinkedList<Integer>();
      _combinationSum(candidates, 0, target, solutions, currentSolution);
      return solutions;
   }

   private void _combinationSum(int[] candidates, int pos, int remaining, ArrayList<ArrayList<Integer>> solutions, Deque<Integer> currentSolution) {
      if (remaining == 0) {
         ArrayList<Integer> sol = new ArrayList<Integer>(currentSolution);
         Collections.reverse(sol);
         solutions.add(sol);
         return;
      }
      if (remaining < 0 || pos == candidates.length) {
         return;
      }
      for (int i = 0; i <= remaining/candidates[pos]; i++) {
         for (int j = 0; j < i; j++) {
            currentSolution.push(candidates[pos]);
         }

         int remainingNext = remaining - candidates[pos] * i;
         _combinationSum(candidates, pos + 1, remainingNext, solutions, currentSolution);
         for (int j = 0; j < i; j++) {
            currentSolution.pop();
         }
      }
   }
}
