class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var sum = nums[0]
        var ans = Integer.MAX_VALUE
        var i = 0
        var j = 0
        while (i <= j && j <= nums.lastIndex) {
            if (sum >= target) {
                ans = min(ans, j - i + 1)
                sum -= nums[i]
                i++
            } else {
                j++
                if (j > nums.lastIndex) break
                sum += nums[j]
            }
        }
        return if (ans == Integer.MAX_VALUE) 0 else ans
    }
}