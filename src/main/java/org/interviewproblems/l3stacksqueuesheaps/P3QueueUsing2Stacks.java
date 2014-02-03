package org.interviewproblems.l3stacksqueuesheaps;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Build a queue using two stacks.
 */
public class P3QueueUsing2Stacks<T extends Comparable<T>> {
   Deque<T> addingStack = new LinkedList<T>();
   Deque<T> removingStack = new LinkedList<T>();

   public void enqueue(T e) {
      addingStack.push(e);
   }

   public T dequeue() {
      if (removingStack.isEmpty()) {
         while (!addingStack.isEmpty()) {
            T pop = addingStack.pop();
            removingStack.push(pop);
         }
      }
      if (removingStack.isEmpty()) return null;
      return removingStack.pop();
   }

}
