class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val metaMap = mutableMapOf<Map<Char, Int>, MutableList<String>>()
        for (word in strs) {
            val map = mutableMapOf<Char, Int>()
            for (letter in word) {
                map[letter] = map.getOrDefault(letter, 0) + 1
            }
            if (metaMap[map] == null) {
                metaMap[map] = mutableListOf()
            }
            metaMap[map]?.add(word)
        }
        return metaMap.values.toList().map { it.toList() }
    }
}