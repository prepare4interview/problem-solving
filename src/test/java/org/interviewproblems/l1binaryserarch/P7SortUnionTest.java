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

   public void testSortLogNSquareComplex() {
      int[] first = new int[]{1, 3, 5, 7, 9, 10, 11, 12, 13, 14, 15};
      int[] second = new int[]{0, 2, 4, 6, 8};

      assertEquals(9, sortUnion.findKLogNSquare(second, first, 9));

      for (int i = 0; i < 16; i++) {
         assertEquals(i, sortUnion.findKLogNSquare(first, second, i));
         assertEquals(i, sortUnion.findKLogNSquare(second, first, i));
      }
   }


   public void testSortLogNSquare() {
      int[] first = new int[]{1, 3, 5, 7, 9};
      int[] second = new int[]{0, 2, 4, 6, 8};
      assertEquals(4, sortUnion.findKLogNSquare(second, first, 4));
      assertEquals(4, sortUnion.findKLogNSquare(first, second, 4));
   }

   public void testSortLogNSquareSameNumbers() {
      int[] first = new int[]{1, 1, 1, 1, 1};
      int[] second = new int[]{0, 0, 0, 0, 0};
      assertEquals(0, sortUnion.findKLogNSquare(second, first, 4));
      assertEquals(0, sortUnion.findKLogNSquare(first, second, 4));
   }

   public void testSortLogNSquareSameArray() {
      int[] first = new int[]{0, 1, 2, 3, 4};
      int[] second = new int[]{0, 1, 2, 3, 4};
      assertEquals(2, sortUnion.findKLogNSquare(second, first, 4));
      assertEquals(2, sortUnion.findKLogNSquare(first, second, 4));
   }

   public void testSortLogNSquareDisjunct() {
      int[] first = new int[]{5, 6, 7, 8, 9};
      int[] second = new int[]{0, 1, 2, 3, 4};
      assertEquals(4, sortUnion.findKLogNSquare(first, second, 4));
      assertEquals(4, sortUnion.findKLogNSquare(second, first, 4));
   }

   public void testPosition() {
      int[] b = new int[]{1, 3, 5, 7, 9};
      assertEquals(0, sortUnion.position(b, 0, b.length));
      assertEquals(1, sortUnion.position(b, 2, b.length));
      assertEquals(2, sortUnion.position(b, 4, b.length));
      assertEquals(3, sortUnion.position(b, 6, b.length));
      assertEquals(4, sortUnion.position(b, 8, b.length));

      assertEquals(1, sortUnion.position(b, 1, b.length));
      assertEquals(5, sortUnion.position(b, 9, b.length));
   }
}
