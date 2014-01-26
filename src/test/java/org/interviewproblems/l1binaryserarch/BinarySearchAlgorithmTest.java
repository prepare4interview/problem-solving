package org.interviewproblems.l1binaryserarch;

import org.interviewproblems.l1binarysearch.BinarySearchAlgorithm;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class BinarySearchAlgorithmTest {

   BinarySearchAlgorithm algorithm = new BinarySearchAlgorithm();

   public void testBasicAlgorithm() {
      int[] array = new int[]{0, 1, 2, 3, 4, 5, 6};
      for (int i = 0; i < array.length; i++) {
         assertEquals(algorithm.binarySearch(array, i), i);
      }
   }

   public void testMissingNumber() {
      int[] array = new int[]{0, 1, 2, 3, 4, 5, 6};
      assertEquals(algorithm.binarySearch(array, -1), -1);
      assertEquals(algorithm.binarySearch(array, 8), -1);
   }

   public void testMissingInternalNumber() {
      int[] array = new int[]{0, 1, 2, 4, 5, 6};
      assertEquals(algorithm.binarySearch(array, 3), -1);
   }

   public void testMultipleOccurrences() {
      int[] array = new int[]{0, 1, 2, 3, 4, 4, 5, 6};
      assertEquals(algorithm.binarySearch(array, 4), 4);
   }

}
