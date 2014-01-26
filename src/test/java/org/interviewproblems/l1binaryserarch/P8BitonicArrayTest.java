package org.interviewproblems.l1binaryserarch;

import org.interviewproblems.l1binarysearch.P8BitonicArray;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

@Test
public class P8BitonicArrayTest {
   P8BitonicArray p8 = new P8BitonicArray();

   public void testBitonicArray() {
      int[] in = new int[]{0, 2, 4, 6, 5, 3, 1};
      assertAllFound(in);

      in = new int[]{0, 1, 2, 3, 4, 5, 6};
      assertAllFound(in);

      in = new int[]{6, 5, 4, 3, 2, 1, 0};
      assertAllFound(in);

      in = new int[]{1, 5, 4, 3, 2, 0};
      assertAllFound(in);

      in = new int[]{1, 2, 3, 4, 5, 0};
      assertAllFound(in);
   }

   private void assertAllFound(int[] in) {
      for (int i = 0; i < in.length; i++) {
         assertTrue("For " + i, p8.searchBitonicArray(in, i));
      }
      for (int i = in.length; i < in.length * 2; i++) {
         assertFalse(p8.searchBitonicArray(in, i));
      }
   }

}
