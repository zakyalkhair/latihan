package DataStructure.ArrayStructure;

public class ArrayList{
    private int [] array;

    private int length; //length of array
    private int size; //number of content

    public ArrayList(int length){
        this.length=length;
        array = new int[this.length];
        this.size=0;
    }

    public void addFront(int data){
        addAtIndex(0, data);
    }

    public void addBack(int data){
        addAtIndex(this.size, data);
    }

    public void addAtIndex(int index, int data){
        if(this.length==this.size){
            this.length = this.length*2;

            int [] b = new int[this.length];

            for(int i=0;i<index;i++){
                b[i] = this.array[i];
            }

            b[index]=data;

            for(int i=index;i<size;i++){
                b[i+1] = this.array[i];
            }

            this.array=b;


        } else {
            for(int i=this.size;i>index;i--){
                array[i]=array[i-1];
            }
            array[index]=data;
        }
        this.size++;
    }

    public int removeFront(){
        removeFromIndex(0);
        //complete your code here
        return 0;
    }

    public int removeBack(){
        removeFromIndex(this.size);
        //complete your code here
        return this.size;
    }

    public int removeFromIndex(int index){
        int temp = this.array[index];
        for (int i=index;i<this.size;i++){
            this.array[i] =this.array[i+1];
        }
        this.size--;
        //complete your code here
        return temp;
    }



    public String toString(){
        String o="";
        for(int i=0;i<this.size;i++){
            o+=this.array[i]+ " ";
        }
        return o;
    }
    public static void main(String[] args) {
        ArrayList myData = new ArrayList(7);
        myData.addFront(10);
        myData.addFront(20);
        myData.addFront(30);
        myData.addBack(100);
        myData.addAtIndex(1, 200);
        myData.addAtIndex(3, 99);
        myData.addBack(1000);
        myData.addFront(88);
        myData.addAtIndex(5, 111);
        myData.removeFront();
        myData.removeBack();
        myData.removeFromIndex(2);


        System.out.println(myData);
    }



}