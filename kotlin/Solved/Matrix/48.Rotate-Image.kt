class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        for (i in 0..matrix.lastIndex) {
            for (j in i + 1..matrix.lastIndex) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }

        for (j in 0..matrix.lastIndex / 2) {
            for (i in 0..matrix.lastIndex) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[i][matrix.lastIndex - j]
                matrix[i][matrix.lastIndex - j] = temp
            }
        }
    }
}