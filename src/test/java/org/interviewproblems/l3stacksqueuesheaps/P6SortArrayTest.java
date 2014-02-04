package org.interviewproblems.l3stacksqueuesheaps;

import org.testng.annotations.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertTrue;

@Test
public class P6SortArrayTest {

   P6SortArray problem = new P6SortArray();

   public void testBasic() {

//      int in[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      int in[] = new int[]  {3, 2, 1, 0, 5, 6, 4, 9, 8, 7, 10};

      int k = 3;
      //make sure the in is correct
      for (int i = 0; i < in.length; i++) {
         assertTrue(Math.abs(in[i] - i) <= k);
      }

      problem.sort(in, k);
//      System.out.println("Arrays.toString(in) = " + Arrays.toString(in));
      assertTrue(Arrays.equals(in, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
   }
}
