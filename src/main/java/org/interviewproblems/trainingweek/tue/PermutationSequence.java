package org.interviewproblems.trainingweek.tue;

public class PermutationSequence {

   public String getPermutation(int n, int k) {
      int[] perms = new int[n];
      return getPermutations(n, k, 0, perms);
   }

   int count = 0;

   public String getPermutations(int n, int k, int pos, int[] perms) {
      if (pos == n) {
         int sum = 0;
         for (int i : perms) sum += i;
         if (sum == (n * (n + 1))/2) {
            count ++;
         }
         if (count == k) {
            StringBuilder result = new StringBuilder();
            for (int i : perms) result.append(i);
            return result.toString();
         }
         return null;
      }
      for (int i = 1; i <= n; i++) {
         perms[pos] = i;
         String sol = getPermutations(n, k, pos + 1, perms);
         if (sol != null)
            return sol;
      }
      return null;
   }

   public static void main(String[] args) {
      PermutationSequence ps = new PermutationSequence();
      long duration = System.currentTimeMillis();
      String permutation = ps.getPermutation(9, 273815);
      System.out.println("took = " + (System.currentTimeMillis() - duration));
      System.out.println("permutation = " + permutation);
   }
}
