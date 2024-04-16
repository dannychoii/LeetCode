// priority queue에 넣고 나서 rebalancing해야 한다.
class MedianFinder() {
    val larger = PriorityQueue<Int>() { a, b -> a.compareTo(b) }
    val smaller = PriorityQueue<Int>() { a, b -> b.compareTo(a) }


    fun addNum(num: Int) {
        if (smaller.isEmpty()) {
            smaller.add(num)
        } else {
            if (smaller.peek() > num) {
                smaller.add(num)
            } else {
                larger.add(num)
            }
        }
        while (abs(smaller.size - larger.size) > 1) {
            if (smaller.size < larger.size) {
                smaller.add(larger.poll())
            } else {
                larger.add(smaller.poll())
            }
        }
    }

    fun findMedian(): Double {
        val a = smaller.size
        val b = larger.size

        return if (a > b) smaller.peek().toDouble()
        else if (a < b) larger.peek().toDouble()
        else (larger.peek() + smaller.peek()) / 2.0
    }

}