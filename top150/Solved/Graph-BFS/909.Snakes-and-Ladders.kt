// ladder or snake at most once
class Solution {
    fun snakesAndLadders(board: Array<IntArray>): Int {
        val n = board.size
        fun toPosition(input: Int): Pair<Int, Int> {
            val index = input - 1
            val i = index / n
            val j = if (i % 2 == 0) index % n else n - 1 - index % n
            return Pair(n - 1 - i, j)
        }

        val visited = mutableSetOf(1)

        val q = ArrayDeque<Pair<Int, Int>>()
        q.add(Pair(1, 0))
        while (q.isNotEmpty()) {

            val (current, count) = q.removeFirst()

            for (add in 1..6) {
                var next = current + add
                val (i, j) = toPosition(next)
                if (board[i][j] != -1) {
                    next = board[i][j]
                }
                if (next == n * n) return count + 1
                if (!visited.contains(next)) {
                    visited.add(next)
                    q.add(Pair(next, count + 1))
                }
            }
        }
        return -1
    }
}