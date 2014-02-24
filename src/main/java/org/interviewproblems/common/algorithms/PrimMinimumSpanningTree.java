package org.interviewproblems.common.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrimMinimumSpanningTree {

   static class Node {
      //node -> weight
      Map<Node, Integer> out = new HashMap<Node, Integer>();
      Character id;
      boolean oriented = false;

      Node(Character id) {
         this.id = id;
      }

      public Node addOut(Node o, int distance) {
         out.put(o, distance);
         if (!oriented) o.out.put(this, distance);
         return this;
      }
   }


   static class Graph {
      //id -> node
      Map<Character, Node> nodes = new HashMap<Character, Node>();

      public int verticesCount() {
         return nodes.size();
      }

      public List<Character> vertices() {
         return new ArrayList<Character>(nodes.keySet());
      }

      public void add(Node... nodes) {
         for (Node n : nodes) this.nodes.put(n.id, n);
      }
   }


   /**
    * Returns the size of the minimum spanning tree.
    * Complexity O (n * n)
    */
   public static int primAlgorithm(Graph graph, char start) {
      List<Character> vertices = graph.vertices();

      Map<Character, Integer> node2distance = new HashMap<Character, Integer>();
      for (char i : vertices) node2distance.put(i, Integer.MAX_VALUE);
      //whether the vertex was added to minimum spanning tree yet or not
      Set<Character> added = new HashSet<Character>();

      int result = 0;

      char v = start;
      while (!added.contains(v)) {
         System.out.println("v = " + v);
         added.add(v);
         Node node = graph.nodes.get(v);
         for (Map.Entry<Node, Integer> e : node.out.entrySet()) {
            char outNode = e.getKey().id;
            if (node2distance.get(outNode) > e.getValue() && !added.contains(outNode)) {
               node2distance.put(outNode, e.getValue());
            }
         }

         int minDistance = Integer.MAX_VALUE;
         for (Map.Entry<Character, Integer> e : node2distance.entrySet()) {
            if (e.getValue() < minDistance && !added.contains(e.getKey())) {
               minDistance = e.getValue();
               v = e.getKey();
            }
         }
         if (!added.contains(v))
            result += minDistance;
      }

      return result;
   }


   public static void main(String[] args) {
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

      System.out.println("primAlgorithm(graph) = " + primAlgorithm(graph, 'A'));
   }

}
