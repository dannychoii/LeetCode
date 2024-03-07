class Solution {
    fun plusOne(digits: IntArray): IntArray {
        for (i in digits.lastIndex downTo 0) {
            digits[i] += 1
            digits[i] %= 10
            if (digits[i] != 0) return digits
        }

        val allZeroArray = IntArray(digits.size + 1) { 0 }
        allZeroArray[0] = 1
        return allZeroArray
    }
}