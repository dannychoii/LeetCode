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
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        if (root?.right == null && root?.left == null) {
            if (targetSum - root!!.`val` == 0) return true
            else return false
        } else {
            return hasPathSum(root?.right, targetSum - root.`val`) || hasPathSum(root?.left, targetSum - root.`val`)
        }
    }
}