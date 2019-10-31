package datastructure.manhuasuanfa.sort;

import java.util.Arrays;

public class CountSort {

    public static int[] countSort1(int[] array) {
        //1、获取数组的最大值
        int max=array[0];
        for (int i=1;i<array.length;i++) {
            if (array[i]>max) {
                max=array[i];
            }
        }

        //2、根据数组最大值确定统计数组的长度
        int[] countArray=new int[max+1];

        //3、遍历无序数组，填充统计数组
        for (int i=0;i<array.length;i++) {
            countArray[array[i]]++;
        }

        //4、遍历统计数组，输出结果
        int[] sortedArray=new int[array.length];
        int index=0;
        for (int i=0;i<countArray.length;i++) {
            for (int j=0;j<countArray[i];j++) {
                sortedArray[index++]=i;
            }
        }

        return sortedArray;
    }

    public static int[] countSort2(int[] array) {
        //1、得到数组的最大值和最小值，以确定统计数组的长度
        int max=array[0];
        int min=array[0];
        for (int i=1;i<array.length;i++) {
            if (array[i]>max) {
                max=array[i];
            }

            if (array[i]<min) {
                min=array[i];
            }
        }

        //2、创建统计数组并统计对应元素的个数
        int[] countArray=new int[max-min+1];
        for (int i=0;i<array.length;i++) {
            countArray[array[i]-min]++;
        }

        //3、统计数组做变形，后面的元素等于前面的元素之和
        for (int i=1;i<countArray.length;i++) {
            countArray[i]+=countArray[i-1];
        }

        //4、倒序遍历原始数组，从统计数组找到正确的位置，输出到结果数组
        int[] sortedArray=new int[array.length];
        for (int i=array.length-1;i>=0;i--) {
            sortedArray[countArray[array[i]-min]-1]=array[i];
            countArray[array[i]-min]--;
        }

        return sortedArray;
    }

    public static void main(String[] args) {
        int[] array = new int[] {4,4,6,5,3,2,8,1,7,5,6,0,10};
//        int[] sortedArray = countSort1(array);
        int[] sortedArray = countSort2(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
