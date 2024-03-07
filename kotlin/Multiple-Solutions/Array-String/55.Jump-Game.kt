// 더 좋은 솔루션 존재
class Solution {
    fun canJump(nums: IntArray): Boolean {
        var n = nums.size
        val reachAble = Array<Boolean>(n){false}
        reachAble[0] = true

        for (i in 0 .. reachAble.lastIndex){
            if (reachAble[i]){
                for(hop in 0..nums[i]){
                    reachAble[ min(i+hop,n-1)]= true
                }
            }
        }
        return reachAble.last()
    }
}