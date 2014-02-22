package org.interviewproblems.trainingweek.sat;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Typeahead {

   static TrieNode root = new TrieNode();

   static class TrieNode {
      Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
      Character c;
      boolean word;
      TrieNode parent;
      TrieNode(){};
      TrieNode (char c, TrieNode parent) {this.c = c;this.parent = parent;}
      TrieNode getOrCreate(char c) {
         if (!children.containsKey(c))
            children.put(Character.toLowerCase(c), new TrieNode(c, this));
         return children.get(Character.toLowerCase(c));
      }

      TrieNode get(char c) {
         return children.get(c);
      }

      String toWord() {
         StringBuilder result = new StringBuilder();
         TrieNode n = this;
         while (n != root) {
            result.append(n.c);
            n = n.parent;
         }
         return result.reverse().toString();
      }
   }

   public static void typeahead(String[] usernames, String[] queries) {

      for (String s: usernames) {
         TrieNode t = root;
         for (int i = 0; i < s.length(); i++) {
            t = t.getOrCreate(s.charAt(i));
         }
         t.word = true;
      }

      for (String s : queries) {
         TrieNode tn = root;
         for (int i = 0; i < s.length() && tn != null; i++) {
            tn = tn.get(Character.toLowerCase(s.charAt(i)));
         }
         if (tn == null) {
            System.out.println(-1);
            continue;
         }
         if (tn.word) {
            System.out.println(s);
            continue;
         }
         Deque<TrieNode> q = new ArrayDeque<TrieNode>();
         q.addLast(tn);
         boolean found = false;
         while (!q.isEmpty() && !found) {
            TrieNode t = q.removeFirst();
            for (TrieNode n : t.children.values()) {
               if (n.word) {
                  System.out.println(n.toWord());
                  found = true;
               } else {
                  q.addLast(n);
               }
            }
         }
      }

      // Write your code here
      // To print results to the standard output please use System.out.println
      // Example: System.out.println("Hello world!");
   }

   public static void main(String[] args) {
      String[] un = new String[] {"Mitzi", "SandeeRudolph", "TenaLynetta", "IsabelleEllen", "BridgetDale"};
      String[] queries = new String[] {"IEab", "S", "TenALYne"};

      typeahead(un, queries);
   }

}
