// 더 좋은 솔루션 있음
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val map = mutableMapOf<Char, Int>()
        for (letter in s){
            map[letter] = map.getOrDefault(letter, 0) + 1
        }
        for (letter in t){
            if (map.getOrDefault(letter, 0) >=1){
                map[letter] = map.getOrDefault(letter, 0) -1
                if(map[letter] ==0 ){
                    map.remove(letter)
                }
            } else{
                return false
            }
        }
        return map.keys.size == 0
    }
}