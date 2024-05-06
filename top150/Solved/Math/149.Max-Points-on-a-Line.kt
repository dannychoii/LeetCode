class Solution {
    fun maxPoints(points: Array<IntArray>): Int {
        if (points.size == 1) return 1
        val map = mutableMapOf<String, MutableSet<Pair<Int, Int>>>()
        for (i in 0..points.lastIndex - 1) {
            for (j in i + 1..points.lastIndex) {
                val (x, y) = points[i]
                val (x2, y2) = points[j]
                if (map[pointsToLine(x, y, x2, y2)] == null) {
                    map[pointsToLine(x, y, x2, y2)] = mutableSetOf(
                        Pair(x, y), Pair(x2, y2)
                    )
                } else {
                    map[pointsToLine(x, y, x2, y2)]?.addAll(listOf(Pair(x, y), Pair(x2, y2)))
                }
            }
        }
        return map.values.maxOf { it.count() }
    }

    fun pointsToLine(x: Int, y: Int, x2: Int, y2: Int): String {
        if (x == x2) return "x=$x"
        if (y == y2) return "y=$y"
        val angle = (y2 - y) / (x2 - x).toDouble()
        val coef = y - angle * x
        return "y=$angle*x+$coef"
    }
}