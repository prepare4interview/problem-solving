package org.interviewproblems.play;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Partitions {

   Collection<List<Integer>> partitions(int n) {
      return _partitions(n);
   }

   private Collection<List<Integer>> _partitions(int n) {
      Collection<List<Integer>> ret = new ArrayList<List<Integer>>();
      if (n == 1) {
         ArrayList<Integer> e = new ArrayList<Integer>();
         e.add(1);
         ret.add(e);
         return ret;
      }
      for (List<Integer> l : _partitions(n - 1)) {
         for (int i = 0; i <= l.size(); i++) {
            ArrayList<Integer> copy = new ArrayList<Integer>(l);
            copy.add(i, n);
            ret.add(copy);
         }
      }
      return ret;
   }

   public static void main(String[] args) {
      Collection<List<Integer>> partitions = new Partitions().partitions(3);
      System.out.println("partitions = " + partitions);
   }

}
