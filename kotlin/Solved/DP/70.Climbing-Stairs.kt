class Solution {
    fun climbStairs(n: Int): Int {
        val list = Array<Int>(n + 1) { 0 }
        list[0] = 1
        list[1] = 1
        for (i in 2..n) {
            list[i] = list[i - 1] + list[i - 2]
        }
        return list[n]
    }
}