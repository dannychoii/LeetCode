class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val ans = mutableListOf<String>()
        backTrack(n, n, "", ans)
        return ans
    }

    fun backTrack(left: Int, right: Int, current: String, ans: MutableList<String>) {
        if (left == 0 && right == 0) {
            ans.add(current)
        } else {
            if (left >= 1) {
                backTrack(left - 1, right, current + "(", ans)
            }
            if (right > left && right >= 1) {
                backTrack(left, right - 1, current + ")", ans)
            }
        }
    }

}