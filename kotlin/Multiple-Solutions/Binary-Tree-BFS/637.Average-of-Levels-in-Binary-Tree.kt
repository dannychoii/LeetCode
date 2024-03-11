// 마찬가지로 BFS 해결책이 있음
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
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val map = mutableMapOf<Int, MutableList<Int>>()
        var level = 0

        fun load(root: TreeNode?) {
            if (root == null) return
            map[level]?.add(root.`val`)
            map[level] = map[level] ?: mutableListOf(root.`val`)
            level++
            load(root?.left)
            load(root?.right)
            level--
        }
        load(root)

        return map.values.map { it.average() }.toDoubleArray()
    }
}