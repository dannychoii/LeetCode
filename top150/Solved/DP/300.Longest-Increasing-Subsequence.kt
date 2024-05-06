class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val arr = Array<Int>(nums.size) { 1 }
        for (i in 0..nums.lastIndex) {
            for (j in 0..i - 1) {
                if (nums[j] < nums[i]) {
                    arr[i] = max(arr[j] + 1, arr[i])
                }
            }
        }
        return arr.max()
    }
}