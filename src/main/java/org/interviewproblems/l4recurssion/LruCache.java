package org.interviewproblems.l4recurssion;

import java.util.HashMap;
import java.util.Map;

public class LruCache {

   Node head;
   Node tail;
   final int capacity;

   Map<Integer, Node> cache = new HashMap<Integer, Node>();

   class Node {
      Node prev;
      Node next;
      int value;
      int key;
      //todo add equals & hashcode
   }

   public LruCache(int capacity) {
      this.capacity = capacity;
   }

   public int get(int key) {
      Node n = cache.get(key);
      if (n == null) return -1;
      enqueue(n);
      return n.value;
   }

   private void enqueue(Node n) {
      if (n != tail) {
         if (n.prev != null) {
            n.prev.next = n.next;
         } else {
            head = n.next;
         }
         if (n.next != null) {
            n.next.prev = n.prev;
         }
         n.prev = tail;
         n.prev.next = n;
         n.next = null;
         tail = n;
      }
   }

   public void set(int key, int value) {
      Node n = cache.get(key);
      if (n != null) {
         n.value = value;
         enqueue(n);
      } else {
         n = new Node();
         n.value = value;
         n.key = key;
         cache.put(key, n);
         if (head == null) {
            head = n;
            tail = n;
         } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
         }
      }
      if (cache.size() > capacity) {
         cache.remove(head.key);
         head = head.next;
         head.prev = null;
      }
   }

   public static void main(String[] args) {
      LruCache lruCache = new LruCache(3);
      lruCache.set(1,1);
      lruCache.set(2,2);
      lruCache.set(3,3);
      lruCache.set(4,4);
      assert 4 == lruCache.get(4);
      assert 3 == lruCache.get(3);
      assert 2 == lruCache.get(2);
      assert -1 == lruCache.get(1);
      lruCache.set(5,5);
      assert -1 == lruCache.get(1);
      assert 2 == lruCache.get(2);
      assert 3 == lruCache.get(3);
      assert -1 == lruCache.get(4);

      "43+2".matches("-|/|\\*|\\+");
   }
}
