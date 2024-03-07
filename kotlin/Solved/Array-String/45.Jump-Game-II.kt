class Solution {
    fun jump(nums: IntArray): Int {
        val n = nums.size
        val minJumpArr = Array<Int>(n) { Int.MAX_VALUE }
        minJumpArr[0] = 0
        for (i in 0..nums.lastIndex) {
            for (j in 1..nums[i]) {
                minJumpArr[(i + j) % n] = min(minJumpArr[i] + 1, minJumpArr[(i + j) % n])
            }
        }
        return minJumpArr.last()
    }
}