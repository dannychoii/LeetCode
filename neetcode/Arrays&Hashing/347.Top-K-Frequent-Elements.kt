// bucket sort,
// array where index is count, and frequency map is both required
class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val arr = Array<MutableList<Int>>(10002) { mutableListOf() }
        val map = mutableMapOf<Int, Int>()

        nums.forEach {
            map[it] = (map[it] ?: 0) + 1
            if (map[it] != 1) {
                arr[map[it]!! - 1].remove(it)
            }
            arr[map[it]!!].add(it)
        }
        val ans = mutableListOf<Int>()


        for (i in arr.lastIndex downTo 0) {
            if (ans.size >= k) break
            if (arr[i].isNotEmpty()) {
                ans.addAll(arr[i])
            }
        }
        return ans.toIntArray()
    }å
}