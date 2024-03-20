// 아래 코드는 property 초기화 이후에 init block 이 초기화됨
// property, init block, constructor
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
class BSTIterator(root: TreeNode?) {
    var list = mutableListOf<Int>()
    var i = 0

    init {
        this.traverse(root)
    }

    fun traverse(node: TreeNode?) {
        if (node != null) {
            this.traverse(node.left)
            this.list.add(node.`val`)
            this.traverse(node.right)
        }
    }

    fun next(): Int {
        val return_node = this.list[i]
        this.i += 1
        return return_node
    }

    fun hasNext(): Boolean {
        when {
            this.i < this.list.size -> {
                return true
            }

            else -> {
                return false
            }
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */