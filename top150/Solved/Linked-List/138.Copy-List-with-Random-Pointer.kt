/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution {
    fun copyRandomList(node: Node?): Node? {

        val map = mutableMapOf<Node, Node>()
        var current = node

        while (current != null) {
            map.put(current, Node(current.`val`))
            current = current.next
        }

        current = node
        while (current != null) {
            val new = map[current]
            new?.next = map[current.next]
            new?.random = map[current.random]
            current = current.next
        }

        return map[node]
    }
}