class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        // robPlanArray[i] is maximum money achieved when given 0 to ith nums
        val robPlanArray = Array<Int>(nums.size) { 0 }
        robPlanArray[0] = nums[0]
        robPlanArray[1] = max(nums[0], nums[1])

        for (i in 2..nums.lastIndex) {
            robPlanArray[i] = max(robPlanArray[i - 2] + nums[i], robPlanArray[i - 1])
        }
        return robPlanArray[nums.lastIndex]
    }
}