package org.interviewproblems.l2creative;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

@Test
public class P623SumBetweenTwoArraysTest {

   P623SumBetweenTwoArrays problem = new P623SumBetweenTwoArrays();

   public void basicTest() {

      for (int i = 5; i < 18; i++) {
         double[] first = new double[]{0, 6, 2, 4, 3, 5, 1};
         double[] second = new double[]{12, 6, 11, 10, 9, 8, 7, 5};
         int[] result = problem.search(first, second, i);
         assertEquals((double)i, first[result[0]] + second[result[1]]);
      }

      for (int i = 0; i < 5; i++) {
         double[] first = new double[]{0, 6, 2, 4, 3, 5, 1};
         double[] second = new double[]{12, 6, 11, 10, 9, 8, 7, 5};
         assertNull(problem.search(first, second, i));
      }

      for (int i = 19; i < 100; i++) {
         double[] first = new double[]{0, 6, 2, 4, 3, 5, 1};
         double[] second = new double[]{12, 6, 11, 10, 9, 8, 7, 5};
         assertNull(problem.search(first, second, i));
      }
   }

   public void testMergeSort() {
      double[] first = new double[]{0, 6, 2, 4, 3, 5, 1};
      problem.mergeSort(first);
      assertTrue(Arrays.equals(first, new double[]{0, 1, 2, 3, 4, 5, 6}));

      double[] second = new double[]{12, 6, 11, 10, 9, 8, 7, 5};
      problem.mergeSort(second);
      assertTrue(Arrays.equals(second, new double[]{5, 6, 7, 8, 9, 10, 11, 12}));

      double[] third = new double[]{2, 1};
      problem.mergeSort(third);
      assertTrue(Arrays.equals(third, new double[]{1, 2}));

      double[] forth = new double[]{1};
      problem.mergeSort(forth);
      assertTrue(Arrays.equals(forth, new double[]{1}));

      double[] fifth = new double[]{};
      problem.mergeSort(fifth);
      assertTrue(Arrays.equals(fifth, new double[]{}));

      Random r = new Random();
      for (int i = 0; i < 1000; i++) {
         int size = r.nextInt(1000);
         double[] test = new double[size];
         for (int j = 0; j < test.length; j++) {
            test[j] = r.nextDouble();
         }

         double[] jdkSort = Arrays.copyOf(test, test.length);
         Arrays.sort(jdkSort);
         problem.mergeSort(test);
         assertTrue(Arrays.equals(jdkSort, test));
      }
   }
}
