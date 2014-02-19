package org.interviewproblems.trainingweek.wen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//http://oj.leetcode.com/problems/clone-graph/
public class CloneGraph {

   class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;

      UndirectedGraphNode(int x) {
         label = x;
         neighbors = new ArrayList<UndirectedGraphNode>();
      }
   }


   Map<UndirectedGraphNode, UndirectedGraphNode> clones = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

   public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
      UndirectedGraphNode clone = shallowClone(node);
      for (UndirectedGraphNode original : clones.keySet()) {
         UndirectedGraphNode thisClone = clones.get(original);
         for (UndirectedGraphNode n : original.neighbors) {
            thisClone.neighbors.add(clones.get(n));
         }
      }
      return clone;
   }

   public UndirectedGraphNode shallowClone(UndirectedGraphNode node) {
      if (node == null) return null;
      UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
      clones.put(node, clone);
      for (UndirectedGraphNode n : node.neighbors) {
         if (!clones.containsKey(n)) {
            shallowClone(n);
         }
      }
      return clone;
   }


   // depthFirstSearch(Node root) {
   //     visit(root);
   //     root.visited = true;
   //     for (Node n : root.children) {
   //         if (!n.visited)
   //           visit(n);
   //     }
   // }
   //
   // bredthFirstSearch(Node root) {
   //     Queue q;
   //     visit(root);
   //     root.visited = true;
   //     q.enqueue(root);
   //     while (!q.isEmpty()) {
   //         Node n = q.remove();
   //         for (Node n : q.children()) {
   //             if (!n.visited) {
   //                 visit(n);
   //                 q.enqueue(n);
   //             }
   //         }
   //     }
   // }
}
