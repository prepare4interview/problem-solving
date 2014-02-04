package org.interviewproblems.l3stacksqueuesheaps;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@Test
public class P7KSmallestElementsTest {

   P7KSmallestElements problem = new P7KSmallestElements();

   public void basicTest() {
      int in[] = new int[]{9, 4, 2, 3, 1, 0, 8, 7, 5, 6};
      for (int i = 0; i < in.length; i++) {
         Set<Integer> expected = createSet(i);
         int[] elements = problem.smallest(in, i);
         assertEquals(expected.size(), elements.length);
         for (int e : elements)
            assertTrue(expected.contains(e));
      }
   }

   public void testScenario() {
      int[] in = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
      int[] smallest = problem.smallest(in, 2);
      assertTrue(Arrays.equals(smallest, new int[]{1, 2}));
      smallest = problem.smallest(in, 8);
      System.out.println("Arrays.toString(smallest) = " + Arrays.toString(smallest));
      Arrays.sort(smallest);
      assertTrue(Arrays.equals(smallest, new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
   }

   @Test (invocationCount = 100)
   public void testRandom() {
      Random r = new Random();
      int size = r.nextInt(20);
      int[] all = new int[size];
      for (int i = 0; i < size; i++) {
         all[i] = r.nextInt(2 * size);
      }

      int[] copy = Arrays.copyOf(all, all.length);
      Arrays.sort(copy);
      for (int i = 0; i < size; i++) {
         int[] smallest = problem.smallest(all, i);
         Arrays.sort(smallest);
         int[] subcopy = new int[i];
         System.arraycopy(copy, 0, subcopy, 0, i);
         assertTrue(Arrays.equals(smallest, subcopy));
      }
   }


   private Set<Integer> createSet(int count) {
      Set<Integer> result = new HashSet<Integer>();
      for (int i = 0; i < count; i++) {
         result.add(i);
      }
      return result;
   }

   public void dutchFlagSimpleTest() {
      int[] in = new int[]{14, 15, 9, 3, 4, 5, 6, 2, 9, 9, 1, 2};
      int[] result = problem.dutchFlag(in, 9);
      assertEquals(7, result[0]);
      assertEquals(10, result[1]);
   }
}
