package Praktikum.Gas;

import java.util.*;

class WeightedGraphAL {
    Map<String, List<Edge>> adjacencyList;

    WeightedGraphAL() {
        this.adjacencyList = new TreeMap<>();
    }

    void addEdge(String node1, String node2, int weight) {
        adjacencyList.putIfAbsent(node1, new ArrayList<>());
        adjacencyList.putIfAbsent(node2, new ArrayList<>());
        Edge edge = new Edge();
        edge.targetNode = node2;
        edge.weight = weight;
        adjacencyList.get(node1).add(edge);
    }

    @Override
    public String toString() {
        String result = "Weighted Graph Adjacency List:\n";
        for (String node : adjacencyList.keySet()) {
            result += node + " --> ";
            for (Edge edge : adjacencyList.get(node)) {
                result += edge.targetNode + "(" + edge.weight + ") ";
            }
            result += "\n";
        }
        return result;
    }

    public void dijkstra(String start, String end) {
        if (!adjacencyList.containsKey(start) || !adjacencyList.containsKey(end)) {
            System.out.println("Start or end node not in the graph.");
            return;
        }

        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());

        for (String node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(new AbstractMap.SimpleEntry<>(start, 0));

        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> current = pq.poll();
            String currentNode = current.getKey();

            if (currentNode.equals(end)) break;

            for (Edge edge : adjacencyList.getOrDefault(currentNode, new ArrayList<>())) {
                int newDist = distances.get(currentNode) + edge.weight;
                if (newDist < distances.get(edge.targetNode)) {
                    distances.put(edge.targetNode, newDist);
                    previous.put(edge.targetNode, currentNode);
                    pq.add(new AbstractMap.SimpleEntry<>(edge.targetNode, newDist));
                }
            }
        }

        LinkedList<String> path = new LinkedList<>();
        for (String at = end; at != null; at = previous.get(at)) {
            path.addFirst(at);
        }

        if (distances.get(end) == Integer.MAX_VALUE) {
            System.out.println("No path found");
        } else {
            System.out.println("Path: " + String.join(" --> ", path));
            System.out.println("Shortest distance from " + start + " to " + end + " = " + distances.get(end));
        }
    }
}
