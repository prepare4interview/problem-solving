package org.interviewproblems.l1binaryserarch;

import org.interviewproblems.l1binarysearch.P4Log2;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertTrue;

@Test
public class P4Log2Test {

   P4Log2 problem = new P4Log2();

   public void testNumbers() {
      for (int i = 7; i < 100; i++) {
         float expected = logBase2(i);
         float actual = problem.logBase2(i);
         assertTrue((expected - actual) < 1e-5);
      }
   }

   private float logBase2(float nr) {
      return (float) (Math.log10(nr) / Math.log10(2f));
   }


}
