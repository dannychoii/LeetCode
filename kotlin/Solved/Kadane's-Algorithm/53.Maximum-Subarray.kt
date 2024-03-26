// runningReduce 의 인자는 cumulative, element 로 구성
class Solution {
    fun maxSubArray(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        val cumList = nums.runningReduce { maxVal, v ->
            max(v, maxVal + v)
        }

        return cumList.max()
    }
}