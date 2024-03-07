class RandomizedSet() {

    private val set = mutableSetOf<Int>()

    fun insert(`val`: Int): Boolean {
        if (set.contains(`val`)) {
            return false
        } else {
            set.add(`val`)
            return true
        }
    }

    fun remove(`val`: Int): Boolean {
        if (set.contains(`val`)) {
            set.remove(`val`)
            return true
        } else {
            return false
        }
    }

    fun getRandom(): Int {
        return set.random()
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */