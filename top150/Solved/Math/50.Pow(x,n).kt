class Solution {
    fun myPow(x: Double, n: Int): Double {
        if (n == Int.MIN_VALUE) return myPow(1 / (x * x), Int.MAX_VALUE / 2 + 1)
        if (n < 0) return myPow(1 / x, -n)
        if (n == 0) return 1.0
        if (n == 1) return x

        return if (n % 2 == 0) myPow(x * x, n / 2) else x * myPow(x * x, n / 2)
    }
}