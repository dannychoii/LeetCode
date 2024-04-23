/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
// merge sort도 있을 것 같으나 pq로 해결함
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val pq = PriorityQueue<ListNode>() { a, b -> a.`val`.compareTo(b.`val`) }
        for (list in lists) {
            var current = list
            while (current != null) {
                pq.add(current)
                current = current.next
            }
        }

        var answer = ListNode(-10001)
        var current = answer
        while (pq.isNotEmpty()) {
            current.next = pq.poll()
            current = current.next!!
        }
        current.next = null
        return answer.next
    }
}