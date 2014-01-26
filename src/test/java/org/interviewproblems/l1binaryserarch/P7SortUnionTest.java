package org.interviewproblems.l1binaryserarch;

import org.interviewproblems.l1binarysearch.P7SortUnion;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class P7SortUnionTest {
   P7SortUnion sortUnion = new P7SortUnion();

   public void testSortUnion() {
      int[] first = new int[]{1, 3, 5, 7, 9, 10, 11, 12, 13, 14, 15};
      int[] second = new int[]{0, 2, 4, 6, 8};

      for (int i = 0; i < 16; i++) {
         assertEquals(i, sortUnion.findK(first, second, i));
      }
   }

   public void testSortUnion2() {
      int[] first = new int[]{1, 3, 5, 7, 9, 10, 11, 12, 13, 14, 15};
      int[] second = new int[]{0, 2, 4, 6, 8};

      for (int i = 0; i < 16; i++) {
         assertEquals(i, sortUnion.findK(second, first, i));
      }
   }
}
