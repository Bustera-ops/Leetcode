package org.example.alibaba.mayi;

import java.util.ArrayList;

public class m4_12_2 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static ArrayList<Integer> tempList = new ArrayList<>();
    static int[] arr = {1,2,3};
    static boolean[] used = new boolean[arr.length];
    public static void main(String[] args) {
        backTracking();
        for (ArrayList<Integer> integers : list) System.out.println(integers);
    }

    public static void backTracking(){
        if (tempList.size() == arr.length) list.add(new ArrayList<>(tempList));
        else {
            for (int i = 0; i < arr.length; i++) {
                if (used[i]) continue;
                used[i] = true;
                tempList.add(arr[i]);
                backTracking();
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
