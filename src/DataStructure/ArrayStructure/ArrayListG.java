package DataStructure.ArrayStructure;

public class ArrayListG<Z>{
    private Z[] array;

    private int length; //length of array
    private int size; //number of content

    public ArrayListG(int length){
        this.length=length;
        array = (Z[]) new Object[this.length];
        this.size=0;
    }

    public void addFront(Z data){
        addAtIndex(0, data);
    }

    public void addBack(Z data){
        addAtIndex(this.size, data);
    }

    public void addAtIndex(int index, Z data){
        if(this.length==this.size){
            this.length = this.length*2;

            Z [] b = (Z[]) new Object[this.length];

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

    public Z removeFront(){
        return removeFromIndex(0);
        //complete your code here

    }

    public Z removeBack(){
        return removeFromIndex(this.size);
        //complete your code here
    }

    public Z removeFromIndex(int index){
        Z temp = this.array[index];
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



}