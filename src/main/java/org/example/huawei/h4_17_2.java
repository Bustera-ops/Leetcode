package org.example.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class h4_17_2 {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        HashMap<String, Integer> mapForNum = new HashMap<>();
        HashMap<String, ArrayList<String>> mapForLink = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String child = sc.next();
            String father = sc.next();
            int level = sc.nextInt();
            int number = sc.nextInt();
            if (mapForNum.containsKey(child)) mapForNum.put(child, mapForNum.get(child) + (5 - 3 * level) * number);
            else mapForNum.put(child, (5 - 3 * level) * number);
            if (mapForLink.containsKey(father)) {
                if (!mapForLink.get(father).contains(child)) mapForLink.get(father).add(child);
            }
            else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(child);
                mapForLink.put(father,temp);
            }
        }

        //统计
        ArrayList<String> list = mapForLink.get("*");
        for (String s : list) count(mapForLink, mapForNum, s, M);
        System.out.println(ans);

    }

    public static int count(HashMap<String, ArrayList<String>> mapForLink, HashMap<String, Integer> mapForNum, String cur, int M) {
        int add = mapForNum.get(cur);
        boolean flag = false;
        if (add > M) {
            ans += 1;
            flag = true;
        }
        ArrayList<String> childList = mapForLink.get(cur);
        if (childList == null) return add;
        for (String s : childList) {
            add += count(mapForLink, mapForNum, s, M);
            if (!flag && add > M) {
                ans += 1;
                flag = true;
            }
        }
        return add;
    }
}
