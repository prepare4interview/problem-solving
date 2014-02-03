package org.interviewproblems.l3stacksqueuesheaps;

import org.testng.annotations.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertTrue;

@Test
public class P5FindMinSubsequenceTest {

   P5FindMinSubsequence problem = new P5FindMinSubsequence();

   public void simpleTest() {
      int[] in = new int[]{1, 2, 3, 1, 4, 0, 6, -1, 4, 2, -2, -3, 3, 4, 5, 6, 7};
      int[] result = problem.minSequence(in, 5);
      int[] expected = new int[]{1, 0, 0, -1, -1, -1, -2, -3, -3, -3, -3, -3, 3};
      System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
      System.out.println("               expected = " + Arrays.toString(expected));
      assertTrue(Arrays.equals(result, expected));
   }

   public void simpleTest2() {
      int[] in = new int[]{1, 2, 3, 1, 4, 0, 6, -1, 4, 2, -2, -3, 3, 4, 5, 6, 7};
      int[] result = problem.minSequenceBetter(in, 5);
      int[] expected = new int[]{1, 0, 0, -1, -1, -1, -2, -3, -3, -3, -3, -3, 3};
      System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
      System.out.println("               expected = " + Arrays.toString(expected));
      assertTrue(Arrays.equals(result, expected));
   }
}
