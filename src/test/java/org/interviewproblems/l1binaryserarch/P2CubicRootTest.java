package org.interviewproblems.l1binaryserarch;

import org.interviewproblems.l1binarysearch.P2CubicRoot;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@Test
public class P2CubicRootTest {
   P2CubicRoot p2CubicRoot = new P2CubicRoot();

   //sqrt(5) = 2.236067977
   public void basicTestGraterThanOne() {
      final float sqrt5 = 2.236068f;
      assertLimits(sqrt5, p2CubicRoot.sqrt(5f, 1f), 1f);
      assertLimits(sqrt5, p2CubicRoot.sqrt(5f, 0.1f), 0.1f);
      assertLimits(sqrt5, p2CubicRoot.sqrt(5f, 0.01f), 0.01f);
      assertLimits(sqrt5, p2CubicRoot.sqrt(5f, 0.001f), 0.001f);
      assertLimits(sqrt5, p2CubicRoot.sqrt(5f, 0.0001f), 0.0001f);
      assertLimits(sqrt5, p2CubicRoot.sqrt(5f, 0.00001f), 0.00001f);
      assertLimits(sqrt5, p2CubicRoot.sqrt(5f, 0.000001f), 0.000001f);
   }

   public void basicTestWithOne() {
      assertEquals(1f, p2CubicRoot.sqrt(1, 1f));
      assertEquals(1f, p2CubicRoot.sqrt(1, .1f));
      assertEquals(1f, p2CubicRoot.sqrt(1, .01f));
      assertEquals(1f, p2CubicRoot.sqrt(1, .001f));
      assertEquals(1f, p2CubicRoot.sqrt(1, .00001f));
   }

   //sqrt(0.9) = 0.9486832854847512
   public void testSmallerThanOne() {
      final float sqrtDot9 = 0.9486832854847512f;
      assertLimits(sqrtDot9, p2CubicRoot.sqrt(0.9f, 0.1f), 0.1f);
      assertLimits(sqrtDot9, p2CubicRoot.sqrt(0.9f, 0.01f), .01f);
      assertLimits(sqrtDot9, p2CubicRoot.sqrt(0.9f, 0.001f), .001f);
      assertLimits(sqrtDot9, p2CubicRoot.sqrt(0.9f, 0.0001f), .0001f);
      assertLimits(sqrtDot9, p2CubicRoot.sqrt(0.9f, 0.00001f), .00001f);
   }


   private void assertLimits(float sqrt5, float result, float epsilon) {
      System.out.printf("Expected result = %s, actual result = %s \n", sqrt5, result);
      assertTrue(result < sqrt5 + epsilon);
      assertTrue(result > sqrt5 - epsilon);
   }
}
