class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }
        var zz = mutableListOf<MutableList<Char>>()
        for (i in 1..numRows) {
            zz.add(mutableListOf<Char>())
        }
        var counter = 0
        var isAddition = true
        for (i in 0..s.lastIndex) {
            zz[counter].add(s[i])
            if (isAddition) counter++ else counter--
            if (counter % (numRows - 1) == 0) {
                isAddition = (!isAddition)
            }
        }
        var ans = ""
        for (i in 0..numRows - 1) {
            ans += zz[i].joinToString("")
        }
        return ans
    }
}