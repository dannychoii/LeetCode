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
    fun isSymmetric(root: TreeNode?): Boolean {
        return comparsion(root?.left, root?.right)
    }

    fun comparsion(root: TreeNode?, root2: TreeNode?): Boolean {
        if (root == null && root2 == null) return true
        return comparsion(root?.left, root2?.right) && comparsion(
            root?.right,
            root2?.left
        ) && root?.`val` == root2?.`val`
    }
}