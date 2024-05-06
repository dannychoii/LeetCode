// substring(1)인 경우 index 1~last
class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return listOf<String>()
        val map = mapOf<Char, List<Char>>(
            '2' to listOf('a', 'b', 'c'),
            '3' to listOf('d', 'e', 'f'),
            '4' to listOf('g', 'h', 'i'),
            '5' to listOf('j', 'k', 'l'),
            '6' to listOf('m', 'n', 'o'),
            '7' to listOf('p', 'q', 'r', 's'),
            '8' to listOf('t', 'u', 'v'),
            '9' to listOf('w', 'x', 'y', 'z'),
        )

        fun dfs(current: List<String>, number: String): List<String> {
            if (number.isNullOrEmpty()) return current
            return dfs(current.flatMap { str ->
                map[number[0]]!!.map {
                    str + it
                }
            }, number.substring(1))
        }

        return dfs(map[digits[0]]!!.map { it.toString() }, digits.substring(1))
    }
}