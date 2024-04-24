package org.example.mianshiTest;

import java.util.HashMap;
import java.util.Scanner;

public class ADivideB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        a %= b;
        HashMap<Integer,Integer> map = new HashMap<>();
        StringBuilder str = new StringBuilder();
        boolean isDivide = false;
        int index = 0;
        map.put(a,index);
        index++;
        while (true){
            a *= 10;
            int div = a / b;
            int res = a % b;
            str.append(div);
            if (res == 0) {
                isDivide = true;
                break;
            }
            if(map.containsKey(res)) {
                index = map.get(res);
                break;
            }
            else map.put(res,index);
            a = res;
            index++;
        }
        String str1 = str.toString();
        if (isDivide) System.out.println("0." + str1);
        else{
            String bef = str1.substring(0,index);
            String cir = str1.substring(index);
            System.out.println("0." + bef + "[" + cir + "]");
        }
    }
}
