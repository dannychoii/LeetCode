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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var ans = ListNode(-1)
        var current: ListNode? = ans

        var n1 = list1
        var n2 = list2
        while (n1 != null && n2 != null) {
            var a = n1?.`val` ?: 0
            var b = n2?.`val` ?: 0
            if (a > b) {
                current?.next = n2
                current = current?.next
                n2 = n2?.next
            } else {
                current?.next = n1
                current = current?.next
                n1 = n1?.next
            }
        }

        if (n1 != null) current?.next = n1
        if (n2 != null) current?.next = n2
        return ans.next
    }
}