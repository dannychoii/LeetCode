class Main() {
    fun main() {
        println(Solution().lengthOfLongestSubstring("abcabcbb"))
    }
}

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {

        val set = mutableSetOf<Char>()

        var start = 0
        var end = 0
        var ans = 0
        while(start<=end){
            if(!set.contains(s[end])){
                set.add(s[end])
                end++
            } else{
                ans = max(ans, set.size)
                set.delete(s[start])
                start ++
            }
        }
        return ans
    }
}
