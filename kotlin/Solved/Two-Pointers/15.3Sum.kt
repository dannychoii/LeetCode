class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val ans = mutableSetOf<List<Int>>()
        nums.sort()
        for (i in 0..nums.lastIndex - 2) {
            var l = i + 1
            var r = nums.lastIndex
            while (l < r) {
                val sum = nums[i] + nums[l] + nums[r]
                if (sum == 0) {
                    ans.add(listOf(nums[i], nums[l], nums[r]))
                    l++
                    r--
                } else if (sum < 0) {
                    l += 1
                } else {
                    r -= 1
                }
            }
        }
        return ans.toList()
    }
}