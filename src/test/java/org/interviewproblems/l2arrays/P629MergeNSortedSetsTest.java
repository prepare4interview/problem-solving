package org.interviewproblems.l2arrays;

import org.testng.annotations.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertTrue;

@Test
public class P629MergeNSortedSetsTest {
   P629MergeNSortedSets problem = new P629MergeNSortedSets();

   public void basicTest() {
      int[] s1 = new int[]{0, 5, 10, 15, 20};
      int[] s2 = new int[]{1, 6, 11, 16, 21, 26};
      int[] s3 = new int[]{2, 7, 12, 17, 22, 27, 32};
      int[] s4 = new int[]{3, 8, 13, 18, 23, 28, 33, 38};
      int[] s5 = new int[]{4, 9, 14, 19, 24, 29, 34, 39, 44};

      int[] result = problem.sortMerge(s1, s2, s3, s4, s5);
      assertTrue(Arrays.equals(result, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                                                 20, 21, 22, 23, 24, 26, 27, 28, 29, 32, 33, 34, 38, 39, 44}));
   }
}
