package org.interviewproblems.l3stacksqueuesheaps;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import static org.testng.Assert.assertNull;
import static org.testng.AssertJUnit.assertEquals;

@Test
public class P1StackWithMinTest {

   P1StackWithMin<Integer> stack = new P1StackWithMin<Integer>();

   public void simpleStackTest() {
      for (int i = 100 ; i >= 0; i--) {
         stack.push(i);
         assertEquals(i, (int)stack.min());
      }

      for (int i = 0; i <= 100; i++) {
         assertEquals(i, (int)stack.pop());
      }

      for (int i = 0; i <= 100; i++) {
         assertNull(stack.pop());
      }
   }

   @Test (invocationCount = 10)
   public void randomTest() {
      Random r = new Random();
      int size = r.nextInt(r.nextInt(10000));

      LinkedList<Integer> comparison = new LinkedList<Integer>();
      for  (int i = 0; i < size; i++) {
         int val = r.nextInt(10000);
         stack.push(val);
         comparison.push(val);
      }

      while (!comparison.isEmpty()) {
         int min = Collections.min(comparison);
         assertEquals(min, (int)stack.min());
         assertEquals(comparison.poll(), stack.pop());
      }
   }

}
