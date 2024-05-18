class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var ans = 0
        val map = mutableMapOf<Char, Int>()
        var i = 0
        var j = 0
        map[s[i]] = 1
        while (i <= j && j <= s.lastIndex) {
            if (j - i + 1 - map.values.max() > k) {
                map[s[i]] = (map[s[i]]!! - 1)
                i++
            } else {
                ans = maxOf(ans, j - i + 1)
                if (j == s.lastIndex) break
                j++
                map[s[j]] = (map[s[j]] ?: 0) + 1
            }
        }

        return ans
    }
}