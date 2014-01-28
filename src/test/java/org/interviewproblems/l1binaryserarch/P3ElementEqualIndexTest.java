package org.interviewproblems.l1binaryserarch;

import org.interviewproblems.l1binarysearch.P3ElementEqualIndex;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class P3ElementEqualIndexTest {

   P3ElementEqualIndex problem = new P3ElementEqualIndex();

   public void testFindElement() {
      int[] in = new int[]{1, 1, 3, 4, 5, 6, 7};
      assertEquals(1, problem.find(in));
      in = new int[]{0, 2, 3, 4, 5, 6, 7};
      assertEquals(0, problem.find(in));
      in = new int[]{1, 2, 3, 4, 4};
      assertEquals(4, problem.find(in));
      in = new int[]{1, 2, 3, 4, 5};
      assertEquals(-1, problem.find(in));
      in = new int[]{11, 22, 33, 44, 55};
      assertEquals(-1, problem.find(in));

   }

   public void testFindElement2() {
      int[] in = new int[]{1, 1, 3, 4, 5, 6, 7};
      assertEquals(1, problem.find2(in));
      in = new int[]{0, 2, 3, 4, 5, 6, 7};
      assertEquals(0, problem.find2(in));
      in = new int[]{1, 2, 3, 4, 4};
      assertEquals(4, problem.find2(in));
      in = new int[]{1, 2, 3, 4, 5};
      assertEquals(-1, problem.find2(in));
      in = new int[]{11, 22, 33, 44, 55};
      assertEquals(-1, problem.find2(in));
   }

   public void testFindElementStrictMonotonic() {
      int[] in = new int[]{-2, 1, 3, 4, 5, 6, 7};
      assertEquals(1, problem.findStrictMonotonic(in));
      in = new int[]{0, 2, 3, 4, 5, 6, 7};
      assertEquals(0, problem.findStrictMonotonic(in));
      in = new int[]{0, 1, 2, 3, 4};
      assertEquals(0, problem.findStrictMonotonic(in));
      in = new int[]{1, 2, 3, 4, 5};
      assertEquals(-1, problem.findStrictMonotonic(in));
      in = new int[]{11, 22, 33, 44, 55};
      assertEquals(-1, problem.findStrictMonotonic(in));
      in = new int[]{-1, 0, 1, 2, 3};
      assertEquals(-1, problem.findStrictMonotonic(in));
      in = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
      assertEquals(-1, problem.findStrictMonotonic(in));
   }

}
