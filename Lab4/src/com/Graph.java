package com;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

class Graph {
    private int V;
    private static LinkedList<Integer>[] adj;

    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

    void DFSMain(int v, boolean visited[])
    {
        visited[v] = true;
        //System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSMain(n, visited);
        }
    }

    void DFS(int v)
    {
        boolean visited[] = new boolean[V];
        //System.out.println("DFS:");
        DFSMain(v, visited);
        //System.out.println();
    }

    void BFS(int s)
    {

            //System.out.println("BFS:");

            boolean visited[] = new boolean[V];

            LinkedList<Integer> queue = new LinkedList<>();

            visited[s] = true;
            queue.add(s);

            while (queue.size() != 0) {
                s = queue.poll();
                //System.out.print(s + " ");


                for (int n : adj[s]) {
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        //System.out.println();
    }

    public static void main(String args[])
    {

        FileReader fr = null;
        try {
            fr = new FileReader("graph5.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner sfile = new Scanner(fr);
        Scanner sout = new Scanner(System.in);

        if (sfile.hasNext()) {
            Graph g = new Graph(sfile.nextInt());

            while (sfile.hasNext()) {
                g.addEdge(sfile.nextInt(), sfile.nextInt());
            }

            //System.out.println("Enter the index of the node to start with:");
            //int n= sout.nextInt();

            double  DFStime=0, BFStime=0;

            //if (adj.length>n) {
            for (int n=0; n< adj.length;n++) {
                long start = System.nanoTime();
                g.BFS(n);
                long end = System.nanoTime();
                BFStime += (double) (end - start) / 1_000_000;
                //System.out.print("Elapsed Time: ");
                //System.out.println(String.format("%.6f ms", (double) (end - start) / 1_000_000));

                start = System.nanoTime();
                g.DFS(n);
                end = System.nanoTime();
                DFStime += (double) (end - start) / 1_000_000;
                //System.out.print("Elapsed Time: ");
                //System.out.println(String.format("%.6f ms", (double) (end - start) / 1_000_000));
            }
            System.out.println("BFS: "+String.format("%.6f ms", BFStime/adj.length));
            System.out.println("DFS: "+String.format("%.6f ms", DFStime/adj.length));
            //} else System.out.println("Error: There is no such vertex!");
        } else System.out.println("Error input in the file!");
    }
}