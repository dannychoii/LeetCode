class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var l = 0
        var r = numbers.lastIndex

        while (l <= r) {
            val sum = numbers[l] + numbers[r]
            if (sum == target) break
            else if (sum > target) r--
            else l++
        }
        return intArrayOf(l + 1, r + 1)
    }
}