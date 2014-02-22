package org.interviewproblems.trainingweek.sat;

/**
 * Write a simple parser to parse a formula and calculate the result. Given a string
 * containing only integer numbers, brackets, plus and minus signs, calculate and
 * print the numeric answer. Assume that the formula will always follow correct syntax
 */
public class SimpleExpression {
   public static void compute_expression(String expr) {
      System.out.println(_compute_expression(expr));
   }


   public static int _compute_expression(String expr) {
      int level = 0;
      for (int i = expr.length() - 1; i >= 0 ; i--) {
         switch (expr.charAt(i)) {
            case '(' : {
               level++;
               break;
            }
            case ')' : {
               level--;
               break;
            }
            case '+' : {
               if (level == 0)
                  return _compute_expression(expr.substring(0,i)) + _compute_expression(expr.substring(i+1));
            }
            case '-' : {
               if (level == 0)
                  return _compute_expression(expr.substring(0,i)) - _compute_expression(expr.substring(i+1));
            }
         }
      }

      //no level 0 operators
      if (expr.indexOf('(') == 0) {
         expr = expr.substring(1);
         expr = expr.substring(0, expr.length() -1);
         return _compute_expression(expr);
      } else {
         return Integer.valueOf(expr);
      }
   }

}
