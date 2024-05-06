class Solution {
    fun trap(height: IntArray): Int {
        var max = 0
        var water = IntArray(height.size) { 0 }
        for ((i, h) in height.withIndex()) {
            if (h >= max) {
                max = h
                water[i] = 0
            } else {
                water[i] = max - h
            }
        }
        max = 0
        for (i in height.lastIndex downTo 0) {
            if (height[i] >= max) {
                max = height[i]
                water[i] = 0
            } else {
                water[i] = min(water[i], max - height[i])
            }
        }
        return water.sum()
    }
}