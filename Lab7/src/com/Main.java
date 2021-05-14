package com;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FileWriter fwDS = new FileWriter("DiSparse.txt");
        FileWriter fwDD = new FileWriter("DiDense.txt");
        FileWriter fwFS = new FileWriter("FlSparse.txt");
        FileWriter fwFD = new FileWriter("FlDense.txt");

        double start;
        double end;
        double[] time; //0= SparseDi 1=DenseDi 2= SparseFlo 3=DenseFlo

        System.out.println("\t\t\t\t\tSparse\t\t\tDense");

        for (int j=10;j<=1010;j+=100) {

            time = new double[4];

            System.out.println("For V= " + j);

            for (int i = 0; i < 10; i++) {

                Graph graphSparse = new Graph(j, false);
                Graph graphDense = new Graph(j, true);

                start = System.nanoTime();
                //graphSparse.dijkstra(0);
                for (int m = 0; m < graphSparse.getNumberOfNodes(); m++)
                    graphSparse.dijkstra(m);
                end = System.nanoTime();
                time[0] += (end - start) / 1_000_000;

                start = System.nanoTime();
                //graphDense.dijkstra(0);
                for (int m = 0; m < graphDense.getNumberOfNodes(); m++)
                    graphDense.dijkstra(m);
                end = System.nanoTime();
                time[1] += (end - start) / 1_000_000;

                start = System.nanoTime();
                graphSparse.floyd();
                end = System.nanoTime();
                time[2] += (end - start) / 1_000_000;

                start = System.nanoTime();
                graphDense.floyd();
                end = System.nanoTime();
                time[3] += (end - start) / 1_000_000;

            }

            System.out.println("\t\t Dijkstra: \t" + String.format("%.4f ms\t\t", time[0] / 10) + String.format("%.4f ms", time[1] / 10));
            System.out.println("\t\t Floyd:    \t" + String.format("%.4f ms\t\t", time[2] / 10) + String.format("%.4f ms", time[3] / 10));
            fwDS.write(String.format("%.4f\n", time[0] / 10));
            fwDD.write(String.format("%.4f\n", time[1] / 10));
            fwFS.write(String.format("%.4f\n", time[2] / 10));
            fwFD.write(String.format("%.4f\n", time[3] / 10));

        }

        fwDD.close();
        fwDS.close();
        fwFD.close();
        fwFS.close();

    }
}