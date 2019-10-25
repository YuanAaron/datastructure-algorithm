package datastructure.manhuasuanfa;

public class LoopQueue {
    private int[] array;
    private int front;
    private int rear;

    public LoopQueue(int capacity) {
        this.array=new int[capacity];
    }

    public void enQueue(int element) throws Exception {
        if ((rear+1)%this.array.length==front) {
            throw new Exception("队列已满!");
        }

        array[rear]=element;
        rear=(rear+1)%this.array.length; //易错点
    }

    public int deQueue() throws Exception {
        if (front==rear) {
            throw new Exception("队列为空!");
        }

        int deQueueElement=this.array[front];
        front=(front+1)%this.array.length; //易错点
        return deQueueElement;
    }

    public void output() {
        for (int i=front;i!=rear;i=(i+1)%this.array.length) {
            System.out.print(this.array[i]+" ");
        }
    }

    public static void main(String[] args) throws Exception{
        LoopQueue myQueue = new LoopQueue(6);
        myQueue.enQueue(3);
        myQueue.enQueue(5);
        myQueue.enQueue(6);
        myQueue.enQueue(8);
        myQueue.enQueue(1);
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.enQueue(2);
        myQueue.enQueue(4);
        myQueue.enQueue(9);
        myQueue.output();
    }
}
