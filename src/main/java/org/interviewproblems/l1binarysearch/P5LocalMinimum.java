package org.interviewproblems.l1binarysearch;

/**
 * Given an array A such that A[0] > A[1] and A[n-1] > A[n-2] find out a local minimum (find out an i such that A[i-1] >
 * A[i] < A[i + 1]).
 */
public class P5LocalMinimum {

   public int complexity = 0;

   public int localMinimum(int[] in) {
      for (int i = 1; i < in.length - 1; i++) {
         if (in[i - 1] > in[i] && in[i] < in[i + 1]) return i;
      }
      return -1;
   }


   /**
    * Try to do it in logN.
    */
   public int localMinimum2(int[] in, int start, int end) {
      if (end - start > 1) {
         complexity++;
         int mid = start + (end - start) / 2;

         if ((in[mid - 1]  > in[mid])) {
            if (in[mid] < in[mid + 1]) { // \mid/
               return mid;
            }
            //chances are we're going to find it to the right \mid\\
            int rightResult = localMinimum2(in, mid, end);
            if (rightResult > 0)
               return rightResult;
            return localMinimum2(in, start, mid);
         } else { // //mid
            if (in[mid] > in[mid+1]) { // //mid\
               //chances are we're going to find it to the right \mid\
               int rightResult = localMinimum2(in, mid, end);
               if (rightResult > 0)
                  return rightResult;
               return localMinimum2(in, start, mid);
            } else {
               int pos = localMinimum2(in, start, mid);//mid//
               if (pos > -1) return pos;
               return localMinimum2(in, mid, end);
            }
         }
      }
      return -1;
   }

   public int localMinimum2(int[] in) {
      return localMinimum2(in, 0, in.length - 1);
   }
}
