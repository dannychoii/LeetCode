// dfs solution에서 visited set이 아닌 마킹으로도 가능할 수 있음에 유의
class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        for ((i, row) in board.withIndex()) {
            for ((j, ele) in row.withIndex()) {
                if (ele == word[0]) {
                    val result = dfs(Pair(i, j), word, board)
                    if (result) return true
                }
            }
        }
        return false
    }

    fun dfs(
        current: Pair<Int, Int>,
        word: String,
        board: Array<CharArray>
    ): Boolean {
        if (word.isEmpty()) return true
        val (x, y) = current
        if (x < 0 || y < 0 || x > board.lastIndex || y > board[0].lastIndex || board[x][y] != word[0]) return false
        board[x][y] = '#'
        val right = dfs(Pair(x + 1, y), word.substring(1), board)
        val left = dfs(Pair(x - 1, y), word.substring(1), board)
        val up = dfs(Pair(x, y + 1), word.substring(1), board)
        val down = dfs(Pair(x, y - 1), word.substring(1), board)
        board[x][y] = word[0]

        return right || left || up || down
    }
}


// set + set 연산으로 인해 시간초과가 발생하는 경우가 있다.
fun dfs(
    visited: Set<Pair<Int, Int>>,
    current: Pair<Int, Int>,
    word: String,
    board: Array<CharArray>
): Boolean {
    if (word.isEmpty()) return true
    val (x, y) = current
    if (x < 0 || y < 0 || x > board.lastIndex || y > board[0].lastIndex || visited.contains(current) || board[x][y] != word[0]) return false
    board[x][y] = '#'
    val right = dfs(visited + setOf(Pair(x, y)), Pair(x + 1, y), word.substring(1), board)
    val left = dfs(visited + setOf(Pair(x, y)), Pair(x - 1, y), word.substring(1), board)
    val up = dfs(visited + setOf(Pair(x, y)), Pair(x, y + 1), word.substring(1), board)
    val down = dfs(visited + setOf(Pair(x, y)), Pair(x, y - 1), word.substring(1), board)
    board[x][y] = word[0]

    return right || left || up || down
