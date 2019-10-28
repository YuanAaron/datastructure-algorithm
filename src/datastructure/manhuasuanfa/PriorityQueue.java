package datastructure.manhuasuanfa;

import java.util.Arrays;

public class PriorityQueue {
    private int[] array;
    private int size; //队列有效元素个数

    public PriorityQueue() {
        //队列初始长度为32
        this.array=new int[32];
    }

    //入队
    public void enQueue(int element) {
        //队列长度超度范围，扩容
        if (size>=array.length)
            resize();

        this.array[size++]=element;
        upAdjust(this.array);
    }

    //出队
    public int deQueue() throws Exception {
        if (size<=0)
            throw new Exception("the queue is empty !");

        int head=array[0];
        //最后一个元素移到堆顶
        array[0]=array[--size];
        downAdjust();
        return head;
    }

    //队列扩容
    public void resize() {
        int newSize=2*this.array.length;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    /**
     * 上浮调整
     */
    public static void upAdjust(int[] array) {
        int childIndex=array.length-1;
        int parentIndex=(childIndex-1)/2;
        int tmp=array[childIndex]; //temp保存插入的叶子节点值，用于最后的赋值
        while (childIndex>0&tmp<array[parentIndex]) {
            //无需真正交换，单向赋值即可
            array[childIndex]=array[parentIndex];
            childIndex=parentIndex;
            parentIndex=(childIndex-1)/2;
        }
        array[childIndex]=tmp;
    }

    /**
     * 下沉调整
     */
    public void downAdjust() {
        int parentIndex=0;
        int tmp=this.array[parentIndex];
        int childIndex=1;//堆的非叶子节点一定有左孩子
        while(childIndex<size) {
            //如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex+1<size && array[childIndex+1]<array[childIndex])
                childIndex++;

            //如果父节点小于较小孩子的值，则直接跳出
            if (tmp<=array[childIndex])
                break;

            array[parentIndex]=array[childIndex];
            parentIndex=childIndex;
            childIndex=2*parentIndex+1;
        }
        array[parentIndex]=tmp;
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        System.out.println("出队元素：" + priorityQueue.deQueue());
        System.out.println("出队元素：" + priorityQueue.deQueue());
    }

}
