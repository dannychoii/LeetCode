class Solution {
    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {

        fun oneCharDiff(str1: String, str2: String): Boolean {
            var count = 0
            for (i in 0..str1.lastIndex) {
                if (str1[i] != str2[i]) count++
            }
            return count == 1
        }

        var ans = Integer.MAX_VALUE
        val q = ArrayDeque<Triple<String, Int, List<String>>>()
        q.add(Triple(startGene, 0, listOf()))

        while (q.isNotEmpty()) {
            val (current, count, list) = q.removeFirst()
            if (current == endGene) {
                ans = min(count, ans)
            }

            for (item in bank) {
                if (!list.contains(item) && oneCharDiff(current, item)) {
                    q.add(Triple(item, count + 1, list + listOf(current)))
                }
            }

        }

        return if (ans == Integer.MAX_VALUE) -1 else ans
    }
}