package org.example.alibaba.xiecheng;

import java.util.Scanner;

public class x3_28_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            ans += array[i];
        }
        int min = 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            if (array[i-1] % 2 != 0) dp[i] = 0;
            else{
                dp[i] = Math.min(dp[i-1] + array[i-1],array[i-1]);
                min = Math.min(min,dp[i]);
            }
        }
        System.out.println(ans + (min / 2 - min));
    }
}
