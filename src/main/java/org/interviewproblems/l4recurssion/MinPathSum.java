package org.interviewproblems.l4recurssion;

import java.util.HashMap;
import java.util.Map;

public class MinPathSum {

   public int minPathSum(int[][] grid) {
      return _minPathSum(grid, 0, 0, 0);
   }

   Map<String,Integer> cache = new HashMap<String, Integer>();

   public Integer _minPathSum(int[][] grid, int x, int y, int pathSum) {
      Integer cached = cache.get(x + "_" + y);
      if (cached != null) return cached;

      int rows = grid.length;
      int columns = grid[0].length;
      if (x >= rows || y >= columns) return Integer.MAX_VALUE;

      if (x == rows - 1 && y == columns - 1) {
         return grid[x][y];
      } else {
         Integer valDown = _minPathSum(grid, x + 1, y, pathSum + grid[x][y]);
         Integer valRight = _minPathSum(grid, x, y + 1, pathSum + grid[x][y]);
         int toCache = Math.min(valDown, valRight) + grid[x][y];
         cache.put(x +"_" + y, toCache);
         return toCache;
      }
   }

}
