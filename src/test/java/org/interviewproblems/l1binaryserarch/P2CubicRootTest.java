package org.interviewproblems.l1binaryserarch;

import org.interviewproblems.l1binarysearch.P2CubicRoot;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@Test
public class P2CubicRootTest {
   P2CubicRoot p2CubicRoot = new P2CubicRoot();

   //cubeRoot(5) = 1.709975946676697
   public void basicTestGraterThanOne() {
      double pow = Math.pow(5d, (1d / 3d));
      System.out.println("Math.pow(5, 1/3) = " + pow);
      final float cubeRoot5 = 1.709975946676697f;
      assertLimits(cubeRoot5, p2CubicRoot.cubicRoot(5f, 1f), 1f);
      assertLimits(cubeRoot5, p2CubicRoot.cubicRoot(5f, 0.1f), 0.1f);
      assertLimits(cubeRoot5, p2CubicRoot.cubicRoot(5f, 0.01f), 0.01f);
      assertLimits(cubeRoot5, p2CubicRoot.cubicRoot(5f, 0.001f), 0.001f);
      assertLimits(cubeRoot5, p2CubicRoot.cubicRoot(5f, 0.0001f), 0.0001f);
      assertLimits(cubeRoot5, p2CubicRoot.cubicRoot(5f, 0.00001f), 0.00001f);
      assertLimits(cubeRoot5, p2CubicRoot.cubicRoot(5f, 0.000001f), 0.000001f);
   }

   public void basicTestSmallerThanMinusOne() {
      double pow = Math.pow(-5f, (1d / 3d));
      System.out.println("Math.pow(-5, 1/3) = " + pow);
      final float cubeRoot5 = -1.709975946676697f;
      assertLimits(cubeRoot5, p2CubicRoot.cubicRoot(-5f, 1f), 1f);
      assertLimits(cubeRoot5, p2CubicRoot.cubicRoot(-5f, 0.1f), 0.1f);
      assertLimits(cubeRoot5, p2CubicRoot.cubicRoot(-5f, 0.01f), 0.01f);
      assertLimits(cubeRoot5, p2CubicRoot.cubicRoot(-5f, 0.001f), 0.001f);
      assertLimits(cubeRoot5, p2CubicRoot.cubicRoot(-5f, 0.0001f), 0.0001f);
      assertLimits(cubeRoot5, p2CubicRoot.cubicRoot(-5f, 0.00001f), 0.00001f);
      assertLimits(cubeRoot5, p2CubicRoot.cubicRoot(-5f, 0.000001f), 0.000001f);
   }

   public void basicTestWithOne() {
      assertEquals(1f, p2CubicRoot.cubicRoot(1, 1f));
      assertEquals(1f, p2CubicRoot.cubicRoot(1, .1f));
      assertEquals(1f, p2CubicRoot.cubicRoot(1, .01f));
      assertEquals(1f, p2CubicRoot.cubicRoot(1, .001f));
      assertEquals(1f, p2CubicRoot.cubicRoot(1, .00001f));
   }

   //cubeRoot(0.9) = 0.9486832854847512
   public void testSmallerThanOne() {
      System.out.println("Math.pow(0.9, 1/3) = " + Math.pow(0.9, 1d / 3d));
      final float sqrtDot9 = 0.9654893846056297f;
      assertLimits(sqrtDot9, p2CubicRoot.cubicRoot(0.9f, 0.1f), 0.1f);
      assertLimits(sqrtDot9, p2CubicRoot.cubicRoot(0.9f, 0.01f), .01f);
      assertLimits(sqrtDot9, p2CubicRoot.cubicRoot(0.9f, 0.001f), .001f);
      assertLimits(sqrtDot9, p2CubicRoot.cubicRoot(0.9f, 0.0001f), .0001f);
      assertLimits(sqrtDot9, p2CubicRoot.cubicRoot(0.9f, 0.00001f), .00001f);
   }


   private void assertLimits(float sqrt5, float result, float epsilon) {
      System.out.printf("Expected result = %s, actual result = %s, epsilon = %s \n", sqrt5, result, epsilon);
      assertTrue(result < sqrt5 + epsilon);
      assertTrue(result > sqrt5 - epsilon);
   }
}
