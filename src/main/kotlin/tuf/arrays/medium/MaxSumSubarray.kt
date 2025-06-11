package tuf.arrays.medium

/**
 * Kadane's Algorithm : Maximum Subarray Sum in an Array
 *
 * Link: https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/
 */

private fun main() {
    val nums = intArrayOf(1)
    val maxSumArray = findSubArrayWithMaxSum(nums = nums)
    print(maxSumArray.contentToString())
}

/**
 * Kadane's algorithm
 */
private fun findMaxSumSubarray(nums: IntArray): Int {
    var maxSum = Int.MIN_VALUE
    var currSum = 0
    for (num in nums) {
        currSum += num
        if (currSum > maxSum) maxSum = currSum
        if (currSum < 0) currSum = 0
    }
    return maxSum
}

/**
 * Kadane's algorithm
 */
private fun findSubArrayWithMaxSum(nums: IntArray): IntArray {
    var maxSum = Int.MIN_VALUE
    var currSum = 0
    var start = 0
    var end = 0
    for ((index, num) in nums.withIndex()) {
        if (currSum == 0) {
            start = index
            end = index
        }
        currSum += num
        if (currSum > maxSum) {
            maxSum = currSum
            end = index
        }
        if (currSum <= 0) {
            currSum = 0
            start = index
            end = start
        }
    }
    return nums.sliceArray(start..end)
}