// '2' -> 2 를 위해서는 toInt()로는 해결이 안된다.
// 우측하단부터 LCS를 수행했던 것과 달리 좌측상단으로부터 LCS를 시작하는 것이 포인트다.
class Solution {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        var ans = 0
        val m = matrix.size
        val n = matrix.first().size

        val mat = Array(m) {
            Array(n) { 0 }
        }
        for ((i, row) in matrix.withIndex()) {
            for ((j, ele) in row.withIndex()) {
                if (ele != '0') {
                    val minVal = minOf(
                        mat.getOrNull(i - 1)?.getOrNull(j - 1) ?: 0,
                        mat.getOrNull(i - 1)?.getOrNull(j) ?: 0,
                        mat.getOrNull(i)?.getOrNull(j - 1) ?: 0
                    ) + 1
                    ans = maxOf(ans, minVal)
                    mat[i][j] = minVal
                }
            }
        }
        return ans * ans
    }
}