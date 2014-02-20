package org.interviewproblems.trainingweek.thu;

public class ZigZagConversion {

   public String convert(String s, int nRows) {
      if (nRows == 1) return s;

      StringBuilder[] rows = new StringBuilder[nRows];
      for (int i = 0; i < rows.length; i++)
         rows[i] = new StringBuilder();

      int step = 2 * nRows - 2;
      for (int i = 0; i < s.length(); i+= step) {
         int r = 0;
         for (int j = i; j < Math.min(s.length(), i + nRows); j++){
            rows[r++].append(s.charAt(j));
         }
         r = nRows - 2;
         for (int j = i + nRows; j < Math.min(s.length(), i + step); j++){
            rows[r--].append(s.charAt(j));
         }
      }

      StringBuilder result = new StringBuilder();
      for (StringBuilder r : rows)
         result.append(r.toString());
      return result.toString();
   }

   public static void main(String[] args) {
      System.out.println("new ZigZagConversion().convert(\"PAYPALISHIRING\", 3) = " + new ZigZagConversion().convert("PAYPALISHIRING", 3));
   }
}
