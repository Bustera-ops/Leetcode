package org.example.tencent;

import java.util.Scanner;

public class t3_31_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            sum += array[i];
        }
        if(n == k) System.out.println(sum);
        else{
            long[][] dp = new long[n + 1][k + 1];
            long[] pre = new long[n + 1];
            for(int i = 1; i < dp.length; i++) pre[i] = pre[i - 1] ^ array[i - 1];
            for(int i = 1; i < dp.length; i++) dp[i][1] = pre[i];
            for(int i = 2; i < dp.length; i++){
                for(int j = 2; j < Math.min(i,k) + 1; j++){
                    for(int m = j - 1; m < i; m++){
                        long add = pre[i] ^ pre[m];
                        dp[i][j] = Math.max(dp[i][j], dp[m][j-1] + add);
                    }
                }
            }
            System.out.println(dp[n][k]);
        }
    }
}
