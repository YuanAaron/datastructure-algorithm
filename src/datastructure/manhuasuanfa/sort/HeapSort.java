package datastructure.manhuasuanfa.sort;

import java.util.Arrays;

public class HeapSort {

    //堆排序（升序）
    public static void heapSort(int[] array) {
        //1、把无序数组构建成大顶堆
        buildHeap(array);
        System.out.println(Arrays.toString(array));

        //2、循环删除堆顶元素
        for (int i=array.length-1;i>0;i--) {
            //交换最后一个元素和第一个元素
            int t=array[i];
            array[i]=array[0];
            array[0]=t;
            //“下沉”调整最大堆
            downAdjust(array,0,i);
        }
    }

    //构建堆
    public static void buildHeap(int[] array) {
        //从最后一个非叶子节点开始，依次做“下沉”调整
        //最后一个非叶子节点：2*i+2<length
        for (int i=(array.length-2)/2;i>=0;i--) {
            downAdjust(array,i,array.length);
        }
    }

    /**
     * 下沉调整（对应删除或构建操作）
     * @param array 待调整的堆
     * @param parentIndex 要下沉的父节点(非叶子节点)
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array,int parentIndex,int length) {
        int tmp=array[parentIndex];
        int childIndex=2*parentIndex+1;//堆的非叶子节点一定有左孩子
        while(childIndex<length) {
            //如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex+1<length && array[childIndex+1]>array[childIndex])
                childIndex++;

            //如果父节点大于较大孩子的值，则直接跳出
            if (tmp>=array[childIndex])
                break;

            array[parentIndex]=array[childIndex];
            parentIndex=childIndex;
            childIndex=2*parentIndex+1;
        }
        array[parentIndex]=tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
