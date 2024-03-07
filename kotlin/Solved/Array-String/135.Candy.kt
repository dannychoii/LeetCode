class Solution {
    fun candy(ratings: IntArray): Int {
        var ans = Array<Int>(ratings.size) { 1 }
        var sum = 0
        for (i in 1..ratings.lastIndex) {
            if (ratings[i] > ratings[i - 1]) {
                sum += 1
                ans[i] = max(ans[i], sum + 1)
            } else {
                sum = 0
            }
        }
        for (i in ratings.lastIndex downTo 1) {
            if (ratings[i] < ratings[i - 1]) {
                sum += 1
                ans[i - 1] = max(ans[i - 1], sum + 1)
            } else {
                sum = 0
            }
        }
        return ans.sum()
    }
}