// 더 쉬운 풀이 가능
class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = mutableMapOf<Int, MutableList<Int>>()
        nums.forEachIndexed { i, v ->
            map[v]?.add(i)
            map[v] = map[v] ?: mutableListOf(i)
        }
        for ((key, v) in map) {
            if (v.lastIndex <= 0) continue
            for (i in 0..v.lastIndex - 1) {
                if (v[i + 1] - v[i] <= k) return true
            }
        }
        return false
    }
}
