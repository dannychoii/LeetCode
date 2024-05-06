class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val num = MutableList<Int>(n) { i -> i + 1 }
        val ans = mutableListOf<List<Int>>()

        fun dfs(num: List<Int>, current: List<Int>, k: Int) {
            if (k == 0) {
                ans.add(current)
            } else {
                for (i in 0..num.lastIndex) {
                    dfs(num.filter { num[i] < it }, current + listOf(num[i]), k - 1)
                }
            }
        }

        dfs(num, listOf(), k)
        return ans.map { it.toList() }.toList()
    }
}