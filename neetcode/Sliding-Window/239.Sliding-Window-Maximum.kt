// Dequeue를 두고 적절하게 삭제와 입력을 반복한다.
// 이때 Dequeue 내부의 값들이 monotnic increasing 순서를 유지하게 한다.
class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val answer = mutableListOf<Int>()
        val q = ArrayDeque<Pair<Int, Int>>()

        for ((i, num) in nums.withIndex()) {

            while (q.isNotEmpty() && q.first().second <= num) {
                q.removeFirst()
            }

            while (q.isNotEmpty() && q.last().first < i + 1 - k) {
                q.removeLast()
            }

            if (q.isNotEmpty() && q.last().second >= num) {
                answer.add(q.last().second)
            } else {
                answer.add(num)
            }

            q.addFirst(Pair(i, num))
        }

        return answer.drop(k - 1).toIntArray()
    }
}