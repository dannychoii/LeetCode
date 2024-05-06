// O(nlogn)가 아닌 O(n) 해결책이 있다.
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
    fun getMinimumDifference(root: TreeNode?): Int {
        val list = mutableListOf<Int>()
        fun dfs(root: TreeNode?) {
            if (root != null) {
                list.add(root.`val`)
                dfs(root.right)
                dfs(root.left)
            }
        }
        dfs(root)

        list.sort()
        var minVal = Integer.MAX_VALUE
        for (i in 0..list.lastIndex - 1) {
            minVal = min(minVal, list[i + 1] - list[i])
            if (minVal == 0) break
        }

        return minVal
    }
}