package org.example.zhaoshangbank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class z4_8_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char c = (char)('a' + i);
            map.put(c, new HashSet<Character>());
        }
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char temp = s.charAt(i - 1);
            map.get(c).add(temp);
        }
        map.forEach((character, characters) -> System.out.print(characters.size() + " "));
    }
}
