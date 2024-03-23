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
    fun isValidBST(root: TreeNode?): Boolean {

        fun isValidBSTInternal(root: TreeNode?, lessThan: Long, biggerThan: Long): Boolean {
            if (root == null) return true
            if (root.`val` >= lessThan || root.`val` <= biggerThan) return false

            val leftVal = root.left?.`val`
            val rightVal = root.right?.`val`

            if (leftVal != null && leftVal >= root.`val`) return false
            if (rightVal != null && rightVal <= root.`val`) return false

            return isValidBSTInternal(
                root.left,
                min(lessThan, root.`val`.toLong()),
                biggerThan
            ) && isValidBSTInternal(root.right, lessThan, max(biggerThan, root.`val`.toLong()))
        }

        return isValidBSTInternal(root, Long.MAX_VALUE, Long.MIN_VALUE)
    }
}