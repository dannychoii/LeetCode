// dfs에 메모가 추가된 풀이는 최초에 cache 생성까지 시간이 오래걸린다.
// arr[n] = 합 n 을 만드는데 필요한 최소 코인 수로 가정하고 점화식을 세우는게 좋다.
class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        var cache = Array<Int>(amount + 1) { Int.MAX_VALUE }

        fun dfs(remainder: Int, current: Int) {
            if (remainder >= 0 && cache[remainder] > current) {
                cache[remainder] = current
                coins.forEach {
                    dfs(remainder - it, current + 1)
                }
            }
        }

        dfs(amount, 0)
        return if (cache[0] == Int.MAX_VALUE) -1 else cache[0]
    }
}