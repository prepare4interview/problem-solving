package org.interviewproblems.l4recurssion;

public class MedianOfTwoNumbers {

   public double findMedianSortedArrays(int A[], int B[]) {
      if (A.length == 0) {
         return median(B);
      } else if (B.length == 0) {
         return median(A);
      }
      return _find(A, 0, A.length - 1, B, 0, B.length - 1);
   }

   private double median(int[] B) {
      if (B.length %2 == 0) {
         int mid = B.length / 2;
         return ((double) (B[mid] + B[mid - 1]))/2;
      }
      return B[B.length / 2];
   }

   private double _find(int[] a, int loa, int hia, int[] b, int lob, int hib) {

      if (hia - loa <= 3) {
         return result(a, loa, hia, b, lob, hib);
      } else if (hib - lob <= 3) {
         return result(b, lob, hib, a, loa, hia);
      }

      int mida = (loa + hia + 1) / 2;
      int midb = (lob + hib + 1) / 2;

      if (a[mida] <= b[midb]) {
         int toRemove = Math.min(mida - loa, hib-midb);
         return _find(a, loa + toRemove, hia, b, lob, hib - toRemove);
      } else {
         int toRemove = Math.min(hia - mida, midb - lob);
         return _find(a, loa, hia-toRemove, b, lob + toRemove, hib);
      }
   }


   double result(int[] a, int loa, int hia, int[] b, int lob, int hib) {
      if (hia - loa > 3) throw new IllegalStateException();
      int count = hia - loa + 1 + hib - lob + 1;

      int[] aIndexInB = new int[hia - loa + 1];
      for (int i = loa; i <= hia; i++) {
         aIndexInB[i - loa] = indexOf(a[i], b, lob, hib);
      }

      if (count % 2 == 1) {
         int expectedIndex = count / 2;
         return findElement(expectedIndex, aIndexInB, a, loa, hia, b, lob, hib);
      } else {
         int expectedIndex1 = count / 2;
         int e1 = findElement(expectedIndex1, aIndexInB, a, loa, hia, b, lob, hib);
         int expectedIndex2 = count / 2 - 1;
         int e2 = findElement(expectedIndex2, aIndexInB, a, loa, hia, b, lob, hib);
         return ((double)(e1 + e2)) / 2;
      }
   }

   int findElement(int expectedIndex, int[] aIndexInB, int[] a, int loa, int hia, int[] b, int lob, int hib) {
      int insertionsBefore = 0;
      for (int i = 0; i < aIndexInB.length; i++) {
         if (aIndexInB[i] + insertionsBefore == expectedIndex)
            return a[loa + i];
         if (aIndexInB[i] + insertionsBefore < expectedIndex)
            insertionsBefore++;
      }
      return b[lob + expectedIndex - insertionsBefore];
   }

   int indexOf(int e, int[] b, int lo, int hi) {
      int l = lo - 1, h = hi + 1;
      //invariant b[h] >= e > b[l];
      while (h - l > 1) {

         int mid = l + (h - l) / 2;
         if (e <= b[mid]) {
            h = mid;
         } else {
            l = mid;
         }
      }
      return h - lo;
   }

}
