package com;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        long start,end;
        double timeK,timeP;

        String types[] = {"Sparse","Dense"};
        System.out.println("      \tKruskal:\t\t\tPrim:");
        for (int j=25;j<=50;j++) {
            timeK = 0;
            timeP = 0;
            System.out.println("For V= "+j+": ");
            for (String type : types){
            for (int i = 0; i < 20; i++) {
                int[][] graph = generate(j,type);

                start = System.nanoTime();
                Kruskal.kruskal(graph, j);
                end = System.nanoTime();
                timeK += (double) (end - start) / 1_000_000;
                //System.out.println("Kruskal: "+String.format("%.6f ms", (double) (end - start) / 1_000_000));

                start = System.nanoTime();
                Prim.primMain(graph, j);
                end = System.nanoTime();
                timeP += (double) (end - start) / 1_000_000;
                //System.out.println("Prim:    "+String.format("%.6f ms", (double) (end - start) / 1_000_000));
            }
        System.out.println(type+"\t"+String.format("%.4f ms", timeK/20)+"\t\t"+""+String.format("%.4f ms", timeP/20));
        //System.out.println("Prim:    "+String.format("%.6f ms\n", timeP/20));
            }
            System.out.println();
        }
    }

    public static int [][] generate(int n, String type) {
        int [][] graph = new int[n][n];
        int density=((n-1)*n)/2;
        Random rand = new Random();
        if (type.equals("Sparse")) density=(int)Math.ceil((density)* (rand.nextFloat()*.5));
        else density=(int)Math.ceil((density)* (rand.nextFloat()*.25+.75));
        while (density>0)
        for (int i=0;i<n-1;i++)
            for (int j=i+1;j<n;j++){
                if ((rand.nextFloat()>0.5)&&(graph[i][j]==0))
                {
                graph[i][j]= rand.nextInt(20);
                graph[j][i]=graph[i][j];
                density--;
                }
            }
        for (int i=0;i<n;i++)
            graph[i][i]=0;

        int i=0,count;
        for (int j=i+1;j<n;j++){
            count=0;
        for (i=0;i<n-1;i++){
            if (graph[i][j]==0) count++;
            }
        if (count==i) { count = rand.nextInt(i);
            graph[count][j]= rand.nextInt(20);
            graph[i][j]=graph[count][j];
        }
        }
/*        for ( i=0;i<n;i++){
            for (int j=0;j<n;j++)
        System.out.print(graph[i][j]+"\t");
            System.out.println();}
        System.out.println();*/
        return graph;
    }
}