class Solution {
    fun isPalindrome(x: Int): Boolean {
        val word = x.toString()
        //.reversed()
        val n = x.toString().lastIndex

        for (index in 0..n / 2) {
            if (word[index] != word[n - index]) {
                return false
            }
        }
        return true
    }
}