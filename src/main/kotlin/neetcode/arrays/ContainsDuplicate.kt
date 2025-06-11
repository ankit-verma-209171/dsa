package neetcode.arrays

/**
 * https://neetcode.io/problems/duplicate-integer?list=neetcode150
 */

private fun main() {
    val nums = intArrayOf(1, 2, 3, 4)
    println("Has duplicates: ${nums.hasDuplicates()}")
}

private fun IntArray.hasDuplicates(): Boolean {
    if (isEmpty()) return false
    val set = mutableSetOf<Int>()
    forEach { num ->
        if (num in set) return true
        set += num
    }
    return false
}
