package org.interviewproblems.trainingweek.tue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationSequence {

   public String getPermutation(int n, int k) {
      // int[] perms = new int[n];
      ArrayList<Integer> elements = new ArrayList<Integer>();
      for (int i = 1; i <= n; i++) elements.add(i);
      getPermutation2(k, elements);
      return result;
   }

   String result = "";
   public void getPermutation2(int k, List<Integer> remaining) {
      if (remaining.size() == 1) {
         result += remaining.remove(0);
         return;
      }
      int window = 1;
      for (int i = 1; i < remaining.size(); i++) window *= i;
      int pos = (k-1) / window;
      result += remaining.remove(pos);
      getPermutation2(k - window * pos, remaining);
   }

   int count = 0;
   Set<Integer> currentPerm = new HashSet<Integer>();

   public String getPermutations(int n, int k, int pos, int[] perms) {
      if (pos == n) {
         int sum = 0;
         for (int i : perms) sum += i;
         if (sum == (n * (n + 1))/2) count ++;
         if (count == k) {
            StringBuilder result = new StringBuilder();
            for (int i : perms) result.append(i);
            return result.toString();
         }
         return null;
      }
      for (int i = 1; i <= n; i++) {
         if (!currentPerm.add(i)) continue;
         perms[pos] = i;
         String sol = getPermutations(n, k, pos + 1, perms);
         if (sol != null)
            return sol;
         currentPerm.remove(i);
      }
      return null;
   }
}
