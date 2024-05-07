// Monotic Decreasing Stack problem
class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val s = Stack<Pair<Int, Int>>() //index, value
        val answer = IntArray(temperatures.size) { 0 }
        for ((index, temperature) in temperatures.withIndex()) {
            while (s.isNotEmpty() && temperature > s.peek().second) {
                val (i, v) = s.pop()
                answer[i] = index - i
            }
            s.add(Pair(index, temperature))
        }
        return answer
    }
}