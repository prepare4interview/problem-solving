package org.interviewproblems.trainingweek.fri;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordLadder {

   class Node {
      Set<Node> adj = new HashSet<Node>();
      String word;
      Node (String w) {this.word = w;}
      void addAdj(Node n) {
         adj.add(n);
         n.adj.add(this);
      }
      Node from;
      boolean visited;
   }

   public int ladderLength(String start, String end, HashSet<String> dict) {
      HashMap<String, Node> nodes = new HashMap<String, Node>();
      HashMap<String, Set<Node>> helper = new HashMap<String, Set<Node>>();
      for (String s : dict) {
         Node n = new Node(s);
         nodes.put(s, n);
         for (int i = 0; i < s.length(); i++) {
            String d = s.substring(0, i) + "_" + s.substring(i+1);
            Set<Node> ln = helper.get(d);
            if (ln == null) {
               ln = new HashSet<Node>();
               helper.put(d, ln);
            }
            for (Node e : ln) e.addAdj(n);
            ln.add(n);
         }
      }

      Node s = nodes.get(start);
      Node e = nodes.get(end);
      if (s.adj.contains(e)) {
         return 2;
      }

      Deque<Node> q = new ArrayDeque<Node>();
      s.visited = true;
      q.addLast(s);
      while (!q.isEmpty()) {
         Node n = q.removeFirst();
         for (Node a : n.adj) {
            if (!a.visited) {
               a.from = n;
               if (a.adj.contains(e)) {
                  int res = 2;
                  while (a.from != null) {
                     res++;
                     a = a.from;
                  }
                  return res;
               }
               a.visited = true;
               q.addLast(a);
            }
         }
      }

      return 0;
   }

   public static void main(String[] args) {
      HashSet<String> s = new HashSet<String>();
      Collections.addAll(s, "talk","tons","fall","tail","gale","hall","negs");
      int res = new WordLadder().ladderLength("talk", "tail", s);
      System.out.println("res = " + res);
   }
}
