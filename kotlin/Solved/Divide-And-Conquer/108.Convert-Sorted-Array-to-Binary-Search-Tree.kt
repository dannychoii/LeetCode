// node 객체가 아닌 index만 넘긴다면 더 효율적인 풀이도 가능하다.
// 중앙을 노드로 삼고 좌 우를 넘긴다.
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
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null
        val node = TreeNode(nums[nums.size / 2])
        node.left = sortedArrayToBST(nums.take(nums.size / 2).toIntArray())
        node.right = sortedArrayToBST(nums.takeLast(nums.size - (nums.size / 2) - 1).toIntArray())
        return node
    }
}