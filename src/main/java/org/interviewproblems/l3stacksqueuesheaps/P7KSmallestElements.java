package org.interviewproblems.l3stacksqueuesheaps;

/**
 * Given an array of length n, find out it's k smallest elements.
 */
public class P7KSmallestElements {

   public int[] smallest(int[] in, int k) {
      if (k == 0) return new int[0];
      int rnd = in.length / 2;
      int[] split = dutchFlag(in, rnd);
      if (k < split[0]) {
         int[] sub = new int[split[0]];
         System.arraycopy(in, 0, sub, 0, split[0]);
         return smallest(sub, k);
      } else if (k <= split[1]) {
         int[] sub = new int[k];
         System.arraycopy(in, 0, sub, 0, k);
         return sub;
      } else {
         int[] surelySmaller = new int[split[1]];
         System.arraycopy(in, 0, surelySmaller, 0, split[1]);
         int[] stillToBeSearched = new int[in.length - split[1]];
         System.arraycopy(in, split[1], stillToBeSearched, 0, stillToBeSearched.length);
         int[] remaining = smallest(stillToBeSearched, k - surelySmaller.length);
         return union(surelySmaller, remaining);
      }
   }

   private int[] union(int[] surelySmaller, int[] remaining) {
      int[] result = new int[surelySmaller.length + remaining.length];
      System.arraycopy(surelySmaller, 0, result, 0, surelySmaller.length);
      System.arraycopy(remaining, 0, result, surelySmaller.length, remaining.length);
      return result;
   }

   /**
    * lower : 0, lo-1 equal : lo, eq-1 unprocessed: eq,hi higher: hi+1, in.length
    */
   public int[] dutchFlag(int[] in, int pivotIndex) {
      int lo = 0, eq = 0, hi = in.length - 1;
      int pivot = in[pivotIndex];
      while (eq <= hi) {
         if (in[eq] < pivot) {
            swap(in, eq++, lo++);
         } else if (in[eq] == pivot) {
            eq++;
         } else {
            swap(in, eq, hi--);
         }
      }
      return new int[]{lo, eq};
   }


   private void swap(int[] in, int i, int i1) {
      int aux = in[i];
      in[i] = in[i1];
      in[i1] = aux;
   }
}
