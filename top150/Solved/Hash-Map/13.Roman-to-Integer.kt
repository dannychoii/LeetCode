class Solution {
    fun romanToInt(s: String): Int {
        val score = mutableMapOf(
                'I' to 1,
                'V' to 5,
                'X' to 10,
                'L' to 50,
                'C' to 100,
                'D' to 500,
                'M' to 1000
        )

        val letters = mutableMapOf(
                "IV" to 4,
                "IX" to 9,
                "XL" to 40,
                "XC" to 90,
                "CD" to 400,
                "CM" to 900,
        )

        var ans = 0
        var i = 0
        while (i <= s.lastIndex) {
            if (i + 1 <= s.lastIndex) {
                val value = letters.get(s.substring(i, i + 2))
                if (value != null) {
                    ans += value
                    i += 2
                    continue
                }
            }
            ans += score[s[i]] ?: 0
            i++
        }
        return ans
    }
}