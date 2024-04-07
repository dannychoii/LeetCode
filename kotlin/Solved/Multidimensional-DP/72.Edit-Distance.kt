// LCS 알고리즘, word[i] == word2[j] 일때는 최소값 비교 없이 바로 다음 블록으로 넘어간다는 점을 유의하자
class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val cache = Array(word1.length + 1) { Array<Int>(word2.length + 1) { 0 } }

        val m = word1.lastIndex + 1
        val n = word2.lastIndex + 1
        var input = 0
        for (i in m downTo 0) {
            cache[i][n] = input
            input++
        }
        input = 0
        for (j in n downTo 0) {
            cache[m][j] = input
            input++
        }

        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                if (word1[i] == word2[j]) {
                    cache[i][j] = cache[i + 1][j + 1]
                } else {
                    cache[i][j] = minOf(
                        cache[i + 1][j], cache[i][j + 1], cache[i + 1][j + 1]
                    ) + 1
                }
            }
        }

        return cache[0][0]
    }
}