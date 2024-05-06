// DP, BinarySearch 해결책 둘 다 있음
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val array = Array<Int>(nums.size){1}
        array[0] = 1

        for(i in 1..nums.lastIndex){
            for (j in 0..i-1){
                array[i] = max(array[j]+1, array[i])
            }
        } else{
            array[i] = array[i-1]
        }
    }


    return array.last()
}
}