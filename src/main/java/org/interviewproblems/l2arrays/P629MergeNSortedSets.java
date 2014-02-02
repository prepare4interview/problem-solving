package org.interviewproblems.l2arrays;

public class P629MergeNSortedSets {

   private class Set implements Comparable<Set> {
      int currentIndex = 0;
      final int[] elements;

      private Set(int[] elements) {
         this.elements = elements;
      }

      @Override
      public int compareTo(Set o) {
         return o.elements[o.currentIndex] - this.elements[currentIndex];
      }
   }

   public int[] sortMerge(int[]... in) {
      CustomHeap<Set> heap = new CustomHeap<Set>();
      int resultSize = 0;
      for (int[] e : in) { // O(d*log(d))
         heap.add(new Set(e));
         resultSize += e.length;
      }
      int[] result = new int[resultSize];
      int pos = 0;
      while (!heap.isEmpty()) { // O (n * log(d)) >> O (d*log(d))
         Set poll = heap.removeHead();
         result[pos++] = poll.elements[poll.currentIndex++];
         if (poll.currentIndex < poll.elements.length) {
            heap.add(poll);
         }
      }
      return result;
   }
}
