// right 는 for loop, left 는 while 혹은 for loop 으로 작성하는게 구현상 좋다
class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val map = mutableMapOf<Char, Int>()
        s1.forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        var l = 0
        var r = 0
        while (r <= s2.lastIndex) {
            if (map.values.all { it == 0 }) return true
            if ((map[s2[r]] ?: 0) > 0) {
                map[s2[r]] = (map[s2[r]]!! - 1)
                r++
            } else {
                if (l <= s2.lastIndex && map[s2[l]] != null) {
                    map[s2[l]] = map[s2[l]]!! + 1
                }
                l++
                r = maxOf(r, l)
            }
        }
        return map.values.all { it == 0 }
    }
}