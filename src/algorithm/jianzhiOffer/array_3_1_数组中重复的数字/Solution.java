package algorithm.jianzhiOffer.array_3_1_数组中重复的数字;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.nowcoder.com/questionTerminal/623a5ac0ea5b4e5f95552655361ae0a8
 */
public class Solution {

    //解法一：暴力法，时间复杂度O(n^2),空间复杂度O(1)
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        if (numbers==null || length<=0) {
            return false;
        }

        for (int i=0;i<length;i++) {
            if (numbers[i]<0 || numbers[0]>length-1)
                return false;
        }

        for (int i=0;i<length;i++) {
            for (int j=i+1;j<length;j++) {
                if (numbers[i]==numbers[j]) {
                    duplication[0]=numbers[i];
                    return true;
                }
            }
        }
        return false;
    }

    //解法二：两遍哈希表，时间复杂度O(n),空间复杂度O(n)
    public boolean duplicate2(int numbers[],int length,int [] duplication) {
        if (numbers==null || length<=0) {
            return false;
        }

        for (int i=0;i<length;i++) {
            if (numbers[i]<0 || numbers[0]>length-1)
                return false;
        }

        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<length;i++) {
            map.put(numbers[i],i);
        }

        for (int i=0;i<length;i++) {
            if (map.containsKey(numbers[i])&&map.get(numbers[i])!=i) {
                duplication[0]=numbers[i];
                return true;
            }
        }
        return false;
    }

    //解法三：一遍哈希表，时间复杂度O(n),空间复杂度O(n)
    public boolean duplicate3(int numbers[],int length,int [] duplication) {
        if (numbers==null || length<=0) {
            return false;
        }

        for (int i=0;i<length;i++) {
            if (numbers[i]<0 || numbers[0]>length-1)
                return false;
        }

        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<length;i++) {
            if (map.containsKey(numbers[i])) {
                duplication[0]=numbers[i];
                return true;
            } else {
                map.put(numbers[i],i);
            }
        }
        return false;
    }

    //解法四：时间复杂度O(n),空间复杂度O(n)
    public boolean duplicate4(int numbers[],int length,int [] duplication) {
        if (numbers==null || length<=0) {
            return false;
        }

        for (int i=0;i<length;i++) {
            if (numbers[i]<0 || numbers[0]>length-1)
                return false;
        }

        int[] count=new int[length];
        for (int i=0;i<length;i++) {
            count[numbers[i]]++;
        }

        for (int i=0;i<length;i++) {
            if (count[i]>1) {
                duplication[0]=numbers[i];
                return true;
            }
        }

        return false;
    }

    //解法五：时间复杂度O(n),空间复杂度O(n)
    public boolean duplicate5(int numbers[],int length,int [] duplication) {
        if (numbers==null || length<=0) {
            return false;
        }

        for (int i=0;i<length;i++) {
            if (numbers[i]<0 || numbers[0]>length-1)
                return false;
        }

        int[] count=new int[length];
        for (int i=0;i<length;i++) {
            if (count[numbers[i]]==1) {
                duplication[0]=numbers[i];
                return true;
            } else {
                count[numbers[i]]++;
            }
        }

        return false;
    }

    //解法六：排序，时间复杂度O(nlogn),空间复杂度O(1)
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers==null || length<=0) {
            return false;
        }

        for (int i=0;i<length;i++) {
            if (numbers[i]<0 || numbers[0]>length-1)
                return false;
        }

        Arrays.sort(numbers);
        for (int i=0;i<length-1;i++) {
            if (numbers[i]==numbers[i+1]) {
                duplication[0]=numbers[i];
                return true;
            }
        }

        return false;
    }

    //解法七：利用特性，时间复杂度O(n) 空间复杂度O(1),此解为最优解
    public boolean duplicate7(int numbers[],int length,int [] duplication) {
        if (numbers==null || length<=0) {
            return false;
        }

        for (int i=0;i<length;i++) {
            if (numbers[i]<0 || numbers[0]>length-1)
                return false;
        }

        for (int i=0;i<length;i++) {
            while (numbers[i]!=i) {
                if (numbers[i]==numbers[numbers[i]]) {
                    duplication[0]=numbers[i];
                    return true;
                }else {
                    //交换numbers[i]和numbers[numbers[i]]
                    int tmp=numbers[i];
                    numbers[i]=numbers[tmp];
                    numbers[tmp]=tmp;
                }
            }
        }

        return false;
    }

    //https://www.nowcoder.com/questionTerminal/0b5ae9c4a8c546f79e2547c0179bfdc2
}
