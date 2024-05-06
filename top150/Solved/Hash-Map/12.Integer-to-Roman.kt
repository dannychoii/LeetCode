class Solution {
    fun intToRoman(num: Int): String {
        var n = num
        var ans = ""
        val map = mutableMapOf(
                (1000 to "M"),
                (900 to "CM"),
                (500 to "D"),
                (400 to "CD"),
                (100 to "C"),
                (90 to "XC"),
                (50 to "L"),
                (40 to "XL"),
                (10 to "X"),
                (9 to "IX"),
                (5 to "V"),
                (4 to "IV"),
                (1 to "I"),
        )

        while (n > 0) {
            for ((key, value) in map)
                if (key <= n) {
                    n -= key
                    ans += value
                    break
                }
        }
        return ans
    }
}