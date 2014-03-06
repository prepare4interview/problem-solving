package org.interviewproblems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreak2 {

   static class Node {
      char c;
      boolean word;
      String wordStr;
      Node(char c) {this.c = c;}
      Map<Character,Node> children = new HashMap<Character, Node>();

      Node addOrGet(char c) {
         if (children.containsKey(c)) return children.get(c);
         Node n = new Node(c);
         children.put(c, n);
         return n;
      }

      void word(boolean val) {this.word = val;}

      public Node get(char c) {
         return children.get(c);
      }
   }

   public ArrayList<String> wordBreak(String s, Set<String> dict) {
      Node root = new Node(' ');
      for (String w : dict) {
         Node it = root;
         for (int i = 0; i < w.length(); i++) {
            it = it.addOrGet(w.charAt(i));
         }
         it.word(true);
         it.wordStr = w;
      }
      ArrayList<String> result = split(s, root);
      return result;
   }

   public ArrayList<String> split(String s, final Node n) {
      if (s.length() == 0) {
         ArrayList<String> res = new ArrayList<String>();
         res.add("");
         return res;
      }
      Node it = n;
      ArrayList<String> res = new ArrayList<String>();
      for (int i = 0; i < s.length(); i++) {
         it = it.get(s.charAt(i));
         if (it == null) return res;
         if (it.word) {
            ArrayList<String> split = decorateSplit(s.substring(i + 1), n);
            for (String ss : split) res.add(it.wordStr + (ss.length() == 0 ? "" : " " + ss));
         }
      }
      return res;
   }

   Map<String, ArrayList<String>> memo = new HashMap<String, ArrayList<String>>();
   public ArrayList<String> decorateSplit(String s, final Node n) {
      if (memo.containsKey(s)) return memo.get(s);
      ArrayList<String> val = split(s, n);
      memo.put(s, val);
      return val;
   }

   public static void main(String[] args) {
      Set<String> dict = new HashSet<String>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
      String word = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
      ArrayList<String> bb = new WordBreak2().wordBreak(word, dict);
      System.out.println("bb = " + bb);
   }
}
