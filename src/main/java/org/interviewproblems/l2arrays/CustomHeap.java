package org.interviewproblems.l2arrays;

import java.util.Collection;

public class CustomHeap<T extends Comparable<T>> {

   private static final int INITIAL_SIZE = 8;
   private T[] elements;
   private int size;

   public CustomHeap(Collection<T> initial) {
      elements = allocate(initial.size());
      size = 0;
      for (T t : initial) {
         elements[size++] = t;
      }

      for (int i = parent(size()-1); i >= 0; i--) { //start from height() - 1
         heapify(i);
      }
   }

   private int parent(int index) {
      return (int)Math.floor(((double) index - 1) / 2);
   }

   public CustomHeap() {
      elements = allocate(INITIAL_SIZE);
   }

   private void heapify(int index) {
      if (isLeaf(index)) return;
      T max = elements[index];
      int maxIndex = index;
      int leftIndex = index * 2 + 1;
      int rightIndex = index * 2 + 2;

      if (elements[leftIndex] != null && elements[leftIndex].compareTo(max) > 0) {
         maxIndex = leftIndex;
         max = elements[leftIndex];
      }

      if (elements[rightIndex] != null && elements[rightIndex].compareTo(max) > 0) {
         maxIndex = rightIndex;
      }

      if (maxIndex != index) {
         swap(maxIndex, index);
         heapify(maxIndex);
      }
   }

   private boolean isLeaf(int index) {
      return (2 * index + 1) > size;
   }

   public int size() {
      return size;
   }

   public boolean isEmpty() {
      return size == 0;
   }

   public T removeHead() {
      if (size == 0)
         throw new RuntimeException("Not allowed to remove from an empty heap!");
      T result = elements[0];
      elements[0] = elements[--size];
      elements[size] = null;
      heapify(0);
      return result;
   }

   @SuppressWarnings("unchecked")
   private T[] allocate(int size) {
      int pow2size = INITIAL_SIZE;
      while (pow2size < size) {
         pow2size <<= 1;
      }
      Object[] objects = new Comparable[pow2size];
      return (T[]) objects;
   }

   private void swap(int maxIndex, int index) {
      T aux = elements[maxIndex];
      elements[maxIndex] = elements[index];
      elements[index] = aux;
   }

   public void add(T t) {
      if (size == elements.length - 1) {
         resize();
         add(t);
         return;
      }
      elements[size++] = t;
      int parent;
      int current = size - 1;
      while ((parent = parent(current)) >= 0) {
         if (elements[parent].compareTo(elements[current]) < 0) {
            swap(parent, current);
            current = parent;
         } else {
            break;
         }
      }
   }

   private void resize() {
      T[] newElements = allocate(elements.length * 2);
      for (int i = 0; i < elements.length; i++) {
         newElements[i] = elements[i];
      }
      assert elements.length * 2 == newElements.length;
      elements = newElements;
   }
}
