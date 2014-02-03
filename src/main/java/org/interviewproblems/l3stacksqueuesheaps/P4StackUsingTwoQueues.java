package org.interviewproblems.l3stacksqueuesheaps;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Build a stack using two queues.
 */
public class P4StackUsingTwoQueues<T extends Comparable<T>> {


   Queue<T> first = new LinkedList<T>();
   Queue <T> second = new LinkedList<T>();

   public void push(T t) {
      first.add(t);
   }

   public T pop() {
      if (first.isEmpty())
         return null;
      while (true) {
         T t = first.remove();
         if (first.isEmpty()) {
            Queue<T> aux = first;
            first = second;
            second = aux;
            return t;
         } else {
            second.add(t);
         }
      }
   }
}
