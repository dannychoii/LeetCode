class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var product = 1
        var ans = IntArray(nums.size) { 1 }
        for (i in 0..nums.lastIndex - 1) {
            product *= nums[i]
            ans[i + 1] *= product
        }

        product = 1
        for (i in nums.lastIndex downTo 1) {
            product *= nums[i]
            ans[i - 1] *= product
        }
        return ans
    }
}