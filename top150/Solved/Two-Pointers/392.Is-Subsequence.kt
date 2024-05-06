class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.length == 0) return true
        var sPtr = 0
        val n = s.lastIndex
        for (letter in t) {
            if (letter == s[sPtr]) {
                sPtr++
                if (sPtr == n + 1) return true
            }
        }
        return false
    }
}