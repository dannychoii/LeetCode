class Solution {
    fun lengthOfLastWord(s: String): Int {
        var counter = 0
        var foundWord = false
        for (i in s.lastIndex downTo 0) {
            if (s[i].isLetter()) {
                counter++
                foundWord = true
            } else {
                if (foundWord) return counter else continue
            }
        }
        return counter
    }
}