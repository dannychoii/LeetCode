// 정렬한 후에 greedy 기법으로 푼다
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val ans = mutableListOf<IntArray>()
        var start = intervals[0][0]
        var end = intervals[0][1]
        for (i in 0..intervals.lastIndex) {
            if (intervals[i][0] <= end) {
                end = max(end, intervals[i][1])
            } else {
                ans.add(intArrayOf(start, end))
                start = intervals[i][0]
                end = intervals[i][1]
            }
        }
        ans.add(intArrayOf(start, end))
        return ans.toTypedArray()
    }
}