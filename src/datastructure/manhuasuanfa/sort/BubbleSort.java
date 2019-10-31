package datastructure.manhuasuanfa.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort1(int[] array) {
        for (int i=0;i<array.length-1;i++) { //循环次数
            for (int j=0;j<array.length-i-1;j++) { //每次循环的冒泡处理
                int tmp=0;
                if (array[j]>array[j+1]) {
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }
    }

    public static void bubbleSort2(int[] array) {
        for (int i=0;i<array.length-1;i++) { //循环次数
            boolean isSorted=true; //有序标记
            for (int j=0;j<array.length-i-1;j++) { //每次循环的冒泡处理
                int tmp=0;
                if (array[j]>array[j+1]) {
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    isSorted=false; //因为有元素交换，数组无序
                }
            }

            if (isSorted) {
                break;
            }
        }
    }

    public static void bubbleSort3(int[] array) {
        int lastExchangeIndex=0; //最后一次交换的位置
        int sortBorder=array.length-1; //无序边界，只需要比较到这里即可

        for (int i=0;i<array.length-1;i++) { //循环次数
            boolean isSorted=true; //有序标记
            for (int j=0;j<sortBorder;j++) { //每次循环的冒泡处理
                int tmp=0;
                if (array[j]>array[j+1]) {
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    isSorted=false; //因为有元素交换，数组无序
                    lastExchangeIndex=j;
                }
            }

            sortBorder=lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    //原始鸡尾酒排序
    public static void bubbleSort4(int[] array) {
        int tmp=0;
        for (int i=0;i<array.length/2;i++) { //循环次数
            boolean isSorted=true; //有序标记
            //奇数轮，从左向右比较和交换
            for (int j=i;j<array.length-i-1;j++) { //每次循环的冒泡处理
                if (array[j]>array[j+1]) {
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    isSorted=false; //因为有元素交换，数组无序
                }
            }

            if (isSorted) {
                break;
            }

            isSorted=true; //有序标记
            //偶数轮，从右向左比较和交换
            for (int j=array.length-i-1;j>i;j--) { //每次循环的冒泡处理
                if (array[j]<array[j-1]) {
                    tmp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=tmp;
                    isSorted=false; //因为有元素交换，数组无序
                }
            }

            if (isSorted) {
                break;
            }
        }
    }

    //基于有序区优化的鸡尾酒排序
    public static void bubbleSort5(int[] array) {
        int lastExchangeIndex=0; //最后一次交换的位置
        int sortRightBorder=array.length-1; //无序右边界，只需要比较到这里即可
        int sortLeftBorder=0; //无序左边界，只需比较到这里即可

        int tmp=0;
        for (int i=0;i<array.length/2;i++) { //循环次数
            boolean isSorted=true; //有序标记
            //奇数轮，从左向右比较和交换
            for (int j=sortLeftBorder;j<sortRightBorder;j++) { //每次循环的冒泡处理
                if (array[j]>array[j+1]) {
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    isSorted=false; //因为有元素交换，数组无序
                    lastExchangeIndex=j;
                }
            }
            sortRightBorder=lastExchangeIndex;
            if (isSorted) {
                break;
            }

            isSorted=true; //有序标记
            //偶数轮，从右向左比较和交换
            for (int j=sortRightBorder;j>sortLeftBorder;j--) { //每次循环的冒泡处理
                if (array[j]<array[j-1]) {
                    tmp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=tmp;
                    isSorted=false; //因为有元素交换，数组无序
                    lastExchangeIndex=j;
                }
            }
            sortLeftBorder=lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{5,8,6,3,9,2,1,7};
//        int[] array = new int[]{2,3,4,5,6,7,8,1};
        //bubbleSort(array);
        //bubbleSort2(array);
        //bubbleSort3(array);
        //bubbleSort4(array);
        bubbleSort5(array);
        System.out.println(Arrays.toString(array));
    }
}
