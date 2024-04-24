package org.example.meituan;

import java.util.HashSet;
import java.util.Scanner;

public class m3_9_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int q = Integer.parseInt(s[2]);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            String[] temp = sc.nextLine().split(" ");
            int small = Integer.parseInt(temp[0]) - 1;
            int big = Integer.parseInt(temp[1]) - 1;
            if (big < small){
                int temp1 = small;
                small = big;
                big = temp1;
            }
            set.add(small*n+big);
        }
        for (int i = 0; i < q; i++) {
            String[] deal = sc.nextLine().split(" ");
            int op = Integer.parseInt(deal[0]);
            int u = Integer.parseInt(deal[1]) - 1;
            int v = Integer.parseInt(deal[2]) - 1;
            if (v < u){
                int temp1 = u;
                u = v;
                v = temp1;
            }
            if (op == 1){
                set.remove(u*n+v);
            }
            else {
                //根据HashSet构建
                int[] parent = new int[n];
                for (int i1 = 0; i1 < parent.length; i1++) {
                    parent[i1] = i1;
                }
                for (Integer integer : set) {
                    int man1 = integer / n;
                    int man2 = integer % n;
                    parent[man2] = parent[man1];
                }
                while (parent[u] != u) u = parent[u];
                while (parent[v] != v) v = parent[v];
                if (u == v) System.out.println("Yes");
                else System.out.println("No");
            }
        }
     }
}
