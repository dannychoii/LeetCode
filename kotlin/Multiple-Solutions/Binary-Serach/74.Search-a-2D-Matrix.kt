class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var left = 0
        var right = matrix.lastIndex
        var i = 0

        while (left <= right) {
            val mid = (left + right) / 2
            if (matrix[mid][0] == target) return true
            else if (matrix[mid][0] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        i = (left + right) / 2
        left = 0
        right = matrix[i].lastIndex

        while (left <= right) {
            val mid = (left + right) / 2
            if (matrix[i][mid] == target) return true
            else if (matrix[i][mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return false
    }
}