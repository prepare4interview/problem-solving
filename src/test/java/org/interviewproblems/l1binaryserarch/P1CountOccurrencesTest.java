package org.interviewproblems.l1binaryserarch;

import org.interviewproblems.l1binarysearch.P1CountOccurrences;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class P1CountOccurrencesTest {

   P1CountOccurrences countOccurrences = new P1CountOccurrences();

   public void testOneOccurrence() {
      int[] in = {0, 1, 2, 3, 4, 5, 6, 7};
      for (int i = 0; i < in.length; i++) {
         assertEquals(countOccurrences.countOccurrences(in, i), 1);
      }
   }

   public void testNoOccurrence() {
      int[] in = {0, 1, 2, 4, 5, 6, 7};
      assertEquals(0, countOccurrences.countOccurrences(in, -1));
      assertEquals(0, countOccurrences.countOccurrences(in, 8));
      assertEquals(0, countOccurrences.countOccurrences(in, 3));
   }

   public void testMultipleOccurrences() {
      int[] in = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5};
      for (int i = 0; i < 6; i++) {
         assertEquals(i, countOccurrences.countOccurrences(in, i));
      }
   }
}
