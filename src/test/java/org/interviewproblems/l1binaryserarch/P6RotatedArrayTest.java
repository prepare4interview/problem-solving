package org.interviewproblems.l1binaryserarch;

import org.interviewproblems.l1binarysearch.P6RotatedArray;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class P6RotatedArrayTest {

   P6RotatedArray rotatedArray = new P6RotatedArray();

   public void testRotatedArray() {
      int[] array = new int[]{5, 0, 1, 2, 3, 4};
      assertEquals(1, rotatedArray.calculateRotation(array));
      array = new int[]{4, 5, 0, 1, 2, 3};
      assertEquals(2, rotatedArray.calculateRotation(array));
      array = new int[]{3, 4, 0, 1, 2, 3, 3};
      assertEquals(2, rotatedArray.calculateRotation(array));
      array = new int[]{3, 3, 3, 4, 4, 0, 1, 2, 3, 3};
      assertEquals(5, rotatedArray.calculateRotation(array));
      array = new int[]{2, 3};
      assertEquals(0, rotatedArray.calculateRotation(array));
      array = new int[]{2, 3, 3};
      assertEquals(0, rotatedArray.calculateRotation(array));
      array = new int[]{3, 2, 3, 3};
      assertEquals(1, rotatedArray.calculateRotation(array));
   }
}
