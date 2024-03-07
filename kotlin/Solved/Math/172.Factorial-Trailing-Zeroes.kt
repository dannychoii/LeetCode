class Solution {
    fun trailingZeroes(n: Int): Int {
        var num = 5
        var ans = 0
        while (num <= n) {
            ans += n / num
            num *= 5
        }
        return ans
    }
}