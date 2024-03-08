class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val set = mutableSetOf<String>()
        for ((i, row) in board.withIndex()) {
            for ((j, ele) in row.withIndex()) {
                if (ele == '.') continue
                if (!set.add("row $j $ele")) return false
                if (!set.add("col $i $ele")) return false
                if (!set.add("district ${districtNumber(i, j)} $ele")) return false
            }
        }
        return true
    }

    fun districtNumber(i: Int, j: Int): Int {
        return (i / 3) * 3 + (j / 3)
    }
}