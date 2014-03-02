package org.interviewproblems.cracking;

import java.util.ArrayDeque;
import java.util.Deque;

public class HanoiTowers {

   static int ops;

   static class Tower {
      Deque<Integer> stack = new ArrayDeque<Integer>();
      String name;

      Tower(String name) {
         this.name = name;
      }

      public void add(int i) {
         if (!stack.isEmpty() && stack.peek() < i)
            throw new IllegalArgumentException( i + " not allowed on top of " + stack.peek());
         stack.push(i);
      }

      public void move(int count, Tower dest, Tower buff) {
         if (count == 1) {
            System.out.println(name + "- " + stack.peek() + "->" + dest.name);
            dest.add(stack.pop());
            ops++;
            return;
         }
         move(count - 1, buff, dest);
         System.out.println(name + "- " + stack.peek() + "->" + dest.name);
         dest.add(stack.pop());
         ops++;
         buff.move(count - 1, dest, this);
      }


      public static void main(String[] args) {
         Tower a = new Tower("A");
         int nr = 5;
         for (int i = nr; i > 0; i--) a.add(i);
         Tower b = new Tower("B");
         Tower c = new Tower("C");
         a.move(nr, c, b);

         System.out.println("a.stack = " + a.stack);
         System.out.println("b.stack = " + b.stack);
         System.out.println("c.stack = " + c.stack);
         System.out.println("HanoiTowers.count = " + HanoiTowers.ops);
      }

   }
}
