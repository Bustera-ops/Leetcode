package org.example.alibaba.aliyun;

import java.util.Scanner;

public class a_3_24_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < price.length; i++) {
            price[i] = sc.nextInt();
        }
        int[][] dp = new int[n - 1][n];
        //初始化最初城镇
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = price[0] * i;
        }

        for (int i = 1; i < dp[0].length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (j == 0) {
                    dp[j][i] = Math.min(dp[1][i-1],dp[0][i-1] + price[i-1]);
                    continue;
                }
                int temp = dp[0][i-1] + (j+1) * price[i-1] + j;
                for (int k = 1; k <= j; k++) temp = Math.min(temp,dp[k][i-1] + (j-k + 1)* price[i-1] + j);
                if (j != dp.length - 1) dp[j][i] = Math.min(dp[j+1][i-1] + j,temp);
                else dp[j][i] = temp;
            }
        }

        System.out.println(dp[0][dp.length]);
    }
}