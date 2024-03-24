class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        var ans = mutableListOf<List<Int>>()
        fun dfs(num: List<Int>, current: List<Int>, k: Int) {
            if (k == 0) {
                ans.add(current)
            } else {
                for (n in num) {
                    dfs(num.filter { it != n }, current + listOf(n), k - 1)
                }
            }
        }
        dfs(nums.toList(), listOf(), nums.size)
        return ans
    }
}