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
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root?.left == null && root?.right == null) return root

        var temp = root?.right
        root?.right = root?.left
        root?.left = temp

        invertTree(root?.left)
        invertTree(root?.right)
        return root
    }
}