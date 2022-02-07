import leetcode.problems.easy.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Scratch {
 public static void main(String[] args) {
  int n = 45;

  if (n == 1) {
   System.out.println("Number of combinations  : " + n);
   System.exit(0);
  }

  int[] result = new int[n+1];

  result[1] = 1;
  result[2] = 2;

  int dp = dynamicProgramming(n, result);
  System.out.println("Number of combinations using DP: " + dp);

  int fibo = fibonacciSeries(n, result);
  System.out.println("Number of combinations using Fibo: " + fibo);
 }

 public static int dynamicProgramming(int n, int[] result){
  int sum = 0;
  for (int i = 3; i <= n ; i++) {
   result[i] = result[i-1] +  result[i-2];
  }
  return result[n];
 }

 public static int fibonacciSeries(int n, int[] result){
  int sum = 0;
  int first = result[1], second = result[2], third = 0;
  for (int i = 3; i <= n ; i++) {
   third = first + second;
   first = second;
   second = third;
  }
  return second;
 }
}
