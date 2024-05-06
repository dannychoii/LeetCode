// greedy solution 있음
class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        val diffArr = Array<Int>(gas.size) { 0 }
        val cumulative = Array<Int>(gas.size) { 0 }
        diffArr[0] = gas[0] - cost[0]
        cumulative[0] = diffArr[0]
        for (i in 1..gas.lastIndex) {
            diffArr[i] = gas[i] - cost[i]
            cumulative[i] = cumulative[i - 1] + diffArr[i]
        }

        var min: Int = Int.MAX_VALUE
        var position: Int = -1

        if (cumulative.last() < 0) return -1

        for (i in 0..cumulative.lastIndex) {
            if (min >= cumulative[i]) {
                min = cumulative[i]
                position = i
            }
        }
        return (position + 1) % gas.size
    }
}