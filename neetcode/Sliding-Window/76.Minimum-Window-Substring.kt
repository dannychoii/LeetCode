// right 는 for loop, left 는 while loop에 넣고, difference를 계산한다.
// map -> array 로 변경하면 속도 향상이 가능할 것으로 보인다.
class Solution {
    val atozAtoZ = 52
    fun minWindow(s: String, t: String): String {
        if (t.length > s.length) return ""
        var ans = ""
        var left = 0
        val sMap = mutableMapOf<Char, Int>()
        val tMap = mutableMapOf<Char, Int>()
        for (char in 'a'..'z') {
            sMap.put(char, 0)
            tMap.put(char, 0)
        }
        for (char in 'A'..'Z') {
            sMap.put(char, 0)
            tMap.put(char, 0)
        }

        for (char in t) {
            tMap[char] = (tMap[char] ?: 0) + 1
        }

        for (right in 0..s.lastIndex) {
            sMap[s[right]] = (sMap[s[right]]!! + 1)
            while (checkDiff(sMap, tMap) == atozAtoZ) {
                if (ans == "" || ans.length > right - left + 1) {
                    ans = s.substring(left, right + 1)
                }
                sMap[s[left]] = (sMap[s[left]]!! - 1)
                left++
            }
        }
        return ans
    }

    fun checkDiff(mapOne: Map<Char, Int>, mapTwo: Map<Char, Int>): Int {
        return mapOne.keys.map {
            (mapOne[it]!! - mapTwo[it]!!)
        }.count { it >= 0 }
    }
}