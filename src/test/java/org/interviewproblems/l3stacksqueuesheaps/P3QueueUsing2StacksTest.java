package org.interviewproblems.l3stacksqueuesheaps;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class P3QueueUsing2StacksTest {

   P3QueueUsing2Stacks<Integer> problem = new P3QueueUsing2Stacks<Integer>();


   public void simpleTest() {
      problem.enqueue(1);
      problem.enqueue(2);
      problem.enqueue(3);

      assertEquals(1, (int) problem.dequeue());

      problem.enqueue(4);
      problem.enqueue(5);
      problem.enqueue(6);
      problem.enqueue(7);

      assertEquals(2, (int) problem.dequeue());
      assertEquals(3, (int) problem.dequeue());
      assertEquals(4, (int) problem.dequeue());
      assertEquals(5, (int) problem.dequeue());
      assertEquals(6, (int)problem.dequeue());
   }
}
