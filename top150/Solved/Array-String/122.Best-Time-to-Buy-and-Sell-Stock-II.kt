class Solution {
    fun maxProfit(prices: IntArray): Int {
        var result = 0
        for (i in 1..prices.lastIndex) {
            val diff = prices[i] - prices[i - 1]
            if (diff > 0) result += diff
        }
        return result
    }
}