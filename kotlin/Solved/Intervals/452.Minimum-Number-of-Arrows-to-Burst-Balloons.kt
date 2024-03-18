class Solution() {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortBy { it[0] }

        fun intersection(point: IntArray, point2: IntArray): IntArray? {
            return if (point[1] >= point2[0]) {
                intArrayOf(
                    max(point[0], point2[0]),
                    min(point[1], point2[1])
                )
            } else null
        }

        for (i in 1..points.lastIndex) {

            val intersection = intersection(points[i - 1], points[i])
            if (intersection != null) {
                points[i - 1] = intArrayOf(0)
                points[i] = intersection
            }
        }


        return points.count {
            it.size != 1
        }
    }
}