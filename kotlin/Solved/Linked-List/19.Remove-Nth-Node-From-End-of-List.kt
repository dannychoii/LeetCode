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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var current = head
        var i = 0

        while (current != null) {
            current = current.next
            i++
        }

        if (n == i) return head?.next

        var j = 1
        var leftL: ListNode? = null
        current = head
        while (j <= i - n) {
            if (j == i - n) {
                leftL = current
                break
            }
            current = current?.next
            j++
        }
        leftL?.next = leftL?.next?.next
        return head
    }
}