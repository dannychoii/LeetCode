class Solution {
    fun isHappy(n: Int): Boolean {
        val map = mutableMapOf<Int, Int>()
        var a = n
        while (true) {
            val b = next(a)
            if (map[b] != null) return false
            if (b == 1) return true
            map[a] = b
            a = b
        }
        return true
    }

    fun next(n: Int): Int {
        var a = n
        var sum = 0
        while (a >= 10) {
            sum += (a % 10) * (a % 10)
            a /= 10
        }
        sum += a * a
        return sum
    }
}