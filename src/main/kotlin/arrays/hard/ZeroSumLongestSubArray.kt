package arrays.hard

import kotlin.math.max

/**
 * Length of the longest subarray with zero Sum
 *
 * Link: https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum/
 */

private fun main() {
    val nums = intArrayOf(-2, 2, -8, 1, 7, 4, -10)
    val zeroSumLongestSubArrayLength = findZeroSumLongestSubArrayLength(nums = nums)
    println(zeroSumLongestSubArrayLength)
}

private fun findZeroSumLongestSubArrayLength(nums: IntArray): Int {
    val n = nums.size
    var maxLength = 0
    // Mapping for <prefix-sum> to <index>
    val lookUp = mutableMapOf<Int, Int>()
    // Edge case: prefixSum 0 will be upto index 0 (exclusive)
    lookUp[0] = -1
    var prefixSum = 0
    for (i in 0..<n) {
        prefixSum += nums[i]
        lookUp[prefixSum]?.let {
            // If there exists a prefix sum, it implies the numbers between the indices sums upto 0
            maxLength = max(maxLength, i - it)
        } ?: run {
            // Else we add it to our lookUp table
            lookUp[prefixSum] = i
        }
    }
    return maxLength
}
