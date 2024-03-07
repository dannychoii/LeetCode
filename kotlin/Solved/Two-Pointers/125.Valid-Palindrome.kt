class Solution {
    fun isPalindrome(s: String): Boolean {
        var startPtr = 0
        var endPtr = s.lastIndex

        while (startPtr <= endPtr) {
            if (!s[startPtr].isLetterOrDigit()) {
                startPtr++
                continue
            }
            if (!s[endPtr].isLetterOrDigit()) {
                endPtr--
                continue
            }
            if (s[startPtr].uppercase() != s[endPtr].uppercase()) {
                return false
            }
            startPtr++
            endPtr--
        }
        return true
    }
}