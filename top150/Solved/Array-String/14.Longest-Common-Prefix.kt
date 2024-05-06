class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 1) return strs[0]
        val lcp = MutableList<Char?>(200) { null }
        val count = MutableList<Int?>(200) { 0 }
        var ans = ""

        for (i in 0..strs.lastIndex) {
            for ((index, char) in strs[i].withIndex()) {
                if (lcp[index] != null && lcp[index] != char) {
                    break
                }
                lcp[index] = lcp[index] ?: char
                count[index] = (count[index] ?: 0) + 1
            }
        }
        for (i in 0..lcp.lastIndex) {
            if (count[i] == strs.size) {
                ans += lcp[i]
            }
        }
        return ans
    }
}