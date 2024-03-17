class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.size == 0) return listOf<String>()
        if (nums.size == 1) return listOf(nums[0].toString())
        val ans = mutableListOf<String>()
        var base = nums[0]
        var diff = nums[0]
        for ((i, v) in nums.withIndex()) {
            if (v - i == diff) {
            } else {
                if (base == nums[i - 1]) {
                    ans.add("${base}")
                } else {
                    ans.add("${base}->${nums[i - 1]}")
                }
                base = nums[i]
                diff = v - i
            }

            if (i == nums.lastIndex) {
                if (base == nums[i]) {
                    ans.add("${base}")
                } else {
                    ans.add("${base}->${nums[i]}")
                }
            }
        }
        return ans
    }
}