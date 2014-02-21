package org.interviewproblems.trainingweek.fri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MinimumWindowSubstring {

   public String minWindow(String s, String t) {
      Map<Character, List<Integer>> m = new HashMap<Character, List<Integer>>();
      for (int i = 0; i < s.length(); i++) {
         List<Integer> l = m.get(s.charAt(i));
         if (l == null) {
            l = new ArrayList<Integer>();
            m.put(s.charAt(i), l);
         }
         l.add(i);
      }

      Map<Character, Integer> o = new HashMap<Character, Integer>();
      for (int i = 0; i < t.length(); i++) {
         Character c = t.charAt(i);
         if (o.containsKey(c))
            o.put(c, o.get(c) + 1);
         else o.put(c, 1);
      }

      PriorityQueue<Pos> solution = new PriorityQueue<Pos>();
      int max = Integer.MIN_VALUE;
      for (char i : o.keySet()) {
         List<Integer> l = m.get(i);
         int count = o.get(i);
         if (l == null || count > l.size())  return "";
         for (int j = 0; j < count; j++) {
            solution.add(new Pos(i, l.get(j)));
            max = Math.max(max, l.get(j));
         }
      }

      String result = s.substring(solution.peek().pos, max + 1);

      while (true) {
         Pos p = solution.remove();
         List<Integer> l = m.get(p.c);
         l.remove(0);
         if (l.size() < o.get(p.c)) return result;
         Pos newP = new Pos(p.c, l.get(o.get(p.c) -1));
         solution.add(newP);
         max = Math.max(max, newP.pos);
         int newMin = solution.peek().pos;
         if (max - newMin + 1 < result.length() || result.length() == 0)
            result = s.substring(newMin, max + 1);
      }
   }

   class Pos implements Comparable<Pos> {
      char c;
      int pos;

      Pos(char c, int pos) {
         this.c = c;
         this.pos = pos;
      }

      @Override
      public int compareTo(Pos o) {
         return this.pos - o.pos;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         Pos pos1 = (Pos) o;

         if (c != pos1.c) return false;
         if (pos != pos1.pos) return false;

         return true;
      }

      @Override
      public int hashCode() {
         int result = (int) c;
         result = 31 * result + pos;
         return result;
      }
   }


   public static void main(String[] args) {
      long start = System.currentTimeMillis();
      String s = "acbbaca";
      String t = "aba";
      System.out.println("t.length() = " + t.length());
      String res = new MinimumWindowSubstring().minWindow(s, t);
      System.out.println(System.currentTimeMillis() - start);
      System.out.println("res = " + res);
   }
}
