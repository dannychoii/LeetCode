// matroid 관점의 풀이가 존재함.
class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        var str = ""
        for((i, row) in matrix.withIndex()){
            for ((j,ele) in row.withIndex()){
                if(ele == 0){
                    str += "row:${i},"
                    str += "col:${j},"
                }
            }
        }

        for((i, row) in matrix.withIndex()){
            for ((j,ele) in row.withIndex()){
                if(str.contains("row:${i},") || str.contains("col:${j},")){
                    matrix[i][j] = 0
                }
            }
        }
    }
}
