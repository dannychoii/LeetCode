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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val map = mutableMapOf<Int, Int>()
        var current = head
        while (current != null) {
            map[current.`val`] = (map[current.`val`] ?: 0) + 1
            current = current?.next
        }

        val list = map.filter { (key, value) -> value == 1 }.keys.toMutableList()
        list.sort()
        var ans = ListNode(-1)
        var cur = ans
        for (ele in list) {
            cur.next = ListNode(ele)
            cur = cur.next
        }
        return ans.next
    }
}