// dummy node 활용
class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val dummy = ListNode(-1)
        var under = dummy

        var current = head

        var over = ListNode(-1)
        var overPointer = over

        while (current != null) {
            if (current.`val` < x) {
                under.next = current
                under = under.next!!
            } else {
                over.next = current
                over = over.next!!
            }
            current = current.next
        }
        over.next = null
        under.next = overPointer.next

        return dummy.next
    }
}