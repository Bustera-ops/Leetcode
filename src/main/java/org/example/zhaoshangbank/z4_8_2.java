package org.example.zhaoshangbank;

import java.util.Scanner;

public class z4_8_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] array = new int[n];
            // 可以单减，可以单增，可以先增再减，出现减后就不能为增
            for (int j = 0; j < array.length; j++) array[j] = sc.nextInt();
            boolean isMinus = false;
            boolean flag = true;
            for (int j = 1; j < array.length; j++) {
                if(array[j] < array[j - 1]) isMinus = true;
                else{
                    if (isMinus && array[j] > array[j-1]) {
                        System.out.println("NO");
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) System.out.println("YES");
        }
    }
}
