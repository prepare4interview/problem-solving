package org.interviewproblems.l2arrays;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static junit.framework.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

@Test
public class P625ReunionOfTwoSetsTest {

   P625ReunionOfTwoSets problem = new P625ReunionOfTwoSets();

   public void basicTest() {
      int[] a = new int[]{1, 3, 2, 5, 4, 7, 0, 6};
      int[] b = new int[]{1, 8, 3, 9, 2, 11, 5, 10};
      int[] reunion = problem.reunion(a, b);
      Arrays.sort(reunion);
      System.out.println("Arrays.toString(reunion) = " + Arrays.toString(reunion));
      assertTrue(Arrays.equals(reunion, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}));
   }

   @Test(invocationCount = 2000)
   public void aggressiveRandomTest() {
      Random r = new Random();
      int[] a = new int[r.nextInt(r.nextInt(100) + 1)];
      int[] b = new int[r.nextInt(r.nextInt(100) + 1)];

      Set<Integer> sA = populate(r, a);
      Set<Integer> sB = populate(r, b);

      sA.addAll(sB);

      int [] reunion = problem.reunion(a, b);
      assertEquals(reunion.length, sA.size());
      for (int i : reunion) {
         assert sA.contains(i);
      }
   }

   private Set<Integer> populate(Random r, int[] a) {
      Set<Integer> s = new HashSet<Integer>();
      while (s.size() < a.length) {
         s.add(r.nextInt(200));
      }
      int aIt = 0;
      for (Integer i : s) {
         a[aIt++] = i;
      }
      return s;
   }
}
