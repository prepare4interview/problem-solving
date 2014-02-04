package org.interviewproblems.l3stacksqueuesheaps;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class P8ReverseALinkedListTest {

   P8ReverseALinkedList problem = new P8ReverseALinkedList();

   public void simpleTest() {
      P8ReverseALinkedList.Node n5 = new P8ReverseALinkedList.Node(5, null);
      P8ReverseALinkedList.Node n4 = new P8ReverseALinkedList.Node(4, n5);
      P8ReverseALinkedList.Node n3 = new P8ReverseALinkedList.Node(3, n4);
      P8ReverseALinkedList.Node n2 = new P8ReverseALinkedList.Node(2, n3);
      P8ReverseALinkedList.Node n1 = new P8ReverseALinkedList.Node(1, n2);
      P8ReverseALinkedList.Node n0 = new P8ReverseALinkedList.Node(0, n1);

      ArrayList<Integer> forward = new ArrayList<Integer>();
      P8ReverseALinkedList.Node it = n0;
      while (it != null) {
         forward.add(it.value);
         it = it.next;
      }

      it = problem.invertList(n0);
      ArrayList<Integer> backward = new ArrayList<Integer>();
      while (it != null) {
         backward.add(it.value);
         it = it.next;
      }

      for (int i = 0; i < forward.size(); i++) {
         assertEquals(forward.get(i), backward.get(backward.size() - i - 1));
      }
   }
}
