package org.interviewproblems.l4recurssion;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {

   public String simplifyPath(String path) {
      Deque<String> pathDeque = new LinkedList<String>();
      String[] dirs = path.split("/");
      for (String dir : dirs) {
         if (dir.equals(".") || dir.equals("")) continue;
         if (dir.equals("..")) {
            if (!pathDeque.isEmpty()) pathDeque.pop();
         } else {
            pathDeque.push(dir);
         }
      }
      StringBuilder result = new StringBuilder("/");
      while (!pathDeque.isEmpty()) {
         result.append(pathDeque.removeLast());
         if (pathDeque.isEmpty()) break;
         result.append("/");
      }
      return result.toString();
   }

   public static void main(String[] args) {
      String str = "/a";
      String[] s = str.split("/");
      for (String a : s) {
         System.out.println("'" + a + "'");
      }
   }
}
