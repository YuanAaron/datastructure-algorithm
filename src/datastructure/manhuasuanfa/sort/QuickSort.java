package datastructure.manhuasuanfa.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class QuickSort {

    //quickSort1通过递归的方式，实现了分而治之的思想
    public static void quickSort1(int[] array,int startIndex,int endIndex) {
        //递归结束条件
        if (startIndex>=endIndex)
            return;

        //获取基准元素位置
//        int pivotIndex=partition1(array,startIndex,endIndex);
        int pivotIndex=partition2(array,startIndex,endIndex);
        //根据基准元素分成两部分，分别进行递归排序
        quickSort1(array,startIndex,pivotIndex-1);
        quickSort1(array,pivotIndex+1,endIndex);
    }

    //quickSort1通过递归的方式，实现了分而治之的思想
    public static void quickSort2(int[] array,int startIndex,int endIndex) {
        //用一个集合栈代替递归的函数栈
        Stack<Map<String,Integer>> quickSortStack=new Stack<>();
        //整个数组的起止下标以哈希的形式入栈
        Map<String,Integer> rootParam=new HashMap<>();
        rootParam.put("startIndex",startIndex);
        rootParam.put("endIndex",endIndex);
        quickSortStack.push(rootParam);

        while (!quickSortStack.isEmpty()) { //栈为空时，循环结束
            //栈顶元素出栈，得到起止下标
            Map<String,Integer> param=quickSortStack.pop();

            //获取基准元素位置
//            int pivotIndex=partition1(array,param.get("startIndex"),param.get("endIndex"));
            int pivotIndex=partition2(array,param.get("startIndex"),param.get("endIndex"));

            //根据基准元素分成两部分，每一部分起止下标进栈
            if (param.get("startIndex")<pivotIndex-1) {
                Map<String,Integer> leftParam=new HashMap<>();
                leftParam.put("startIndex",param.get("startIndex"));
                leftParam.put("endIndex",pivotIndex-1);
                quickSortStack.push(leftParam);
            }
            if (pivotIndex+1<param.get("endIndex")) {
                Map<String,Integer> rightParam=new HashMap<>();
                rightParam.put("startIndex",pivotIndex+1);
                rightParam.put("endIndex",param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }

    //每一轮使用双边循环法
    private static int partition1(int[] array,int startIndex,int endIndex) {
        //取首元素最为基准（也可以随机选择元素）
        int pivot=array[startIndex];
        int left=startIndex;
        int right=endIndex;
        //多次循环
        while (left!=right) {
            //控制right指针比较并左移
            while (left<right && array[right]>=pivot) { //我认为应该有=，书中没加
                right--;
            }

            //控制left指针比较并右移
            while (left<right && array[left]<=pivot) {
                left++;
            }

            //交换left和right指针所指向的元素
            if (left<right) {
                int t=array[left];
                array[left]=array[right];
                array[right]=t;
            }
        }

        //pivot和指针重合点指向的元素交换
        array[startIndex]=array[left];
        array[left]=pivot;

        return left;
    }

    //每一轮使用单边循环法
    private static int partition2(int[] array,int startIndex,int endIndex) {
        //取首元素最为基准（也可以随机选择元素）
        int pivot=array[startIndex];
        int mark=startIndex;

        for (int i=startIndex+1;i<=endIndex;i++) {
            if (array[i]<pivot) {
                mark++;
                int t=array[mark];
                array[mark]=array[i];
                array[i]=t;
            }
        }

        //pivot和mark指针执行的元素交换
        array[startIndex]=array[mark];
        array[mark]=pivot;

        return mark;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,4,6,5,3,2,8,1};
//        quickSort1(arr, 0, arr.length-1);
        quickSort2(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
