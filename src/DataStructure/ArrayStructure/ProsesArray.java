package DataStructure.ArrayStructure;

import java.util.Arrays;

public class ProsesArray {
    private int[] data;
    private int length;
    private int size;
    public ProsesArray(int length) {
        data = new int[length];
        this.size=0;
        this.length = length;
    }
    public void addFront(int x){
        for (int i = size; i > 0; i--) {
            this.data[i] = data[i - 1];
        }
        this.data[0] = x;
        this.size++;
    }
    public void addBack(int x){
        this.data[this.size] = x;
        this.size++;
    }
    public void addIndex(int index, int input) {
        if (this.length == size){
            this.length = this.length*2;
            int[] x = new int[this.length];
            for (int i = 0;i<this.length;i++)
                x[i] = this.data[i];
        }
        if (this.size < index){
            System.out.println("error");
        }
        else if (this.size == index){
            this.data[this.size] = input;
            this.size++;
        }
        else {
            for (int i = this.size; i > index; i--) {
                this.data[i] = this.data[i - 1];
            }
            this.data[index] = input;
            this.size++;
        }

    }

    public int[] getData() {
        return data;
    }

    public static void main(String[] args) {
        ProsesArray x = new ProsesArray(10);
        x.addFront(5);
        x.addFront(7);
        System.out.println(Arrays.toString(x.getData()));
        x.addIndex(1,10);
        System.out.println(Arrays.toString(x.getData()));

    }
}
