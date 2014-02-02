package org.interviewproblems.l2arrays;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@Test
public class CustomHeapTest {

   CustomHeap<Integer> heap = new CustomHeap<Integer>();
   Random r = new Random();


   public void simpleTest() {
      heap = new CustomHeap<Integer>(Arrays.asList(1, 4, 2, 3, 0));
      assertEquals(5, heap.size());
      assertEquals(4, (int) heap.removeHead());
      assertEquals(4, heap.size());
      assertEquals(3, (int) heap.removeHead());
      assertEquals(3, heap.size());
      assertEquals(2, (int) heap.removeHead());
      assertEquals(2, heap.size());
      assertEquals(1, (int) heap.removeHead());
      assertEquals(1, heap.size());
      assertEquals(0, (int) heap.removeHead());
      assertEquals(0, heap.size());
      assertTrue(heap.isEmpty());
   }

   public void testConstructor() {
      Collection<Integer> initial = new ArrayList<Integer>();
      List<Integer> expected = new ArrayList<Integer>();
      int count = r.nextInt(3000);
      for (int i = 0; i < count; i++) {
         int e = r.nextInt();
         initial.add(e);
         expected.add(e);
      }
      heap = new CustomHeap<Integer>(initial);
      List<Integer> removed = new ArrayList<Integer>();
      while (!heap.isEmpty()) {
         removed.add(heap.removeHead());
      }
      Collections.sort(expected, Collections.reverseOrder());
      assertEquals(removed, expected);
   }

   public void testSimpleAdd() {
      heap = new CustomHeap<Integer>();
      assertEquals(0, heap.size());
      heap.add(0);
      assertEquals(1, heap.size());
      heap.add(1);
      assertEquals(2, heap.size());
      heap.add(2);
      assertEquals(3, heap.size());
      heap.add(3);
      assertEquals(4, heap.size());
      heap.add(4);
      assertEquals(5, heap.size());
      assertEquals(4, (int) heap.removeHead());
      assertEquals(4, heap.size());
      assertEquals(3, (int) heap.removeHead());
      assertEquals(3, heap.size());
      assertEquals(2, (int) heap.removeHead());
      assertEquals(2, heap.size());
      assertEquals(1, (int) heap.removeHead());
      assertEquals(1, heap.size());
      assertEquals(0, (int) heap.removeHead());
      assertEquals(0, heap.size());
      assertTrue(heap.isEmpty());
   }

   public void testSimpleAddResize() {
      for (int i = 0; i <= 10000; i++) {
         heap.add(i);
      }
      for (int i = 10000; i >= 0; i--) {
         assertEquals(i, (int) heap.removeHead());
      }
   }

   public void priorityQueueTest() {
      PriorityQueue pq = new PriorityQueue();
      pq.add(5);
      pq.add(4);
      pq.add(3);
      pq.add(2);
      pq.add(1);
      pq.add(0);
      while (!pq.isEmpty()) {
         System.out.println("pq.remove() = " + pq.remove());
      }
   }
}
