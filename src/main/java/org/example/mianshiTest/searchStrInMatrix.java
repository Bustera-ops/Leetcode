package org.example.mianshiTest;

public class searchStrInMatrix {
    static int ans = 0;
    static String target = "alilae";

    static char[][] matrix =
            {{'a','b','c','a'},
            {'d','e','q','l'},
            {'b','a','l','i'},
            {'a','b','c','c'}};
    public static void main(String[] args) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                DFS(i,j,0,4);
            }
        }
        System.out.println(ans);
    }

    public static void DFS(int i,int j,int num,int lastDir){
        if (matrix[i][j] == target.charAt(num)){
            if(num + 1 == target.length()){
                ans += 1;
                return;
            }
            if(i != 0 && lastDir != 0 ) DFS(i-1,j,num+1,2);
            if(i != matrix.length - 1 && lastDir != 2) DFS(i+1,j,num+1,0);
            if(j != 0 && lastDir != 3) DFS(i,j-1,num+1,1);
            if(j != matrix[0].length - 1 && lastDir != 1) DFS(i,j+1,num+1,3);
        }
    }
}
