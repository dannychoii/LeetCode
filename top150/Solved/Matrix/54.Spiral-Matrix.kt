class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val moves = listOf(
                listOf(0, 1),
                listOf(1, 0),
                listOf(0, -1),
                listOf(-1, 0)
        )
        val m = matrix.size
        val n = matrix[0].size
        val ans = mutableListOf<Int>()

        var i = 0
        var j = 0
        var k = 0

        while (true) {
            if (matrix.getOrNull(i)?.getOrNull(j) ?: -101 == -101) break
            ans.add(matrix[i][j])
            matrix[i][j] = -101

            val nextCandidateI = i + moves[k][0]
            val nextCandidateJ = j + moves[k][1]
            if (nextCandidateI < 0 || nextCandidateI > m - 1 || nextCandidateJ < 0 || nextCandidateJ > n - 1) {
                k++
                k %= 4
            } else if (matrix[nextCandidateI][nextCandidateJ] == -101) {
                k++
                k %= 4
            }
            i += moves[k][0]
            j += moves[k][1]
        }
        return ans

    }
}
