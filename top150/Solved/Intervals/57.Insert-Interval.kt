// 새로운 원소를 넣고 정렬한 뒤에는 56번 merge interval 과 크게 다르지 않다.
// overlappiong interval을 합치는 것은 greedy 하게 진행한다는 것을 기억하자.
class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val list = intervals.toMutableList()
        list.add(newInterval)
        list.sortBy { it[0] }

        val ans = mutableListOf<IntArray>()
        var start = list[0][0]
        var end = list[0][1]

        for (i in 0..list.lastIndex) {
            if (list[i][0] <= end) {
                end = max(end, list[i][1])
            } else {
                ans.add(intArrayOf(start, end))
                start = list[i][0]
                end = list[i][1]
            }
        }
        ans.add(intArrayOf(start, end))

        return ans.toTypedArray()
    }
}