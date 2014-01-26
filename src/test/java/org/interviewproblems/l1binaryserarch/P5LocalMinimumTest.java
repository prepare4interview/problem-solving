package org.interviewproblems.l1binaryserarch;

import org.interviewproblems.l1binarysearch.P5LocalMinimum;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Test //Given an array A such that A[0] > A[1] and A[n-1] > A[n-2] find out
// a local minimum (find out an i such that A[i-1] > A[i] < A[i + 1]).
public class P5LocalMinimumTest {

   P5LocalMinimum problem = new P5LocalMinimum();

   public void testLocalMinimum() {
      int[] in = new int[]{2, 1, 3, 5, 2, 8, 9, 10, 11, 5, 4};
      assertEquals(1, problem.localMinimum(in));
      in = new int[]{2, 1, 3};
      assertEquals(1, problem.localMinimum(in));
      in = new int[]{2, 1, 0, -1, -7, 9};
      assertEquals(4, problem.localMinimum(in));
      in = new int[]{2, 1, 0, 0, 0, 9};
      assertEquals(-1, problem.localMinimum(in));
   }
}
