class Solution {
    fun findPeakElement(nums: IntArray): Int {
        fun isPeak(i: Int): Int {
            val before = nums.getOrNull(i - 1) ?: Integer.MIN_VALUE
            val after = nums.getOrNull(i + 1) ?: Integer.MIN_VALUE
            if (nums[i] > before && nums[i] > after) return 0
            else if (after > before) {
                return 1
            } else {
                return -1
            }
        }

        var l = 0
        var r = nums.lastIndex
        while (l <= r) {
            val mid = (l + r) / 2
            when (isPeak(mid)) {
                0 -> return mid
                1 -> {
                    l = mid + 1
                }

                -1 -> {
                    r = mid - 1
                }
            }
        }
        return l
    }
}