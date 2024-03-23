class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for ((index, num) in nums.withIndex()) {
            if (map.containsKey(num)) {
                return intArrayOf(map[num]!!, index)
            }
            map[target - num] = index
        }
        return intArrayOf()
    }
}