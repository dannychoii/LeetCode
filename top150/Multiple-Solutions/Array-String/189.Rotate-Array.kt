// 복수풀이 세가지 존재
class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        var temp: Int
        for ( i in 1 .. k){
            temp = nums.last()
            for (index in nums.lastIndex downTo 1){
                nums[index] = nums[index-1]
            }
            nums[0] = temp
        }
    }
}