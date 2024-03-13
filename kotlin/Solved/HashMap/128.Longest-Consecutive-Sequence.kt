// 1. check if element is start of the series
// 2. check how many elements are consecutive
class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()
        var ans = 0
        for (value in set) {
            if (set.contains(value - 1)) continue
            var counter = 0
            while (set.contains(value + counter)) {
                counter++
            }
            ans = max(ans, counter)
        }
        return ans
    }
}