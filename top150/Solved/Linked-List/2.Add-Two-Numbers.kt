// head 는 dummy로 선언하고, cur은 head의 next 로 선언한다
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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) return null
        var ans = ListNode(-1)
        var cur = ans

        var case = 0
        var a = l1
        var b = l2
        while (a != null || b != null) {
            var sums = (a?.`val` ?: 0) + (b?.`val` ?: 0) + case
            cur.next = ListNode(sums % 10)
            cur = cur.next

            a = a?.next
            b = b?.next
            case = sums / 10
        }

        if (case != 0) {
            cur.next = ListNode(1)
        }

        return ans.next
    }
}