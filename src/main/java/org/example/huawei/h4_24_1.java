package org.example.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class h4_24_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(array);
        int target = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        sb.append('S');
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (target == array[middle]) {
                sb.append('Y');
                System.out.println(sb);
                return;
            }
            else if (target > array[middle]) {
                start = middle + 1;
                if (start != end) sb.append('R');
            }
            else {
                end = middle - 1;
                if (start != end) sb.append('L');
            }
        }
        sb.append('N');
        System.out.println(sb);
        System.out.println("修改了一点点");
        System.out.println("修改了二点点");
        System.out.println("修改了三点点!!");
    }
}
