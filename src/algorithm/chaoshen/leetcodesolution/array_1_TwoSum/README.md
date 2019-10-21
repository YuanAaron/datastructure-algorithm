# Two Sum

## Description
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
```
Given nums = [2, 7, 11, 15], target = 9,  
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

解析：

利用HashMap记录数组元素值和对应的下标，对于一个数 nums[i]，判断target - nums[i]是否存在HashMap中，

存在的话，返回两个下标组成的数组。注意：
+ target-nums[i]与nums[i]的下标不同；
+ 返回时，已存在的元素下标在前，当前元素下标在后。