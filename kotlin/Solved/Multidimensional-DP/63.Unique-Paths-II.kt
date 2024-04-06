class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        if (obstacleGrid[0][0] == 1) {
            return 0
        }
        obstacleGrid[0][0] = 1

        for ((i, row) in obstacleGrid.withIndex()) {
            for ((j, ele) in row.withIndex()) {
                val up = obstacleGrid.getOrNull(i - 1)?.getOrNull(j)
                val left = obstacleGrid.getOrNull(i)?.getOrNull(j - 1)
                if (obstacleGrid[i][j] == 1 && !(i == 0 && j == 0)) {
                    obstacleGrid[i][j] = 0
                } else {
                    when {
                        up != null && left != null -> {
                            obstacleGrid[i][j] += (up + left)
                        }

                        left != null -> {
                            obstacleGrid[i][j] += left
                        }

                        up != null -> {
                            obstacleGrid[i][j] += up
                        }
                    }
                }
            }
        }
        return obstacleGrid.last().last()
    }
}