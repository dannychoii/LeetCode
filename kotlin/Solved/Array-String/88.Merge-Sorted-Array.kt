class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        for (i in m..m + n - 1) {
            nums1[i] = nums2[i - m]
        }
        return nums1.sort()
    }
}