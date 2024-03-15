class Solution {
    fun mySqrt(x: Int): Int {
        if (x == 0) return 0
        if (x == 1) return 1
        var start = 0
        var end = x / 2
        var num = (start + end) / 2
        while (start <= end) {
            num = (start + end) / 2
            if (x.toLong() > (num.toLong()) * (num.toLong())) {
                start = num + 1
            } else if (num.toLong() * num.toLong() > x.toLong()) {
                end = num - 1
            } else {
                return num
            }
        }
        return start
    }
}