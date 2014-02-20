package org.interviewproblems.trainingweek.thu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class PalindromePartitioning {

      public ArrayList<ArrayList<String>> partition(String s) {
         Deque<String> solution = new ArrayDeque<String>();
         ArrayList<ArrayList<String>> allSolutions = new ArrayList<ArrayList<String>>();
         partition(s, solution, allSolutions);
         return allSolutions;
      }

      public void partition(String s, Deque<String> stack, ArrayList<ArrayList<String>> allSolutions) {
         if (s.length() == 0) {
            if (!stack.isEmpty()) allSolutions.add(new ArrayList<String>(stack));
            return;
         }

         for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
               stack.addLast(s.substring(0, i + 1));
               partition(s.substring(i+1), stack, allSolutions);
               stack.removeLast();
            }
         }
      }

      private boolean isPalindrome(String s) {
         for (int  i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
         }
         return true;
      }


   public ArrayList<ArrayList<String>> _partition(String s) {
      ArrayList<ArrayList<String>> solution = new ArrayList<ArrayList<String>>();

      if (s.length() == 0) {
         ArrayList<String> res = new ArrayList<String>();
         solution.add(res);
         return solution;
      }

      for (int i = 0; i < s.length(); i++) {
         if (isPalindrome(s.substring(0, i + 1))) {
            for (ArrayList<String> p : _decoratedPartition(s.substring(i+1))) {
               ArrayList<String> copy = new ArrayList<String>(p);
               copy.add(0, s.substring(0, i + 1));
               solution.add(copy);
            }
         }
      }
      return solution;
   }

   Map<String, ArrayList<ArrayList<String>>> cache = new HashMap<String, ArrayList<ArrayList<String>>>();
   ArrayList<ArrayList<String>> _decoratedPartition(String s) {
      if (cache.containsKey(s)) return cache.get(s);
      ArrayList<ArrayList<String>> r = _partition(s);
      cache.put(s,r);
      return r;
   }

}
