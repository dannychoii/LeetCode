class MinStack() {
    data class Node(val a: Int, val min: Int)

    val stack = Stack<Node>()

    fun push(`val`: Int) {
        if (stack.isEmpty()) {
            stack.push(Node(`val`, `val`))
        } else {
            val comp = this.getMin()
            stack.push(Node(`val`, min(comp, `val`)))
        }

    }

    fun pop() {
        val ele = stack.pop()
    }

    fun top(): Int {
        return stack.peek().a
    }

    fun getMin(): Int {
        return stack.peek().min
    }

}
