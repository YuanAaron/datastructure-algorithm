package algorithm.chaoshen.leetcodesolution.array_1_TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class Solution {

    //方法一：暴力法，时间复杂度O(n^2) 空间复杂度O(1)
    public int[] twoSum1(int[] nums, int target) {
        for (int i=0;i<nums.length;i++) {
            for (int j=i+1;j<nums.length;j++) {
                if (nums[i]+nums[j]==target) {
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //方法二: 两遍哈希表，时间复杂度O(n),空间复杂度O(n),以空间换时间
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap();
        for (int i=0;i<nums.length;i++) {
            map.put(nums[i],i);
        }

        for (int i=0;i<nums.length;i++) {
            int tmp=target-nums[i];
            if (map.containsKey(tmp)&&map.get(tmp)!=i) {
                return new int[]{i,map.get(tmp)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    //方法三：一遍哈希表,时间复杂度O(n),空间复杂度O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap();
        for (int i=0;i<nums.length;i++) {
            int tmp=target-nums[i];
            if (map.containsKey(tmp)) {
                return new int[]{map.get(tmp),i};
            }
            map.put(nums[i],i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
//        int[] nums={3,3};
        int[] nums={2,11,7,15};
        Solution s=new Solution();
//        int[] res=s.twoSum(nums,6);
        int[] res=s.twoSum(nums,9);
        for (int i = 0; i <res.length ; i++) {
            System.out.println(res[i]);
        }
    }
}