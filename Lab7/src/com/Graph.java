package com;

import java.util.*;

public class Graph {

    private final int [][] graph;
    private int numberOfNodes;

    public Graph(int n,boolean type) { //1- sparse, 0-dense
        numberOfNodes= n;
        if (type) graph=generate(n,"Dense");
        else graph=generate(n,"Sparse");
    }

    public Graph(int [][] oldGraph) {
        graph=oldGraph;
    }

    private static int [][] generate(int n, String type) {
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
                if (count==j) count++;
                graph[count][j]= rand.nextInt(20);
                graph[j][count]=graph[count][j];
            }
        }
        return graph;
    }

    public void showGraph() {
                for (int i=0;i<numberOfNodes;i++){
            for (int j=0;j<numberOfNodes;j++)
        System.out.print(graph[i][j]+"\t");
            System.out.println();}
        System.out.println();
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public int[][] getGraph() {
        return graph;
    }

    public void dijkstra(int start) {

        ArrayList<Integer> distance = new ArrayList<>();
        ArrayList<Boolean> used = new ArrayList<>();

        if (graph!=null) {
            for (int i = 0; i < numberOfNodes; i++) {
                if (i==start) distance.add(0);
                else
                distance.add(Integer.MAX_VALUE);
                //previous.add(0);
                used.add(false);
                //if (i!=start) queue.add(i);
            }

            for (int i=0;i<numberOfNodes;i++)
            {
                int v=-1;

                for (int j=0;j<numberOfNodes;j++)
                    if ((!used.get(j))&&((v==-1)||(distance.get(j)<distance.get(v))))
                        v = j;

                if (distance.get(v)==Integer.MAX_VALUE)
                    break;

                used.set(v,true);
                for (int j=0;j<numberOfNodes;j++) {
                    if ((distance.get(v)+graph[v][j]<distance.get(j))&&(graph[v][j]!=0)) {
                        distance.set(j,distance.get(v)+graph[v][j]);
                        //System.out.println(v+"->s"+j);
                    }
                }
            }

            //System.out.println(distance);

        }
    }

    public void floyd() {

        int [][] distance= new int[numberOfNodes][numberOfNodes];

        for (int i=0;i<numberOfNodes;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
            distance[i][i]=0;
        }

        for (int i=0;i<numberOfNodes;i++)
            for (int j=0;j<numberOfNodes;j++)
                if (graph[i][j]!=0) distance[i][j]=graph[i][j];

        for (int k = 0; k < numberOfNodes; k++)
            for (int i = 0; i < numberOfNodes; i++)
                for (int j = 0; j < numberOfNodes; j++)
                    if ((distance[i][j]>distance[i][k]+distance[k][j])&&((distance[i][k]!=0)&&(distance[k][j]!=0))&&(distance[i][k]+distance[k][j]>0))
                        distance[i][j]=distance[i][k]+distance[k][j];

        /*for (int i = 0; i < numberOfNodes; i++){
            for (int j = 0; j < numberOfNodes; j++)
                System.out.print(distance[i][j]+" ");
            System.out.println();}*/
    }
}
