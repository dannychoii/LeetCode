// 2^N 으로 최악의 시간 복잡도를 가진다.
class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        fun dfs(current: List<Int>, target: Int) {
            if (target == 0) {
                ans.add(current)
            } else if (target < 0) {
            } else {
                for (candidate in candidates) {
                    dfs(current + listOf(candidate), target - candidate)
                }
            }
        }

        dfs(listOf(), target)
        return ans.map { it.sorted() }.distinct()
    }
}

// 위의 알고리즘에서 다음번 선택폭을 제한하면 더 빠르게 풀 수 있다.
class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        fun dfs(current: List<Int>, lowerBound: Int, target: Int) {
            if (target == 0) {
                ans.add(current)
            } else if (target < 0) {
            } else {
                for (i in lowerBound..candidates.lastIndex) {
                    val candidate = candidates[i]
                    dfs(current + listOf(candidate), i, target - candidate)
                }
            }
        }

        dfs(listOf(), 0, target)
        return ans.map { it.sorted() }.distinct()
    }
}