// DFS 로 풀었으나 BFS 풀이가 있음
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
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val zigzag = List<MutableList<Int>>(100) { mutableListOf<Int>() }

        fun dfs(root: TreeNode?, level: Int) {
            if (root == null) return
            dfs(root.left, level + 1)
            zigzag[level].add(root.`val`)
            dfs(root.right, level + 1)
        }
        dfs(root, 0)
        for ((i, list) in zigzag.withIndex()) {
            if (i % 2 == 1) {
                list?.reverse()
            }
        }

        return zigzag.filter { it.isNotEmpty() }
    }
}