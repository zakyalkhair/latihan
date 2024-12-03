package Praktikum.Gas;

import java.util.*;

class Graph{
    // Your code goes here
    int[][] matrix;
    int size;
    Graph(int size) {
        this.matrix = new int[size][size];
        this.size =size;
    }
    void addEdge(int vertex1, int vertex2, int value){
        this.matrix[vertex1][vertex2] = value;
        this.matrix[vertex2][vertex1] = value;
    }

    int[][] getGraphMatrix(){
        return this.matrix;
    }

}