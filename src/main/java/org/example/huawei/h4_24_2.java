package org.example.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class h4_24_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            String shoot = sc.next();
            ArrayList<String> temp = new ArrayList<>();
            int maxLong = 0;
            int tempLong = 0;
            int count = 0;
            for (int j = 0; j < shoot.length(); j++) {
                if (shoot.charAt(j) == '1') {
                    tempLong++;
                    count++;
                    if (tempLong > maxLong) maxLong = tempLong;
                }
                else tempLong = 0;
            }
            // 总数  连续1  大小 id
            temp.add(String.valueOf(count));
            temp.add(String.valueOf(maxLong));
            temp.add(shoot);
            temp.add(String.valueOf(i));
            list.add(temp);
        }
        list.sort((ArrayList<String> o1, ArrayList<String> o2) -> {
                if (!o1.get(0).equals(o2.get(0))) return Integer.parseInt(o2.get(0)) - Integer.parseInt(o1.get(0));
                else if (!o1.get(1).equals(o2.get(1))) return Integer.parseInt(o2.get(1)) - Integer.parseInt(o1.get(1));
                else if (!o1.get(2).equals(o2.get(2))) {
                    String s1 = o1.get(2);
                    String s2 = o2.get(2);
                    for (int i = 0; i < s1.length(); i++) {
                        if (s1.charAt(i) > s2.charAt(i)) return -1;
                        else if (s1.charAt(i) < s2.charAt(i)) return 1;
                    }
                    return 0;
                }
                else return Integer.parseInt(o1.get(3)) - Integer.parseInt(o2.get(3));
                });
        for (ArrayList<String> strs : list) {
            System.out.print(strs.get(3) + " ");
        }
    }
}
