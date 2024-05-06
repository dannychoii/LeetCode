class Solution {
    fun simplifyPath(path: String): String {
        val elements = path.split('/')
            .filter { it != "" && it != "." }
        val stack = Stack<String>()
        elements.forEach {
            if (it == "..") {
                if (!stack.empty()) stack.pop()
            } else {
                stack.push(it)
            }
        }
        return stack.joinToString("/", "/")
    }
}