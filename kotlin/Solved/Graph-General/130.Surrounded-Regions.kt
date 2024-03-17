// java.util.collections 와 kotlin.collections 가 다름에 유의
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        fun spread(m: Int, n: Int) {
            val q = ArrayDeque<Pair<Int, Int>>()
            val adj = listOf(Pair(-1, 0), Pair(1, 0), Pair(0, 1), Pair(0, -1))
            q.add(Pair(m, n))
            while (q.isNotEmpty()) {
                var ele = q.removeFirst()
                val m = ele.first
                val n = ele.second
                if (grid[m][n] == '1') {
                    grid[m][n] = '2'
                    adj.forEach {
                        val i = it.first + m
                        val j = it.second + n
                        if (grid.getOrNull(i)?.getOrNull(j) == '1') {
                            q.add(Pair(i, j))
                        }
                    }
                }
            }
        }

        var ans = 0
        for (i in 0..grid.lastIndex) {
            for (j in 0..grid[0].lastIndex) {
                if (grid[i][j] == '1') {
                    ans++
                    spread(i, j)
                }
            }
        }
        return ans
    }
}