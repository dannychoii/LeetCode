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
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        var current = head
        var n = 1
        while (current?.next != null) {
            current = current.next
            n++
        }
        current?.next = head
        current = current?.next

        for (i in 1..n - (k % n) - 1) {
            current = current?.next
        }
        var ans = current?.next
        current?.next = null

        return ans
    }
}