class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val map = mutableMapOf<Char, Char>()
        val map2 = mutableMapOf<Char, Char>()
        for (i in 0..s.lastIndex) {
            if (map[s[i]] != null && map[s[i]] != t[i]) {
                return false
            } else {
                map.set(s[i], t[i])
            }

            if (map2[t[i]] != null && map2[t[i]] != s[i]) {
                return false
            } else {
                map2.set(t[i], s[i])
            }
        }
        return true
    }
}