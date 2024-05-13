// 처음에는 N^2 로 모두 비교하는 풀이를 생각했음. 그러나 정렬된다면 O(N) 으로 해결가능하다는 것을 인지하게 됨
class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        var cars = position.zip(speed).toMutableList()
        cars.sortWith { a, b -> b.first.compareTo(a.first) }
        var answer = 0
        while (cars.isNotEmpty()) {
            val car = cars.removeAt(0)
            answer++

            for ((i, ele) in cars.withIndex()) {
                if (crossEachOtherBelowTarget(car, ele, target)) {
                    cars[i] = Pair(-1, -1)
                }
            }
            cars = cars.filter { it != Pair(-1, -1) }.toMutableList()
        }
        return answer
    }

    fun crossEachOtherBelowTarget(line1: Pair<Int, Int>, line2: Pair<Int, Int>, target: Int): Boolean {
        // line1.first + line1.second * x = line2.first + line2.second
        val x = (line1.first - line2.first).toFloat() / (line2.second - line1.second)
        val y = line1.first + line1.second * x
        return 0 <= x && y <= target
    }
}