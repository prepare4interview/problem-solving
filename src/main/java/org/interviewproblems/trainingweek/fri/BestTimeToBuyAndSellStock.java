package org.interviewproblems.trainingweek.fri;

//http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {

   public int maxProfit(int[] prices) {
      if(prices.length == 0) return 0;

      int min = prices[0];
      int it = 1;
      int profit = 0;

      while (it < prices.length) {
         min = Math.min(min, prices[it]);
         profit = Math.max(profit, prices[it] - min);
         it++;
      }

      return profit;
   }
}
