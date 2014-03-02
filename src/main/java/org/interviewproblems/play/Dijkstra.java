package org.interviewproblems.play;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dijkstra {

   static boolean bidirectional;

   static class Node {
      Map<Node, Integer> out = new HashMap<Node, Integer>();
      String name;

      Node(String name) {
         this.name = name;
      }

      public Node(char a) {
         this(String.valueOf(a));
      }

      public Node addOut(Node dest, int size) {
         out.put(dest, size);
         if (bidirectional) dest.out.put(this, size);
         return this;
      }

      @Override
      public String toString() {
         return "Node{" +
               "name='" + name + '\'' +
               '}';
      }
   }

   static class Graph {
      Map<String, Node> nodes = new HashMap<String, Node>();

      public void add(Node ... nodes) {
         for (Node n : nodes) this.nodes.put(n.name, n);
      }
   }


   static public int distance(Graph g, Node start, Node end) {
      Map<Node, Integer> distances = new HashMap<Node, Integer>();
      Set<Node> processed = new HashSet<Node>();
      for (Node n : g.nodes.values()) distances.put(n, Integer.MAX_VALUE);

      Node v = start;
      int minDist = 0;
      while (!processed.contains(v)) {
         distances.put(v, minDist);
         processed.add(v);
         for (Node n : v.out.keySet()) {
            if (!processed.contains(n) && distances.get(n) > minDist + v.out.get(n)) {
               distances.put(n, minDist + v.out.get(n));
            }
         }
         minDist = Integer.MAX_VALUE;
         for (Node n : g.nodes.values()) {
            if (!processed.contains(n) && distances.get(n) < minDist) {
               minDist = distances.get(n);
               v = n;
            }
         }
      }

      return distances.get(end);
   }

   static public int minimumSpanningTree(Graph g, Node start) {
      Map<Node, Integer> distances = new HashMap<Node, Integer>();
      Set<Node> processed = new HashSet<Node>();
      for (Node n : g.nodes.values()) distances.put(n, Integer.MAX_VALUE);

      Node v = start;
      int minDist = 0;
      int sol = 0;
      while (!processed.contains(v)) {
         sol += minDist;
         distances.put(v, minDist);
         processed.add(v);
         for (Node n : v.out.keySet()) {
            if (!processed.contains(n) && distances.get(n) > v.out.get(n)) {
               distances.put(n, v.out.get(n));
            }
         }
         minDist = Integer.MAX_VALUE;
         for (Node n : g.nodes.values()) {
            if (!processed.contains(n) && distances.get(n) < minDist) {
               minDist = distances.get(n);
               v = n;
            }
         }
      }

      return sol;

   }

   public static void main(String[] args) {
      dijkstra();
      prim();
   }

   private static void dijkstra() {
      Graph graph = new Graph();
      Node a = new Node('A');
      Node b = new Node('B');
      Node c = new Node('C');
      Node d = new Node('D');
      Node e = new Node('E');
      Node f = new Node('F');
      Node g = new Node('G');

      graph.add(a, b, c, d, e, f, g);
      a.addOut(b, 8).addOut(e, 10);
      b.addOut(e, 5).addOut(d, 2).addOut(c, 3);
      d.addOut(c, 2).addOut(e, 5).addOut(f, 10).addOut(g, 5);
      g.addOut(c, 2).addOut(f, 9);
      f.addOut(e, 13);

      for (Node n : graph.nodes.values()) {
         System.out.println("distance(graph, a, " + n.name + ") = " + distance(graph, a, n));
      }
   }

   private static void prim() {
      bidirectional = true;
      Graph graph = new Graph();
      Node a = new Node('A');
      Node b = new Node('B');
      Node c = new Node('C');
      Node d = new Node('D');
      Node e = new Node('E');
      Node f = new Node('F');
      Node g = new Node('G');

      graph.add(a, b, c, d, e, f, g);
      a.addOut(b, 8).addOut(e, 10);
      b.addOut(e, 5).addOut(d, 2).addOut(c, 3);
      d.addOut(c, 2).addOut(e, 5).addOut(f, 10).addOut(g, 5);
      g.addOut(c, 2).addOut(f, 9);
      f.addOut(e, 13);

      for (Node n : graph.nodes.values()) {
         System.out.println("minimumSpanningTree(graph, a, " + n.name + ") = " + minimumSpanningTree(graph, a));
      }
   }
}
