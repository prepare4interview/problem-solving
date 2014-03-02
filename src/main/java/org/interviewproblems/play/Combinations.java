package org.interviewproblems.play;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

   //generate all the combinations of t elements from p

   public static int combinations(int p, int t) {
      List<Integer> elements = new ArrayList<Integer>();
      for (int i = 0; i < p; i++) {
         elements.add(i);
      }
      List<List<Integer>> lists = _comb(t, elements);
      System.out.println("lists = " + lists);
      return lists.size();
   }

   private static List<List<Integer>> _comb(int count, List<Integer> elements) {
      if (count > elements.size()) return new ArrayList<List<Integer>>();
      if (count == 1) {
         ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
         for (Integer e : elements) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(e);
            res.add(list);
         }
         return res;
      }
      Integer e = elements.remove(0);
      List<List<Integer>> r1 = _comb(count, new ArrayList<Integer>(elements));
      List<List<Integer>> r2 = _comb(count - 1, new ArrayList<Integer>(elements));
      for (List<Integer> l : r2) l.add(0, e);
      r1.addAll(r2);
      return r1;
   }

   public static void main(String[] args) {
      System.out.println("combinations(6, 3) = " + combinations(6, 3));
   }

//   void quickFind(int[] a, int k) {
//      partition(a, a[1]); // a[1] pivot
//      int x= partition(a, a[0]); // a[0] pivot
//      if (x[0].length >= k) return quickfind(x[0], k);
//      return quickfind(x[1], k - x[0].length);
//   }

   private int partition(int[] a, int i) {
      return 0;  // TODO: Customise this generated block
   }
}
