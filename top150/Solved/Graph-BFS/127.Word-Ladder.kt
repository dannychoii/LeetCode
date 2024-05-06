class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        fun oneCharDiff(str1: String, str2: String): Boolean {
            var count = 0
            for (i in 0..str1.lastIndex) {
                if (str1[i] != str2[i]) count++
            }
            return count == 1
        }

        var ans = Integer.MAX_VALUE
        val q = ArrayDeque<Pair<String, Int>>()
        val visited = mutableSetOf<String>()
        q.add(Pair(beginWord, 1))

        while (q.isNotEmpty()) {
            val (current, count) = q.removeFirst()
            if (current == endWord) {
                ans = min(count, ans)
            }

            for (item in wordList) {
                if (oneCharDiff(current, item) && !visited.contains(item)) {
                    visited.add(item)
                    q.add(Pair(item, count + 1))
                }
            }
        }

        return if (ans == Integer.MAX_VALUE) 0 else ans
    }
}