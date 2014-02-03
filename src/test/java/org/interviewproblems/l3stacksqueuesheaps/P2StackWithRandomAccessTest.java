package org.interviewproblems.l3stacksqueuesheaps;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@Test
public class P2StackWithRandomAccessTest {

   P2StackWithRandomAccess<Integer> problem = new P2StackWithRandomAccess<Integer>();

   public void simpleTest() {

      for (int i = 0; i < 100; i++) {
         problem.push(i);
      }

      int sampleSize = 100000;
      int sum = 0;
      for (int i = 0; i < sampleSize; i++) {
         Integer randomElement = problem.getRandomElement();
         sum += randomElement;
      }
      //average is 49.5
      int average = sum / sampleSize;
      System.out.println("average = " + average);
      assertTrue(average > 45);
      assertTrue(average < 53);

      for (int i = 99; i >= 0; i--) {
         assertEquals(i, (int) problem.pop());
      }
   }

}
