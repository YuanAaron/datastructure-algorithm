package datastructure.manhuasuanfa;

public class MyArray {
    private int[] array;
    private int size;

    public MyArray(int Capacity) {
        this.array=new int[Capacity];
        this.size=0;
    }

    public MyArray() {
        this(10);
    }

    public int getSize() {
        return this.size;
    }

    public int getLast() {
        return this.array[this.size-1];
    }

    public int get(int index) {
        if (index<0 || index>=size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }
        return array[index];
    }

    public void insertLast(int element) throws Exception {
        insert(this.size,element);
    }

    public void insert(int index,int element) throws Exception {
        //判断访问下标是否超出范围
        if (index<0 || index>size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }

        //实际元素达到数组容量上限，对数组进行扩容
        if (size>=this.array.length) {
            resize();
        }

        //从右向左循环，将元素逐个向右移动1位
        for (int i=size-1;i>=index;i--) {
            array[i+1]=array[i];
        }

        //腾出的位置放入新元素
        array[index]=element;
        size++;
    }

    private void resize() {
       int[] newArray=new int[array.length*2];
       System.arraycopy(this.array,0,newArray,0,this.array.length);
       this.array=newArray;
       System.out.println(this.array.length);
    }

    public int deleteLast() throws Exception {
        return delete(this.size-1);
    }

    public int delete(int index) throws Exception {
        //判断访问下标是否超出范围
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }
        int deletedElement = array[index];
        //从左向右循环，逐个元素向左挪一位。
        for (int i=index+1;i<size;i++) {
            array[i-1]=array[i];
        }
        size--;
        return deletedElement;
    }

    //输出数组
    public void output() {
        for (int i = 0; i <size ; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args) throws Exception{
        MyArray myArray = new MyArray(4);
        myArray.insert(0,1); //头插
        myArray.output();
        System.out.println();

        myArray.insert(1,2);
        myArray.output();
        System.out.println();

        myArray.insert(2,3);
        myArray.output();
        System.out.println();

        myArray.insert(3,4);
        myArray.output();
        System.out.println();

        myArray.insert(1,5);
        myArray.output();
        System.out.println();

        myArray.insert(5,6); //尾插
        myArray.output();
        System.out.println();

        myArray.delete(3);
        myArray.output();
    }
}

