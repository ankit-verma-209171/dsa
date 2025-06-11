package tuf.arrays.hard

/**
 * Count the number of sub-tuf.arrays with given xor K
 *
 * Link: https://takeuforward.org/data-structure/count-the-number-of-subarrays-with-given-xor-k/
 */

private fun main() {
    val nums = intArrayOf(1, 2, 3, 2)
    val k = 2
    val count = countSubArraysWithXorK(nums = nums, k = k)
    println(count)
}

private fun countSubArraysWithXorK(nums: IntArray, k: Int): Int {
    val n = nums.size

    // Mapping for <xor> to <count>
    val lookUp = mutableMapOf<Int, Int>()
    lookUp[0] = 1

    var result = 0
    var currXor = 0

    for (i in 0..<n) {
        currXor = nums[i] xor currXor
        val remaining = k xor currXor
        lookUp[remaining]?.let {
            result += it
        }
        lookUp[currXor] = (lookUp[currXor] ?: 0) + 1
    }
    return result
}
