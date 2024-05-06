// sub tree 단위로 쪼갠다
class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty() || inorder.isEmpty()) return null

        val node = TreeNode(preorder[0])
        val i = inorder.indexOf(preorder[0])


        node.left = buildTree(preorder.sliceArray(1..i), inorder.sliceArray(0..i - 1))
        node.right =
            buildTree(preorder.sliceArray(i + 1..preorder.lastIndex), inorder.sliceArray(i + 1..inorder.lastIndex))
        return node
    }
}