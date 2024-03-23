class Solution {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val charMap = mutableMapOf<Char, Int>()

        for (letter in magazine) {
            charMap[letter] = (charMap[letter] ?: 0) + 1
        }
        for (letter in ransomNote) {
            if (charMap[letter] ?: 0 == 0) return false
            charMap[letter] = (charMap[letter] ?: 0) - 1
        }
        return true
    }
}