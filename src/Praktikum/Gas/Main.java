package Praktikum.Gas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        optionalTask();
    }

    public static void task1(){
        // Section 4: 5 mennit
        //read file input
        Scanner sc = new Scanner(Main.class.getResourceAsStream("delivery.txt"));

        // Input jumlah streets
        int N = sc.nextInt();

        // Section 5: 5 menit (maks. 10 menit)
        // Input matriks jarak antarjalan NxN
        int[][] T = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                T[i][j] = sc.nextInt();
            }
        }

        // Input jumlah skenario
        int M = sc.nextInt();

        // Proses semua skenario
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt(); // Restoran
            int G = sc.nextInt() ;// Gas station
            int D = sc.nextInt(); // Destination

            // Simpan semua jarak dari jalan S
            int[] distanceS = Delivery.djikstra(T, S);
            // hotung jarak restoran -> gas station
            int distSG = distanceS[G];
            //hitung jarak gas station -> destination
            int distGD = Delivery.djikstra(T,G)[D];
            //hitung jarak original = S -> G -> D
            int jarakOriginal = distSG + distGD;

            // Hitung jarak optimal = S -> D
            int jarakOptimal = distanceS[D];

            // Output hasil
            System.out.println(jarakOriginal + " " + (jarakOriginal - jarakOptimal));
        }
    }

    public static void task2(){
        int size = 7; // Number of cities/nodes
        String[] labels = {"A", "B", "C", "D", "E", "F", "G"}; // Labels for the cities

        Graph graph = new Graph(size);

        // Adding edges based on the graph image
        graph.addEdge(0, 1, 10); // A-B
        graph.addEdge(0, 2, 15); // A-C
        graph.addEdge(1, 5, 15); // B-F
        graph.addEdge(1, 3, 12); // B-D
        graph.addEdge(2, 4, 10); // C-E
        graph.addEdge(3, 4, 2);  // D-E
        graph.addEdge(3, 6, 18); // D-G
        graph.addEdge(3, 5, 1); // D-F
        graph.addEdge(4, 5, 5);  // E-F
        graph.addEdge(4, 6, 5);  // E-G
        graph.addEdge(5, 6, 7);  // F-G

        TravelPlan travel = new TravelPlan();
        String[] label = {"A", "B", "C", "D", "E", "F", "G"};
        travel.cheapestRoute(graph.getGraphMatrix(),label, 0);
    }
    public static void optionalTask(){
        WeightedGraphAL graph = new WeightedGraphAL();

        // Adding edges as per your example
        graph.addEdge("A", "B", 10);
        graph.addEdge("A", "C", 2);
        graph.addEdge("A", "D", 8);
        graph.addEdge("B", "A", 10);
        graph.addEdge("B", "E", 8);
        graph.addEdge("B", "G", 10);
        graph.addEdge("C", "A", 2);
        graph.addEdge("C", "D", 5);
        graph.addEdge("C", "F", 8);
        graph.addEdge("D", "A", 8);
        graph.addEdge("D", "C", 5);
        graph.addEdge("D", "G", 7);
        graph.addEdge("E", "B", 8);
        graph.addEdge("E", "H", 7);
        graph.addEdge("F", "C", 8);
        graph.addEdge("F", "I", 10);
        graph.addEdge("G", "B", 10);
        graph.addEdge("G", "D", 7);
        graph.addEdge("G", "H", 10);
        graph.addEdge("G", "I", 3);
        graph.addEdge("H", "E", 7);
        graph.addEdge("H", "G", 10);
        graph.addEdge("H", "I", 5);
        graph.addEdge("I", "F", 10);
        graph.addEdge("I", "G", 3);
        graph.addEdge("I", "H", 5);

        System.out.println(graph);

        // Find the shortest path
        graph.dijkstra("A", "H");
    }

}
