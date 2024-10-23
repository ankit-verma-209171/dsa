package arrays.easy

/**
 * Find the number that appears once, and the other numbers twice
 *
 * Link: https://takeuforward.org/arrays/find-the-number-that-appears-once-and-the-other-numbers-twice/
 */

private fun main() {
    val nums = intArrayOf(4, 1, 2, 1, 2)
    val oddOne = findOddOneOut(nums = nums)
    println(oddOne)
}

private fun findOddOneOut(nums: IntArray): Int {
    // XOR property:
    // 1. a^a = 0
    // 2. a^0 = a
    // so all doubles cancel out, remains only odd one
    return nums.reduce { acc, i -> acc xor i }
}