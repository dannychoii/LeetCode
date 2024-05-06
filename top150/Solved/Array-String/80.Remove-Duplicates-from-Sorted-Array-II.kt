class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var pointer = 0
        var isDuplicate = mutableMapOf<Int, Int>()
        for ((index, value) in nums.withIndex()) {
            if (isDuplicate.get(value) == null) {
                isDuplicate[value] = 1
                nums[pointer++] = value
            } else if (isDuplicate.get(value) == 1) {
                isDuplicate[value] = 2
                nums[pointer++] = value
            } else {
            }
        }
        return pointer
    }
}