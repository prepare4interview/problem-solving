package org.interviewproblems.l3stacksqueuesheaps;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

@Test
public class P4StackUsingTwoQueuesTest {

   P4StackUsingTwoQueues<Integer> problem = new P4StackUsingTwoQueues<Integer>();

   public void simpleTest() {

      for (int i = 0; i <= 100; i++) {
         problem.push(i);
      }

      for (int i = 100; i > 50; i--) {
         assertEquals(i, (int) problem.pop());
      }

      for (int i = 100; i <= 150; i++) {
         problem.push(i);
      }

      for (int i = 150; i >= 100; i--) {
         assertEquals(i, (int) problem.pop());
      }

      for (int i = 50; i >= 0; i--) {
         assertEquals(i, (int) problem.pop());
      }

      for (int i = 0; i <= 10; i++) {
         assertNull(problem.pop());
      }
   }

}
