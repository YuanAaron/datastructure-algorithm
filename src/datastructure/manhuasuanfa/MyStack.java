package datastructure.manhuasuanfa;

public class MyStack {
    private MyArray myArray;

    public MyStack(int capacity) {
        this.myArray=new MyArray(capacity);
    }

    public MyStack() {
        this.myArray=new MyArray();
    }

    public void push(int num) throws Exception{
        this.myArray.insertLast(num);
    }

    public int pop() throws Exception{
        return this.myArray.deleteLast();
    }

    public int peek() {
        return this.myArray.getLast();
    }

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        sb.append("Stack: [");
        for (int i=0;i<this.myArray.getSize();i++) {
            sb.append(this.myArray.get(i));
            if (i!=this.myArray.getSize()-1) {
                sb.append(", ");
            }
        }
        sb.append("] top");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception{
        MyStack stack=new MyStack();
        for (int i=0;i<5;i++) {
            stack.push(i);
            System.out.println(stack);
            System.out.println(stack.peek());
        }

        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
    }
}