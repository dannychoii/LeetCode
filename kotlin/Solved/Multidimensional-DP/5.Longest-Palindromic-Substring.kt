// BFS 풀이의 경우 메모리초과발생
class Solution {
    fun longestPalindrome(s: String): String {

        val cache = mutableMapOf<String, Boolean>()
        fun bfs(input: String): String {
            val q = ArrayDeque<String>()
            q.add(input)

            while (q.isNotEmpty()) {
                val s = q.removeFirst()
                if (cache.contains(s)) {
                } else {
                    if (s.isPalindrome()) {
                        return s
                    } else {
                        cache[s] = false
                        q.add(s.substring(1))
                        q.add(s.substring(0, s.lastIndex))
                    }
                }
            }
            return ""
        }

        return bfs(s)
    }

    private fun String.isPalindrome(): Boolean {
        return this == this.reversed()
    }
}

//시간 초과 발생
class Solution {
    fun longestPalindrome(s: String): String {

        val cache = mutableMapOf<String, Boolean>()
        var ans = ""

        fun dfs(s: String) {
            if (cache.contains(s)) {
            } else {
                if (s.isPalindrome()) {
                    cache[s] = true
                    if (s.length > ans.length) ans = s
                } else {
                    cache[s] = false
                    dfs(s.substring(1))
                    dfs(s.substring(0, s.lastIndex))
                }
            }
        }

        dfs(s)
        return ans
    }

    private fun String.isPalindrome(): Boolean {
        return this == this.reversed()
    }

}

// 기준을 한칸씩 옮겨가며 한 칸씩 확장하는게 핵심이다.
class Solution {
    fun longestPalindrome(s: String): String {
        var ans = ""
        for (i in 0..s.lastIndex) {
            var l = i
            var r = i
            while (l >= 0 && r <= s.lastIndex && s[l] == s[r]) {
                l--
                r++
            }
            l++
            r--

            if (ans.length < r + 1 - l) {
                ans = s.substring(l, r + 1)
            }


            l = i
            r = i + 1
            while (l >= 0 && r <= s.lastIndex && s[l] == s[r]) {
                l--
                r++
            }
            l++
            r--

            if (ans.length < r + 1 - l) {
                ans = s.substring(l, r + 1)
            }
        }

        return ans
    }
}