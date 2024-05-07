class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex
        while (l <= r) {
            val midPosition = (l + r) / 2
            val mid = nums[midPosition]
            if (mid == target) {
                return midPosition
            } else if (target > mid) {
                l = midPosition + 1
            } else {
                r = midPosition - 1
            }
        }
        return -1
    }
}