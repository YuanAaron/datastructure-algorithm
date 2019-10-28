package datastructure.manhuasuanfa;

import java.util.Arrays;

public class HeapOperator {

    /**
     * 上浮调整(对应插入操作）
     * @param array 待调整的堆
     */
    public static void upAdjust(int[] array) {
        int childIndex=array.length-1;
        int parentIndex=(childIndex-1)/2;
        while (childIndex>0&array[childIndex]<array[parentIndex]) {
            swap(array,childIndex,parentIndex);
            childIndex=parentIndex;
            parentIndex=(childIndex-1)/2;
        }
    }

    private static void swap(int[] array,int a,int b) {
        int t=array[a];
        array[a]=array[b];
        array[b]=t;
    }

//    /**
//     * 上浮调整(插入操作)优化:在父节点和孩子节点做连续交换时，并不一定要真的交换，只需要先把
//     * 交换一方的值存入tmp，做单向覆盖，循环结束后，再把temp的值存入交换后的最终位置即可
//     *
//     * @param array 待调整的堆
//     */
//    public static void upAdjust(int[] array) {
//        int childIndex=array.length-1;
//        int parentIndex=(childIndex-1)/2;
//        int tmp=array[childIndex]; //temp保存插入的叶子节点值，用于最后的赋值
//        while (childIndex>0&tmp<array[parentIndex]) {
//            //无需真正交换，单向赋值即可
//            array[childIndex]=array[parentIndex];
//            childIndex=parentIndex;
//            parentIndex=(childIndex-1)/2;
//        }
//        array[childIndex]=tmp;
//    }

    /**
     * 下沉调整（对应删除或构建操作）
     * @param array 待调整的堆
     * @param parentIndex 要下沉的父节点(非叶子节点)
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array,int parentIndex,int length) {
        int childIndex=2*parentIndex+1;//堆的非叶子节点一定有左孩子
        while(childIndex<length) {
            //如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex+1<length && array[childIndex+1]<array[childIndex])
                childIndex++;

            //如果父节点小于较小孩子的值，则直接跳出
            if (array[parentIndex]<=array[childIndex])
                break;

            swap(array,parentIndex,childIndex);
            parentIndex=childIndex;
            childIndex=2*parentIndex+1;
        }
    }

//    /**
//     * 下沉调整优化（对应删除或构建操作）
//     * @param array 待调整的堆
//     * @param parentIndex 要下沉的父节点(非叶子节点)
//     * @param length 堆的有效大小
//     */
//    public static void downAdjust(int[] array,int parentIndex,int length) {
//        int tmp=array[parentIndex];
//        int childIndex=2*parentIndex+1;//堆的非叶子节点一定有左孩子
//        while(childIndex<length) {
//            //如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
//            if (childIndex+1<length && array[childIndex+1]<array[childIndex])
//                childIndex++;
//
//            //如果父节点小于较小孩子的值，则直接跳出
//            if (tmp<=array[childIndex])
//                break;
//
//            array[parentIndex]=array[childIndex];
//            parentIndex=childIndex;
//            childIndex=2*parentIndex+1;
//        }
//        array[parentIndex]=tmp;
//    }

    //构建堆
    public static void buildHeap(int[] array) {
        //从最后一个非叶子节点开始，依次做“下沉”调整
        //最后一个非叶子节点：2*i+2<length
        for (int i=(array.length-2)/2;i>=0;i--) {
            downAdjust(array,i,array.length);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,3,2,6,5,7,8,9,10,0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {7,1,3,10,5,2,8,9,6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }

}
