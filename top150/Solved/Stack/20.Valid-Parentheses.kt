class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        val set = setOf('(', '{', '[')
        val opposite = mapOf(')' to '(', '}' to '{', ']' to '[')
        for (letter in s) {
            if (letter in set) stack.add(letter)
            else {
                val removed = stack.removeLastOrNull()
                if (removed != opposite[letter]) {
                    return false
                }
            }
        }

        return if (stack.isEmpty()) true else false
    }
}