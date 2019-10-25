package datastructure.manhuasuanfa;

public class MyLinkedList {
    private static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data=data;
        }
    }

    private Node head; //指向头节点的指针
    private Node last; //指向尾节点的指针(为了尾部插入的方便，额外增加了指向链表尾节点的指针)
    private int size; //链表实际长度

    public MyLinkedList() {
        this.head=null;
        this.last=null;
        this.size=0;
    }

    public void insert(int index,int data) throws Exception {
        if (index<0 || index>size) {
            throw new IndexOutOfBoundsException("超出链表节点范围!");
        }

        Node node=new Node(data);
        if (size==0) {
            //空链表
            head=node;
            last=node;
        }else if (index==0) {
            //头部插入
            node.next=head;
            head=node;
        }else if (index==size) {
            //尾部插入
            last.next=node;
            last=node;
        }else {
            //中间插入
            Node prev=get(index-1); //关键：找到index的前一个节点
            node.next=prev.next;
            prev.next=node;
        }
        size++;
    }

    //查找节点
    public Node get(int index) throws Exception {
        if (index<0 || index >=size) {
            throw new IndexOutOfBoundsException("超出链表节点范围!");
        }

        Node cur=head;
        for (int i=0;i<index;i++) {
            cur=cur.next;
        }
        return cur;
    }

    public Node remove(int index) throws Exception {
        if (index<0 || index>=size) {
            throw new IndexOutOfBoundsException("超出链表节点范围!");
        }

        Node removedNode=null;
        if (index==0) {
            //删除头节点
            removedNode=head; //返回值
            head=head.next;
        } else if(index==size-1) {
            //删除尾节点
            Node prev=get(index-1);
            removedNode=prev.next; //返回值
            prev.next=null;
            last=prev;
        } else {
            //删除中间节点
            Node prev=get(index-1);
            removedNode=prev.next;
            prev.next=prev.next.next;
        }
        size--;
        return removedNode;
    }

    //输出链表
    public void output() {
        Node cur=head;
        while (cur!=null) {
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
    }

    public static void main(String[] args) throws Exception {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(0,3);
        myLinkedList.output();
        System.out.println();

        myLinkedList.insert(0,4);
        myLinkedList.output();
        System.out.println();

        myLinkedList.insert(2,9);
        myLinkedList.output();
        System.out.println();

        myLinkedList.insert(3,5);
        myLinkedList.output();
        System.out.println();

        myLinkedList.insert(1,6);
        myLinkedList.output();
        System.out.println();

        myLinkedList.remove(0);
        myLinkedList.output();
    }
}
