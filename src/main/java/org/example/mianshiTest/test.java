package org.example.mianshiTest;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {
    public static void main(String[] args) {
       HashMap<Integer, Integer> map = new HashMap<>();
       map.put(1,1);
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
