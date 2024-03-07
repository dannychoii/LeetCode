class Solution {
    fun maxProfit(prices: IntArray): Int {
        var buy = prices[0]
        var sell = 0
        var maxProfit = 0
        for (i in 1..prices.lastIndex) {
            if (prices[i] >= buy) {
                sell = prices[i]
                maxProfit = max(maxProfit, (sell - buy))
            }
            if (prices[i] < buy) {
                buy = prices[i]
            }
        }
        return maxProfit
    }
}