// 매우 간단
class Solution {
    fun hammingWeight(n: Int): Int {
        var ans = 0
        var temp = n
        while (temp > 0) {
            val remainder = temp % 2
            if (remainder == 1) ans++
            temp = (temp - remainder) / 2
        }
        return ans
    }
}