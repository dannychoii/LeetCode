class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val cache = mutableMapOf<String, Boolean>()
        fun dfs(s: String): Boolean {
            if (s == "") return true
            if (cache[s] != null) {
                return cache[s]!!
            }

            wordDict.forEach {
                if (s.startsWith(it)) {
                    val result = dfs(s.substring(it.length))
                    if (result) return true
                    else {
                        cache[s.substring(it.length)] = result
                    }
                }
            }
            return false
        }

        return dfs(s)
    }
}