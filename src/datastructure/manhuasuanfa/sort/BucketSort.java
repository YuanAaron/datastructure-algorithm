package datastructure.manhuasuanfa.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {

    public static double[] bucketSort(double[] array) {
        //1、得到数组的最大值和最小值
        double max=array[0];
        double min=array[0];
        for (int i=1;i<array.length;i++) {
            if (array[i]>max) {
                max=array[i];
            }

            if (array[i]<min) {
                min=array[i];
            }
        }

        //2、初始化桶
        int bucketNum=array.length;
        //所有的桶都保存在ArrayList中，每个桶被定义成一个链表LinkedList<Double>,以便于在尾部插入元素。
        ArrayList<LinkedList<Double>> bucketList=new ArrayList<>(bucketNum);
        for (int i=0;i<bucketNum;i++) {
            bucketList.add(new LinkedList<>());
        }

        //3、遍历原始数组，将每个元素放入对应桶中
        for (int i=0;i<array.length;i++) {
            //array[i]所在桶的下标
            int num=(int)((array[i]-min)*(bucketNum-1)/(max-min));
            bucketList.get(num).add(array[i]);
        }

        //4、对每个桶内元素进行排序
        for (int i = 0; i <bucketList.size() ; i++) {
            //JDK底层用了归并排序或归并的优化版本对桶内元素进行排序
            Collections.sort(bucketList.get(i));
        }

        //5、输出全部元素
        double[] sortedArray=new double[array.length];
        int index=0;
        for (LinkedList<Double> list : bucketList) {
            for (double element : list) {
                sortedArray[index++]=element;
            }
        }

        return sortedArray;
    }

    public static void main(String[] args) {
        double[] array = new double[]{4.12,6.421,0.0023,3.0,2.123,8.122,4.12, 10.09};
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
