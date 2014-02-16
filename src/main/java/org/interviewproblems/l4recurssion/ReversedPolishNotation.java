package org.interviewproblems.l4recurssion;

import java.util.Deque;
import java.util.LinkedList;

public class ReversedPolishNotation {

   public int evalRPN(String[] tokens) {
      Deque<Integer> q = new LinkedList<Integer>();
      for (String s: tokens) {
         if (s.matches("-|/|\\*|\\+")) {
            Integer b = q.pop();
            Integer a = q.pop();
            Integer result = null;
            switch (s.charAt(0)) {
               case '+' : result = a + b; break;
               case '-' : result = a - b; break;
               case '*' : result = a * b; break;
               case '/' : result = a / b; break;
               default  : throw new IllegalStateException();
            }
            q.push(result);
         } else {
            q.push(Integer.valueOf(s));
         }
      }
      return q.pop();
   }
}
