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
    fun sumNumbers(root: TreeNode?): Int {
        val ans = mutableListOf<String>()
        fun deriveNum(root: TreeNode?, current: String) {
            if (root == null) {
            } else if (root?.right == null && root?.left == null) {
                ans.add(current + root!!.`val`.toString())
            } else {
                deriveNum(root?.left, current + root!!.`val`.toString())
                deriveNum(root?.right, current + root!!.`val`.toString())
            }
        }
        deriveNum(root, "")
        return ans.map { it.toInt() }.sum()
    }
}