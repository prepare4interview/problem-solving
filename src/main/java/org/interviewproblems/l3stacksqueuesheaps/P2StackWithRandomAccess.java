package org.interviewproblems.l3stacksqueuesheaps;

import java.util.Random;

/**
 * Build a stack data structure that has push(), pop() and getRandomElement() which all take O(1) time.
 *
 * Q: get random element doesn't remove, but just returns an element. Or?
 */
public class P2StackWithRandomAccess<T extends Comparable<T>> {

   private static final int DEFAULT_SIZE = 8;
   private T[] stack;
   private int size;
   private final Random r = new Random();

   public P2StackWithRandomAccess() {
      stack = allocate(DEFAULT_SIZE);
   }

   void push(T t) {
      if (size == stack.length) {
         T[] newStack = allocate(stack.length * 2);
         for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
         }
         stack = newStack;
      }
      stack[size++] = t;
   }

   T pop() {
      if (size == 0) return null;
      return stack[--size];
   }

   T getRandomElement() {
      if (size == 0) return null;
      return stack[r.nextInt(size)];
   }

   @SuppressWarnings("unchecked")
   private T[] allocate(int defaultSize) {
      return (T[]) new Comparable[defaultSize];
   }
}
