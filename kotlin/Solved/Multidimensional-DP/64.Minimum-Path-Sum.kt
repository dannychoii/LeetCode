class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        for ((i, row) in grid.withIndex()) {
            for ((j, ele) in row.withIndex()) {
                val up = grid.getOrNull(i - 1)?.getOrNull(j)
                val left = grid.getOrNull(i)?.getOrNull(j - 1)
                when {
                    up != null && left != null -> {
                        grid[i][j] += min(up, left)
                    }

                    left != null -> {
                        grid[i][j] += left
                    }

                    up != null -> {
                        grid[i][j] += up
                    }
                }
            }
        }
        return grid.last().last()
    }
}