package org.example.meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class m3_9_4 {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int count2 = 0, count5 = 0;

        for (int num : array) { //统计所有的情况
            if (!map.containsKey(num)){
                int temp = num;
                int count2_temp = 0, count5_temp  = 0;
                while (temp % 2 == 0){
                    temp /= 2;
                    count2_temp ++;
                }
                count2 += count2_temp;
                temp = num;
                while (temp % 5 == 0){
                    temp /= 5;
                    count5_temp ++;
                }
                count5 += count5_temp;
                ArrayList<Integer> temp2 = new ArrayList<>();
                temp2.add(count2_temp);
                temp2.add(count5_temp);
                map.put(num,temp2);
            }
            else {
                ArrayList<Integer> integers = map.get(num);
                count2 += integers.get(0);
                count5 += integers.get(1);
            }
        }
        int i = 0, j = 0;
        int ans = 0;
        int delete2 = 0,delete5 = 0;
        while (j <= n){
            if (Math.min(count2-delete2,count5-delete5) >= k){
                ans += j-i;
                if (j == n) break;
                int num = array[j];
                ArrayList<Integer> integers = map.get(num);
                delete2 += integers.get(0);
                delete5 += integers.get(1);
                j++;
            }
            else {
                while (Math.min(count2-delete2,count5-delete5) < k){
                    int num = array[i];
                    ArrayList<Integer> integers = map.get(num);
                    delete2 -= integers.get(0);
                    delete5 -= integers.get(1);
                    i++;
                }
            }
        }
        System.out.println(ans);
    }
}
