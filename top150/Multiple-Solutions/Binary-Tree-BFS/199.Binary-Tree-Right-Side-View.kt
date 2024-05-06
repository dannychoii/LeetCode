// BFS 풀이도 가능함
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val map = mutableMapOf<Int, List<Int>>()
        var level = 0
        var index = 0

        fun load(root: TreeNode?) {
            if (root == null) return
            map[level] = listOf(root.`val`)
            level++
            load(root?.left)
            load(root?.right)
            level--
        }

        load(root)
        return map.values.map { it.last() }
    }
}