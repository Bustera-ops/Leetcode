package org.example.mihayou;

import java.util.Arrays;
import java.util.Scanner;

public class h_3_17_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        int[] y = new int[m];
        for (int i = 0; i < m; i++) {
            y[i] = sc.nextInt();
        }
        Arrays.sort(x);
        Arrays.sort(y);
        int countX = 0;
        int tempX = 1;
        for (int i = 0; i < x.length; i++) {
            if (i != x.length -1){
                if (x[i] == x[i+1]) {
                    tempX++;
                }
                else {
                    countX += tempX * (i+1);
                    tempX = 1;
                }
            }
            else{
                countX += tempX * x.length;
            }
        }
        int countY = 0;
        int tempY = 1;
        for (int i = 0; i < y.length; i++) {
            if (i != y.length -1){
                if (y[i] == y[i+1]) {
                    tempY++;
                }
                else {
                    countY += tempY * (i+1);
                    tempY = 1;
                }
            }
            else{
                countY += tempY * y.length;
            }
        }
        System.out.println(countX * countY);
    }
}
