/** O(N) 해결책도 존재, BinarySerach는 recursive 가 아닌
 */
class Solution {
    fun hIndex(citations: IntArray): Int {
        var n = citations.size
        citations.sort()
        var ans = 0


        fun bSearch(input: IntArray, first: Int, last: Int): Int {
            val middle = (first + last) / 2
            val rightRemainder = input.size - middle
            if (middle == first){
                if(input[first] >= rightRemainder){
                    return rightRemainder
                }
                else if (input[last]>= rightRemainder-1){
                    return rightRemainder-1
                }
                else return 0
            }
            if (input[middle] == rightRemainder) {
                return input[middle]
            } else if (input[middle] < rightRemainder) {
                return bSearch(input, middle, last)
            } else {
                return bSearch(input, first, middle)
            }
        }

        return bSearch(citations, 0, n-1)
    }
}