package org.example.meituan;

import java.util.Scanner;

public class m3_9_3 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            String temp = in.next();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(temp.substring(j, j + 1));
                dp[i][j] = matrix[i][j];
            }
        }

        System.out.println(0);//第一层全不等

        for (int i = 1; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n - i; j++) {
                for (int k = 0; k < n - i; k++) {
                    for (int c = k; c <= k + i; c++) {
                        dp[j][k] += matrix[j + i][c];
                    }
                    for (int r = j; r < j + i; r++) {
                        dp[j][k] += matrix[r][k + i];
                    }
                    if (dp[j][k] * 2 == (i+1)*(i+1)) count++;
                }
            }
            System.out.println(count);
        }


    }

}