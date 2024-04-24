package org.example.alibaba.xiecheng;

import java.math.BigInteger;
import java.util.Scanner;

public class x3_28_4 {
        // 计算阶乘
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // 计算因子数量
    public static int countFactors(BigInteger num) {
        int count = 0;
        BigInteger sqrt = num.sqrt();
        for (BigInteger i = BigInteger.ONE; i.compareTo(sqrt) <= 0; i = i.add(BigInteger.ONE)) {
            if (num.mod(i).equals(BigInteger.ZERO)) {
                count++;
                if (!i.equals(num.divide(i))) {
                    count++;
                }
            }
        }
        return count;
    }

    // 计算阶乘乘积的因子数量
    public static int productFactorialFactors(int[] arr) {
        BigInteger product = BigInteger.ONE;
        for (int num : arr) {
            product = product.multiply(factorial(num));
        }
        return countFactors(product);
    }

    public static void main(String[] args) {
        // 示例输入数组
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(productFactorialFactors(arr));
    }

}
