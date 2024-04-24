package org.example.alibaba.linxi;

import java.util.HashMap;
import java.util.Scanner;

public class l3_30_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            HashMap<Character, Integer> map = new HashMap<>();  // 统计s1字符串里字符的出现次数
            for (int j = 0; j < s1.length(); j++) {
                char c = s1.charAt(j);
                if (map.containsKey(c)) map.put(c,map.get(c) + 1);
                else map.put(c,1);
            }
            int cur = 0;
            boolean flag = false; // 记录是否存在
            HashMap<Character, Integer> tempMap = new HashMap<>(map);  //深拷贝，不在原来的map上该
            while(cur < s2.length()){
                if (!tempMap.containsKey(s2.charAt(cur))) { // 当前字符不存在，先前统计的均无效，需要重置tempMap
                    cur++;
                    tempMap = new HashMap<>(map);
                }
                else{ // 字符存在，开始扣减
                    if (tempMap.get(s2.charAt(cur)) == 1) tempMap.remove(s2.charAt(cur));  // 只剩一个直接删
                    else tempMap.put(s2.charAt(cur), tempMap.get(s2.charAt(cur)) - 1);  // 剩多的可以扣
                    cur++;
                    if (tempMap.size() == 0) { // 如果tempMap为空说明找到了匹配
                        flag = true;
                        break;
                    }
                }
            }
            System.out.println(flag);
        }
    }
}
