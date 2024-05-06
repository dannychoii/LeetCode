// binary 연산 직접 구현을 해야할까..
class Solution {
    fun addBinary(a: String, b: String): String {
        return (a.toBigInteger(2) + b.toBigInteger(2)).toString(2)
    }
}