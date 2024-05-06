/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (left == right) return head
        val list = mutableListOf<ListNode?>()
        val stack = Stack<ListNode>()
        var i = 1
        var current = head
        while (current != null) {
            when {
                i < left -> list.add(current)
                i > right -> list.add(current)
                else -> {
                    list.add(null)
                    stack.push(current)
                }
            }
            i++
            current = current?.next
        }
        i = i - 1

        for (k in left - 1..right - 1)
            list[k] = stack.pop()


        var ans = ListNode(-1)
        var iter = ans
        for (ele in list) {
            iter.next = ele
            iter = iter.next!!
        }
        iter.next = null


        return ans.next
    }
}