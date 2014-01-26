package org.interviewproblems.l1binarysearch;

//Given two sorted arrays of length n and m, find out the kth element of their sorted union
public class P7SortUnion {

   public int findK(int[] first, int[] second, int k) {
      assert first.length + second.length > k;

      int current = -1;
      int indexFirst = 0, indexSecond = 0;
      while (k >= 0) {
         if (indexFirst < first.length) {
            if (indexSecond < second.length) {
               if (first[indexFirst] <= second[indexSecond]) {
                  current = first[indexFirst++];
               } else {
                  current = second[indexSecond++];
               }
            } else {
               current = first[indexFirst++];
            }
         } else {
            current = second[indexSecond++];
         }
         k--;
      }
      return current;
   }
}
