/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

// oldToNew에 모두 저장하는것이 핵심이다.
class Solution {
    fun cloneGraph(node: Node?): Node? {
        val oldToNew = mutableMapOf<Node, Node>()

        fun cloneGraphProcess(node: Node?): Node? {
            if (node == null) return null
            if (oldToNew[node] != null) return null

            val newNode = Node(node.`val`)
            oldToNew[node] = newNode
            node.neighbors.forEach {
                cloneGraphProcess(it)
            }
            node.neighbors.forEach {
                newNode.neighbors.add(oldToNew[it])
            }
            return newNode
        }

        return cloneGraphProcess(node)
    }
}