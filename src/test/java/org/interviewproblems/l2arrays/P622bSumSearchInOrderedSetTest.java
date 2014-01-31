package org.interviewproblems.l2arrays;

import org.testng.annotations.Test;

import static org.testng.Assert.assertNull;
import static org.testng.AssertJUnit.assertEquals;

@Test
public class P622bSumSearchInOrderedSetTest {
   P622bSumSearchInOrderedSet problem = new P622bSumSearchInOrderedSet();

   public void basicTest() {
      float[] in = new float[]{0, 1, 2, 3, 4, 5, 6};
      for (int i = 1; i <= 11; i++) {
         int[] solution = problem.find(in, i);
         assertEquals(2, solution.length);
      }

      for (int i = 12; i < 100; i++) {
         assertNull(problem.find(in, i));
      }
      assertNull(problem.find(in, 0));
   }

   public void basicTest2() {
      double[] in = new double[]{0, 1, 2, 3, 4, 5, 6};
      for (int i = 1; i <= 11; i++) {
         int[] solution = problem.find2(in, i);
         assertEquals(2, solution.length);
      }

      for (int i = 12; i < 100; i++) {
         assertNull(problem.find2(in, i));
      }
      assertNull(problem.find2(in, 0));
   }
}
