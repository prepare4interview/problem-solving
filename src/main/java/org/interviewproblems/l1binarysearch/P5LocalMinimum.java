package org.interviewproblems.l1binarysearch;

//Given an array A such that A[0] > A[1] and A[n-1] > A[n-2] find out a
// local minimum (find out an i such that A[i-1] > A[i] < A[i + 1]).
public class P5LocalMinimum {

   public int localMinimum(int[] in) {
      for (int i = 1; i < in.length - 1; i++) {
         if (in[i-1] > in[i] && in[i] < in[i+1]) return i;
      }
      return -1;
   }
}
