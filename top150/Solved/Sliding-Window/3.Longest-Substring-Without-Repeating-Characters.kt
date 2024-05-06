class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = mutableSetOf<Char>()
        var start = 0
        var end = 0
        var ans = 0
        while (start <= end && end <= s.lastIndex) {
            if (!set.contains(s[end])) {
                set.add(s[end])
                end++
                ans = max(ans, set.size)
            } else {
                set.remove(s[start])
                start++
            }
        }
        return ans
    }
}