package com;

import java.util.ArrayList;
import java.util.List;

public class Prim {
    static List<Integer> arr = new ArrayList<>();
    static boolean[] vis;

    public static void primMain(int [][]graph,int n) {
        vis = new boolean[n];
        int ans = prim(graph,0,n);
        //System.out.println(ans);
    }

    private static int prim(int [][]graph,int start,int n) {
        int ans = 0;
        for (int i = 0; i < n-1; i++) {

            arr.add(start);

            vis[start] = true;
            int val = Integer.MAX_VALUE;

            for (int row : arr) {
                for (int j = 0; j < n; j++) {
                    if (!vis[j]) {
                        if (graph[row][j] < val && graph[row][j] > 0) {
                            start = j;
                            val = graph[row][j];
                        }
                    }
                }
            }
            ans += val;
        }
        return ans;
    }
}
