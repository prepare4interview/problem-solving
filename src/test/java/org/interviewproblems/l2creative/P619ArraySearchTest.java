package org.interviewproblems.l2creative;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class P619ArraySearchTest {

   P619ArraySearch arraySearch = new P619ArraySearch();

   public void testSimple() {
      int[] in = new int[]{0, 1, 2, 3, 4, 5, 6, 7};

      for (int i = 0; i < in.length; i++) {
         assertEquals(i, arraySearch.find(in, i));
      }
   }

   public void testVariations() {
      int[] in = new int[]{0, -1, -2, -1, 0, 1, 2, 1, 1, 0, 1, 2, 3};
      assertEquals(0, arraySearch.find(in, 0));
      assertEquals(5, arraySearch.find(in, 1));
      assertEquals(6, arraySearch.find(in, 2));
      assertEquals(12, arraySearch.find(in, 3));
   }

}
