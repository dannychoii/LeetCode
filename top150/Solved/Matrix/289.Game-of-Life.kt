class Solution {
    fun gameOfLife(board: Array<IntArray>): Unit {

        fun life(adj: Int, i: Int, j: Int) {
            if (adj == 3) {
                if (board[i][j] == 0) board[i][j] = -1
            } else if (adj < 2) {
                if (board[i][j] == 1) board[i][j] = 2
            } else if (adj > 3) {
                if (board[i][j] == 1) board[i][j] = 2
            }
        }

        fun adjacent(i: Int, j: Int): Int {
            var ans = 0
            for (row in i - 1..i + 1) {
                for (col in j - 1..j + 1) {
                    if (row == i && col == j) continue
                    if (board.getOrNull(row)?.getOrNull(col) ?: 0 >= 1) {
                        ans += 1
                    }
                }
            }
            return ans
        }

        for ((i, row) in board.withIndex()) {
            for ((j, ele) in row.withIndex()) {
                life(adjacent(i, j), i, j)
            }
        }
        for ((i, row) in board.withIndex()) {
            for ((j, ele) in row.withIndex()) {
                if (ele == 2) board[i][j] = 0
                if (ele == -1) board[i][j] = 1
            }
        }
    }
}