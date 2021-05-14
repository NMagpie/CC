package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    static List<Node> arr = new ArrayList<>();
    static int[] parent;
    static int[] rank;
    static int ans = 0;

    public static void kruskal(int [][]graph,int n) {
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] != 0) {
                    arr.add(new Node(i, j, graph[i][j]));
                }
            }
        }
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            Node node = arr.get(i);
            union_root(node);
        }
        //System.out.println(ans);
    }

    private static void union_root(Node node) {
        int x_root = find_root(node.x);
        int y_root = find_root(node.y);
        if (x_root == y_root) {
            return;
        } else {
            if (rank[x_root] > rank[y_root]) {
                parent[y_root] = x_root;
            } else if (rank[x_root] < rank[y_root]) {
                parent[x_root] = y_root;
            } else {
                parent[x_root] = y_root;
                rank[y_root]++;
            }
            ans += node.val;
        }
    }

    private static int find_root(int x) {
        if (parent[x] == -1) return x;
        return parent[x] = find_root(parent[x]);
    }

}

class Node implements Comparable<Node> {
    int x;
    int y;
    int val;

    public Node(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Node o) {
        return this.val - o.val;
    }
}
