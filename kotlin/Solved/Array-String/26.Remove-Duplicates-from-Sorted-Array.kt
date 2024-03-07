class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var index = 0
        val duplicateMap = mutableMapOf<Int, Int>()

        for (i in 0..nums.size - 1) {
            if (duplicateMap.get(nums[i]) == null) {
                duplicateMap[nums[i]] = 1
                nums[index++] = nums[i]
            }
        }
        return duplicateMap.keys.size
    }
}