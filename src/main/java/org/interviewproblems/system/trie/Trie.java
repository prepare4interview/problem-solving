package org.interviewproblems.system.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

//size (with compacting) 8 + 2 + 1 + (8 + 4 + 44) * 2 = 11 + 112 = 123
//size (without compacting) 16 + 2 + 1 + (16 + 4 + 88 + 8) * 2 = 19 + 232 = 251

//alternative calculation: ( 8 + 2 + 1 + 2 * (12 + 4) ) * instanceCount + instanceCount*4
// == 40*instanceCount + instanceCount * 4

class Node { //8 bytes

   static int instanceCount = 0;


   Node() {
      instanceCount++;
   }

   char character;    // 2 bytes
   boolean isLeaf;              // 1 byte
   Node[] children = new Node[0];        //8 bytes (header) + 4 bytes (length) + 4 * 10 content + 4 bytes (the reference)
   Node[] favorites = new Node[10];      //8 bytes (header) + 4 bytes (length) + 4 * 10 content + 4 bytes (the reference)

   public void addWord(String w) {
      if (w.length() == 0) {
         isLeaf = true;
         return;
      }
      for (Node n : children) {
         if (n.character == w.charAt(0)) {
            n.addWord(w.substring(1));
            return;
         }
      }
      Node[] newChildren = new Node[children.length + 1];
      System.arraycopy(children, 0, newChildren, 0, children.length);
      children = newChildren;
      Node newNode = new Node();
      children[children.length - 1] = newNode;
      newNode.character = w.charAt(0);
      newNode.addWord(w.substring(1));
   }

   int countNoChildren() {
      if (!hasChildren()) return 1;
      int size = 0;
      for (Node n : children) {
         size += n.countNoChildren();
      }
      return size;
   }

   boolean hasChildren() {
      for (Node c : children)
         if (c != null) return true;
      return false;
   }

   int size() {
      int size = 1;
      for (Node n : children) {
         size += n.size();
      }
      return size;
   }

   public Node[] getTenChildren() {
      List<Node> favs = new ArrayList<Node>();
      addFavs(favs);
      return favs.toArray(new Node[10]);
   }

   private void addFavs(List<Node> favs) {
      for (Node aChildren : children) {
         favs.add(aChildren);
         if (favs.size() == 10) return;
      }
      for (Node n : children)
         if (favs.size() < 10) n.addFavs(favs);
   }

   boolean isWord(String w) {
      if (w.isEmpty()) return true;
      for (Node n : children) {
         if (n.character == w.charAt(0)) return n.isWord(w.substring(1));
      }
      return false;
   }

   public void setFavorites(Node[] favorites) {
      System.arraycopy(favorites, 0, this.favorites, 0, favorites.length);
      for (Node n : children) n.setFavorites(favorites);
   }
}

public class Trie {

   public static void main(String[] args) throws InterruptedException {
      int wordCount = 100000;
      int wordSize = 10;
      Set<String> words = new HashSet<String>();
      Random r = new Random();
      for (int i = 0; i < wordCount; i++) {
         String w = "";
         for (int j = 0; j < wordSize; j++) {
            int i1 = r.nextInt('z' - 'a' + 1);
            w += (char) ('a' + i1);
         }
         words.add(w);
      }
      Node root = new Node();
      for (String w : words) {
         root.addWord(w);
      }


      Node[] favs = root.getTenChildren();
      root.setFavorites(favs);

      for (String w : words) {
         assertTrue(root.isWord(w));
      }

      for (String w : words) {
         assertFalse(root.isWord(w + "a"));
      }

      words.clear();
      words = null;
      r = null;
      int size = root.size();
      int noChildren = root.countNoChildren();
      System.out.println("noChildren = " + noChildren);
      int memoryInKb = (123 * size - noChildren * 10 * 4) / 1024;
      int memoryInKbAlt = (40 * Node.instanceCount + Node.instanceCount * 4)/1024;
      int memoryInKbNoCompact = (251 * size - noChildren * 10 * 8) / 1024;


      while (true) {
         System.out.println("Node instance count = " + Node.instanceCount);
         System.out.println("Size of " + root + " is " + size + ". Expected memory usage (KB):" + memoryInKb);
         System.out.println("Size of " + root + " is " + size + ". Expected memory usage ALT (KB):" + memoryInKbAlt);
         System.out.println("Size of " + root + " is " + size + ". Expected memory usage (MB):" + memoryInKb/1024);
         System.out.println("Size of " + root + " is " + size + ". Expected memory usage (KB) no compaction:" + memoryInKbNoCompact);
         Thread.sleep(60 * 1000);
      }
   }

}

