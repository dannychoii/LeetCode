class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val triangle = triangle.toMutableList().map { it.toMutableList() }
        for (i in triangle.lastIndex - 1 downTo 0) {
            for (j in 0..triangle[i].lastIndex) {
                val m = min(triangle[i + 1][j], triangle[i + 1][j + 1])
                triangle[i][j] += m
            }
        }
        return triangle[0][0]
    }
}