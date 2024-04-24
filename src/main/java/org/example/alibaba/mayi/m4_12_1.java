package org.example.alibaba.mayi;

public class m4_12_1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int count = 0;
        int num = -1;
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                num = array[i];
                count++;
            }
            if (num == array[i]) count++;
            else count--;
        }
        System.out.println(num);
    }
}
