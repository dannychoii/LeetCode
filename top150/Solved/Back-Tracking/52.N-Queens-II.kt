// 순서가 다른 것들도 모두 중복해서 계산할수도 있다.
// row 기준으로 채택하기에 rowArray는 없어도 됨에 유의
class Solution {
    fun totalNQueens(n: Int): Int {
        if (n == 1) return 1
        val column = Array(n) { false }
        val diagonal = Array(2 * n - 1) { false }
        val otherDiagonal = Array(2 * n - 1) { false }
        var ans = 0

        fun dfs(current: Int, x: Int) {
            if (current == n) ans++
            else {
                val i = x + 1

                for (j in 0..column.lastIndex) {
                    if (column[j]) continue

                    val k = i - j + n - 1
                    val m = i + j

                    if (diagonal[k] || otherDiagonal[m]) {
                        continue
                    } else {

                        column[j] = true
                        diagonal[k] = true
                        otherDiagonal[m] = true
                        dfs(current + 1, i)

                        column[j] = false
                        diagonal[k] = false
                        otherDiagonal[m] = false
                    }
                }
            }
        }

        dfs(0, -1)
        return ans
    }
}