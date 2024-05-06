// in-order traversal 로 시도하면 더 빠르게 풀 수 있다.
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
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val list = mutableListOf<Int>()
        var current = root
        fun dfs(root: TreeNode?) {
            if (root == null) {
                return
            }
            dfs(root?.left)
            list.add(root!!.`val`)
            dfs(root?.right)
        }
        dfs(root)

        list.sort()
        return list[k - 1]
    }
}