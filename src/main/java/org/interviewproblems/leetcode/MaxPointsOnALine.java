package org.interviewproblems.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxPointsOnALine {

   static class Point {

      int x;
      int y;

      Point() {
         x = 0;
         y = 0;
      }

      Point(int a, int b) {
         x = a;
         y = b;
      }
   }


   static class Line {
      int supA, subA;
      int supB, subB;
      boolean vertical;
      int vPos;


      Line(Point p0, Point p1) {

         if (p0.x == p1.x && p0.y != p1.y) {
            vertical = true;
            vPos = p0.x;
            return;
         }

         supA = p0.y - p1.y;
         subA = p0.x - p1.x;

         int gcd = gcd(supA, subA);
         supA /= gcd;
         subA /= gcd;

         supB = p0.y * (p0.x - p1.x) - p0.x * (p0.y - p1.y);
         subB = p0.x - p1.x;
         gcd = gcd(supB, subB);
         supB /= gcd;
         subB /= gcd;

         if (supA == 0) subA = 1;
         if (supB == 0) subB = 1;
      }

      int gcd(int a, int b) {
         int max = Math.max(Math.abs(a), Math.abs(b));
         int min = Math.min(Math.abs(a), Math.abs(b));
         if (min == 0) return 1;
         while (max % min != 0) {
            int aux = max % min;
            max = min;
            min = aux;
         }
         return min;
      }

      boolean isDot() {
         return !vertical && supA == supB && subA == subB;
      }

      public boolean equals(Object ol) {
         Line o = (Line) ol;
         if (vertical) return o.vertical && vPos == o.vPos;
         return supA == o.supA && subA == o.subA && supB == o.supB && subB == o.subB;
      }

      public int hashCode() {
         return vertical? vPos : supA + supB + subA + subB;
      }
   }

   public static int maxPoints(Point[] in) {
      if (in.length == 0) return 0;
      int max = 1;
      for (Point p : in) {
         Map<Line, Set<Point>> lines = new HashMap<Line, Set<Point>>();
         for (Point p2 : in) {
            if (p2 != p) {
               Line l = new Line(p, p2);
               Set<Point> points = lines.get(l);
               if (points != null) {
                  points.add(p2);
               } else {
                  points = new HashSet<Point>();
                  points.add(p);
                  points.add(p2);
                  lines.put(l, points);
               }
               if (!l.isDot()) {
                  Set<Point> jxt = lines.get(new Line(p2,p2));
                  if (jxt != null) {
                     points.addAll(jxt);
                  }
               }
            }
         }
         for (Set<Point> i : lines.values()) max = Math.max(max, i.size());
      }
      return max;
   }

   public static void main(String[] args) {
      Point[] points = new Point[]{new Point(4, 0), new Point(4, -1), new Point(4, 5)};
      System.out.println("maxPoints(points) = " + maxPoints(points));
   }
}