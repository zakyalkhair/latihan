package Praktikum.Gas;
// method dijkstra
import java.util.*;

public class Delivery {
    public static int[] djikstra(int[][] costMatrix, int start) {
        // Section 1: 5 menit
        //simpan node jalan yang sudah dikunjungi
        LinkedList<Integer> visited = new LinkedList<Integer>();
        //pastikan node dengan jarak terpendek diproses lebih dulu
        PriorityQueue<Integer> waiting = new PriorityQueue<Integer>();
        //simpan jarak minimum dari node awal (start) ke setiap node lain
        int[] distance = new int[costMatrix.length];

        // Section 2: 5 menit (maks. 10 menit)
        //inisialisasi jarak, menandai semua node sebagai belum terjangkau (value tak hingga) kecuali node start
        for (int i = 0; i < costMatrix.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0; //jarak ke diri sendiri

        // Section 3: 10 menit (maks. 15 menit)
        //tambah node start ke queue
        waiting.add(start);
        //proses node dalam antrian
        while(!waiting.isEmpty()){
            int now = waiting.poll();
            visited.add(now);

            int value = distance[now];
            for (int i = 0;i<costMatrix[now].length;i++){
                if(costMatrix[now][i]!=0){
                    if(!visited.contains(i)) waiting.add(i);
                    if(costMatrix[now][i] + value < distance[i]) distance[i] = costMatrix[now][i] + value;
                }
            }
        }

        // return jarak
        return distance;
    }
}