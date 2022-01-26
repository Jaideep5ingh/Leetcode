package com.company.dataStructures.implementations;

public class Graphs {
    int V;
    int E;
    int[][] adjMatrix;

    public Graphs(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adjMatrix = new int[nodes][nodes];
    }

    //Undirected graph
    public void addEdge(int u, int v){
        this.adjMatrix[u][v] = 1;
        this.adjMatrix[v][u] = 1;
        this.E++;
    }

    public static void main(String[] args){
         Graphs graphs = new Graphs(4);
         graphs.addEdge(0,1);
         graphs.addEdge(0,3);
         graphs.addEdge(1,2);
         graphs.addEdge(2,3);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(graphs.adjMatrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println("Number of edges = " + graphs.E + " Number of vertices = " + graphs.V);
    }
}
