class Solution(object):
    def twoSum(self, nums, target):
        hash_map={}
        for i,x in enumerate(nums):
            tmp=target-x
            if tmp in hash_map:
                return [hash_map[tmp],i]
            else:
                hash_map[x]=i

