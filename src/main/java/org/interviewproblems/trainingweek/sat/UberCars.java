package org.interviewproblems.trainingweek.sat;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class UberCars {


   static class Node {
      Map<Node, Integer> neighbours = new HashMap<Node,Integer>();
      int id;
      boolean visited;
      int dist;

      @Override
      public String toString() {
         return "Trie{" +
               "id=" + id +
               ", visited=" + visited +
               ", dist=" + dist +
               '}';
      }

      public Node(int from) {
         this.id = from;
      }

      public void addNeighbour(Node nodeTo, int dist) {
         neighbours.put(nodeTo, dist);
         nodeTo.neighbours.put(this, dist);
      }
   }

   public static void find_closest_car(String[] city_map, Integer[] cars, Integer customer) {

      Map<Integer, Node> nodes = new HashMap<Integer, Node>();
      for (String s : city_map) {
         String[] vals = s.split(",");
         int dist = Integer.parseInt(vals[2]);
         int from = Integer.parseInt(vals[0]);
         int to = Integer.parseInt(vals[1]);
         Node nodeFrom = nodes.get(from);
         if (nodeFrom == null) {
            nodeFrom = new Node(from);
            nodes.put(from, nodeFrom);
         }
         Node nodeTo = nodes.get(to);
         if (nodeTo == null) {
            nodeTo = new Node(to);
            nodes.put(to, nodeTo);
         }
         nodeFrom.addNeighbour(nodeTo, dist);
      }


      HashMap<Integer, Integer> carsSet = new HashMap<Integer, Integer>();
      for (int i  = 0; i < cars.length; i++) carsSet.put(cars[i], i+1);

      Queue<Node> q = new ArrayDeque<Node>();
      Node start = nodes.get(customer);

      if (carsSet.containsKey(start.id)) {
         System.out.println(carsSet.get(start.id));
         return;
      }

      start.visited = true;
      q.add(start);

      int minDistance = Integer.MAX_VALUE;
      int car = -1;
      while (!q.isEmpty()) {
         Node remove = q.remove();
         for (Map.Entry<Node,Integer> e : remove.neighbours.entrySet()) {
            Node n = e.getKey();
            if (!n.visited) {
               n.visited = true;
               n.dist = e.getValue() + remove.dist;
               q.add(n);
            } else {
               n.dist = Math.min(n.dist, remove.dist + e.getValue());
            }
            if (carsSet.containsKey(n.id) && (n.dist < minDistance || (n.dist == minDistance && carsSet.get(n.id) < car))) {
               minDistance = n.dist;
               car = carsSet.get(n.id);
            }
         }
      }

      System.out.println("minDistance = " + minDistance);

      System.out.println(car);
   }

   public static void main(String[] args) {
      String[] city_map = {};
      Integer[] cars = {};
      find_closest_car(city_map, cars, 1);
   }
}
