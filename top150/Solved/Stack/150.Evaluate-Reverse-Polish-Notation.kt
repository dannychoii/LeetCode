// isDigit(), isLetterOrDigit
class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        for (token in tokens) {
            if (token.toIntOrNull() != null) {
                stack.push(token.toInt())
            } else {
                val operand2 = stack.pop()
                val operand = stack.pop()
                val calculated = when (token) {
                    "+" -> operand + operand2
                    "-" -> operand - operand2
                    "*" -> operand * operand2
                    "/" -> (operand / operand2)
                    else -> throw RuntimeException("")
                }
                stack.push(calculated)
            }
        }
        return stack.pop()
    }
}