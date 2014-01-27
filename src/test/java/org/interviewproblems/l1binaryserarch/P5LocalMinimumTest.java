package org.interviewproblems.l1binaryserarch;

import org.interviewproblems.l1binarysearch.P5LocalMinimum;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@Test //Given an array A such that A[0] > A[1] and A[n-1] > A[n-2] find out
// a local minimum (find out an i such that A[i-1] > A[i] < A[i + 1]).
public class P5LocalMinimumTest {

   P5LocalMinimum problem = new P5LocalMinimum();

   public void testLocalMinimum() {
      int[] in = new int[]{2, 1, 3, 5, 2, 8, 9, 10, 11, 4, 5};
      assertEquals(1, problem.localMinimum(in));
      in = new int[]{2, 1, 3};
      assertEquals(1, problem.localMinimum(in));
      in = new int[]{2, 1, 0, -1, -7, 9};
      assertEquals(4, problem.localMinimum(in));
      in = new int[]{2, 1, 0, 0, 0, 9};
      assertEquals(-1, problem.localMinimum(in));
   }

   public void testLocalMinimum2() {
      int[] in = new int[]{2, 1, 3, 5, 2, 8, 9, 10, 11, 4, 5};
      assertEquals(1, problem.localMinimum2(in));
      System.out.println("problem = " + problem.complexity);
      in = new int[]{2, 1, 3};
      assertEquals(1, problem.localMinimum2(in));
      in = new int[]{2, 1, 0, -1, -7, 9};
      assertEquals(4, problem.localMinimum2(in));
      in = new int[]{2, 1, 0, 0, 0, 9};
      assertEquals(-1, problem.localMinimum2(in));
   }

   public void testLocalMinimum2Complexity() {
      float avgComplexity = 0;
      int maxComplexity = Integer.MIN_VALUE;
      Random r = new Random();
      for (int i = 0; i < 1000; i++) {
         int[] in = new int[128];
         for (int j = 1; j < in.length; j++) {
            in[j] = r.nextInt();
         }
         in[0] = in[1] + 1;
         in[127] = in[126] + 1;
         int res1 = problem.localMinimum2(in);
         int res2 = problem.localMinimum(in);
         if (res2 > 0) {
            assertTrue(res1 > 0);
            assertTrue(in[res1] < in[res1 + 1]);
            assertTrue(in[res1] < in[res1 - 1]);
         }
         avgComplexity += problem.complexity;
         maxComplexity = Math.max(maxComplexity, problem.complexity);
         problem.complexity = 0;
      }
      avgComplexity /= 1000;
      System.out.println("avgComplexity = " + avgComplexity);
      System.out.println("maxComplexity = " + maxComplexity);
   }

   public void testLocalMinimum2MaxComplexity() {
      int[] in = new int[128];
      for (int j = 1; j < in.length; j++) {
         in[j] = 1;
      }
      in[0] = in[1] + 1;
      in[127] = in[126] + 1;
      int res1 = problem.localMinimum2(in);
      int res2 = problem.localMinimum(in);

      assertEquals(res1, res2);
      assertEquals(-1, res2);

      System.out.println("maxComplexity = " + problem.complexity);
   }

   public void testLocalMinimum2MaxEdge() {
      int[] in = new int[128];
      for (int j = 1; j < in.length; j++) {
         in[j] = 1;
      }
      in[0] = in[1] + 1;
      in[127] = in[126] + 1;
      in[123] = 0;
      int res1 = problem.localMinimum2(in);
      int res2 = problem.localMinimum(in);

      assertEquals(res1, res2);
      assertEquals(123, res2);

      System.out.println("maxComplexity = " + problem.complexity);
   }
}
