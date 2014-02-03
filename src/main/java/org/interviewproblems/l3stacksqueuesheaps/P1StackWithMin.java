package org.interviewproblems.l3stacksqueuesheaps;

/**
 * Build a stack data structure that has push(), pop(), and min() which all take O(1) time.
 */
public class P1StackWithMin<T extends Comparable<T>> {

   Node<T> head;

   class Node<T extends Comparable<T>> {
      final T value;
      final Node<T> next;
      final T min;

      Node(T value, Node<T> next) {
         this.value = value;
         this.next = next;
         if (next == null || next.min == null) {
            min = value;
         } else {
            min = next.min.compareTo(value) < 0 ? next.min : value;
         }
      }
   }

   public void push(T t) {
      head = new Node<T>(t, head);
   }

   public T pop() {
      if (head == null) {
         return null;
      }
      T result = head.value;
      head = head.next;
      return result;
   }

   public T min() {
      return head == null ? null : head.min;
   }
}
