package org.interviewproblems.trainingweek.tue;

public class Candy {

   public int candy(int[] ratings) {

      if (ratings.length == 1) return 1;
      int count = 1;
      int i = 1;
      while (i < ratings.length) {
         int prev = 1;
         while (i < ratings.length && ratings[i] > ratings[i - 1]) {
            prev++;
            i++;
            count += prev;
         }

         while (i < ratings.length && ratings[i] == ratings[i - 1]) {
            i++;
            count++;
            prev = 1;
         }

         int dec = 0;
         while (i < ratings.length && ratings[i] < ratings[i - 1]) {
            dec++;
            i++;
         }

         if (dec != 0 ) {
            count += (dec + 1) * (dec + 2) / 2;
            count -= Math.min(dec + 1, prev);
         }
      }

      return count;
   }

   public static void main(String[] args) {
      System.out.println("Candy = " + candyS(new int[]{1,3,4,3,2,1}));
   }

   public static int candyS(int[] ratings) {
      return new Candy().candy(ratings);
   }
}
