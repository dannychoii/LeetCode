class Solution {
    fun maxArea(height: IntArray): Int {
        var l = 0
        var r = height.lastIndex
        var area = 0
        while (l <= r) {
            area = max(area, min(height[l], height[r]) * (r - l))
            if (height[l] < height[r]) {
                l++
            } else {
                r--
            }
        }
        return area
    }
}