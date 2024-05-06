// BFS 풀이도 존재함
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
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val level = mutableListOf<MutableList<Int>>()

        fun dfs(root: TreeNode?, current: Int) {
            if (root == null)
            else {
                if (level.getOrNull(current) == null) {
                    level.add(mutableListOf(root!!.`val`))
                } else {
                    level[current]!!.add(root!!.`val`)
                }
                dfs(root?.left, current + 1)
                dfs(root?.right, current + 1)
            }
        }

        dfs(root, 0)
        return level
    }
}