package Praktikum.Gas;

import java.util.*;

class TravelPlan {
    void cheapestRoute(int[][] graphMatrix, String[] label, int start) {
        LinkedList<Integer> visited = new LinkedList<Integer>();
        PriorityQueue<Integer> waiting = new PriorityQueue<Integer>();
        int[] distance = new int[graphMatrix.length];
        int[] prev = new int[graphMatrix.length];


        for (int i = 0; i < graphMatrix.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            prev[i] = -1;
        }
        distance[start] = 0;
        waiting.add(start);
        while (!waiting.isEmpty()) {
            int now = waiting.poll();
            visited.add(now);
            int value = distance[now];
            for (int i = 0; i < graphMatrix[now].length; i++) {
                if (graphMatrix[now][i] != 0) {
                    if (!visited.contains(i)) {
                        waiting.add(i);
                    }
                    if (graphMatrix[now][i] + value < distance[i]) {
                        distance[i] = graphMatrix[now][i] + value;
                        prev[i] = now;
                    }
                }
            }
        }
        for (int i = 0; i < label.length; i++) {
            System.out.print("Path: ");
            LinkedList<String> path = new LinkedList<>();
            int currentNode = i;
            while (currentNode != -1) {
                path.addFirst(label[currentNode]);
                currentNode = prev[currentNode];
            }
            for (int j = 0; j < path.size(); j++) {
                if (j > 0) {
                    System.out.print(" --> ");
                }
                System.out.print(path.get(j));
            }
            System.out.println();
            System.out.println("Cost: " + distance[i]);
            System.out.println();
        }
    }
}
