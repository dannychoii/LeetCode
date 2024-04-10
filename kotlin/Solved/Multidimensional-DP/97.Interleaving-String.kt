// 중간까지 연산의 결과를 matrix에 저장하면 시간을 아낄 수 있다.
class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val matrix = Array(s1.length + 1) { Array(s2.length + 1) { false } }
        if (s3.isEmpty()) {
            return s1.isEmpty() && s2.isEmpty()
        }
        fun dfs(i: Int, j: Int, level: Int): Boolean {
            if (level == s3.length) {
                return i == s1.lastIndex && j == s2.lastIndex
            } else {
                if (matrix[i + 1][j + 1]) return false
                if (s3[level] == s1.getOrNull(i + 1)) {
                    val result = dfs(i + 1, j, level + 1)
                    if (result) return true
                }
                if (s3[level] == s2.getOrNull(j + 1)) {
                    val result = dfs(i, j + 1, level + 1)
                    if (result) return true
                }
                matrix[i + 1][j + 1] = true
                return false
            }
        }
        return dfs(-1, -1, 0)
    }
}