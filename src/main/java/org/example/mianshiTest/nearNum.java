package org.example.mianshiTest;

import java.util.Scanner;

public class nearNum {
    public static void main(String[] args) {
        while (true){
            Scanner sc = new Scanner(System.in);
            String num = sc.next();
            String[] split = num.split("\\.");
            if (split.length == 1) System.out.println(Integer.parseInt(split[0]) - 1 + ".99");
            else {
                String integer = split[0];
                String decimal = split[1];
                if (decimal.length() == 1) decimal += "0";
                int parseInt = Integer.parseInt(decimal);
                if (parseInt <= 24 || parseInt > 74) {
                    if (0 <= parseInt && parseInt <= 24) System.out.println(Integer.parseInt(integer) - 1 + ".99");
                    else System.out.println(Integer.parseInt(integer) + ".99");
                }
                else System.out.println(Integer.parseInt(integer) + ".49");
            }
        }

    }
}
