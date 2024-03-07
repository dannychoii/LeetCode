class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val wordList = s.split(" ")
        val map = mutableMapOf<Char, String>()
        val map2 = mutableMapOf<String, Char>()
        if (wordList.size != pattern.length) return false

        for (index in 0..pattern.lastIndex) {
            if (map[pattern[index]] != null && map[pattern[index]] != wordList[index]) {
                return false
            }
            map[pattern[index]] = wordList[index]


            if (map2[wordList[index]] != null && map2[wordList[index]] != pattern[index]) {
                return false
            }
            map2[wordList[index]] = pattern[index]
        }
        return true
    }
}