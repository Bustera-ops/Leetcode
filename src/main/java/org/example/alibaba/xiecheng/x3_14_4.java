package org.example.alibaba.xiecheng;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class x3_14_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int q = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < q; i++) {
            int n = Integer.parseInt(sc.nextLine());
            String[] s = sc.nextLine().split(" ");
            int[] a = new int[n];
            int add = 0;
            for (int j = 0; j < s.length; j++) {
                if (Integer.parseInt(s[j]) % 2 == 0) a[j] = 0;
                else a[j] = 1;
                add += a[j];
            }
            if (add % 2 == 1){
                System.out.println("No");
                continue;
            }
            HashMap<String,ArrayList<String>> map = new HashMap<>();
            for (int j = 0; j < n - 1; j++) {
                String link = sc.nextLine();
                String[] node = link.split(" ");
                if (map.containsKey(node[0])) map.get(node[0]).add(link);
                else {
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add(link);
                    map.put(node[0], temp);
                }
                if (map.containsKey(node[1])) map.get(node[1]).add(link);
                else {
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add(link);
                    map.put(node[1], temp);
                }
            }
            ArrayList<String> ans = new ArrayList<>();
            while (!map.isEmpty()){
                ArrayList<String> tempDel = new ArrayList<>();
                map.forEach((s1, strings) -> {
                    if (strings.size() == 0) {
                        tempDel.add(s1);

                    }
                    else if (strings.size() == 1){
                        int num = Integer.parseInt(s1);
                        String[] s2 = strings.get(0).split(" ");
                        int num2;
                        if (Integer.parseInt(s2[0]) == num) num2 = Integer.parseInt(s2[1]);
                        else num2 = Integer.parseInt(s2[0]);
                        if (a[num-1] == 1) {
                            a[num2 - 1] ^= 1;
                            a[num - 1] = 0;
                            ans.add(strings.get(0));
                        }
                        tempDel.add(s1);
                        map.get(Integer.toString(num2)).remove(strings.get(0));
                    }
                });
                for (String s1 : tempDel) {
                    map.remove(s1);
                }
            }
            boolean flag = true;
            for (int k : a) {
                if (k != 0) {
                    System.out.println("No");
                    flag = false;
                }
            }
            if (flag){
                System.out.println("Yes");
                System.out.println(ans.size());
                for (String an : ans) {
                    System.out.println(an);
                }
            }

        }
    }
}
