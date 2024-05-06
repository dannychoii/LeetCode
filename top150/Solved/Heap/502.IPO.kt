// a.compareTo(b) minHeap임에 유의
// greedy + two priority queue
class Solution {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        val profs = PriorityQueue<Pair<Int, Int>> { a, b -> b.second.compareTo(a.second) } // minHeap
        val caps = PriorityQueue<Pair<Int, Int>> { a, b -> a.second.compareTo(b.second) } // maxHeap

        for (i in 0..profits.lastIndex) {
            caps.add(Pair(i, capital[i]))
        }

        var maxAttempt = k
        var currentCapital = w

        while (maxAttempt > 0) {

            while (caps.isNotEmpty() && caps.peek().second <= currentCapital) {
                val (i, v) = caps.poll()
                profs.add(Pair(i, profits[i]))
            }

            if (profs.isNotEmpty()) {
                currentCapital += profs.poll().second
            }
            maxAttempt--
        }

        return currentCapital
    }
}