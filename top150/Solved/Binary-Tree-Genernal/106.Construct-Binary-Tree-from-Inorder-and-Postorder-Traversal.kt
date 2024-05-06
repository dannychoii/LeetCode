// subtree 단위로 문제를 자르면 쉽다
class Solution {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        if (inorder.isEmpty() && postorder.isEmpty()) return null
        val value = postorder[postorder.lastIndex]
        val root = TreeNode(value)
        val i = inorder.indexOf(value)
        root?.left = buildTree(inorder.sliceArray(0..i - 1), postorder.sliceArray(0..i - 1))
        root?.right = buildTree(inorder.sliceArray(i + 1..inorder.lastIndex), postorder.sliceArray(i..postorder.lastIndex - 1))
        return root
    }
}