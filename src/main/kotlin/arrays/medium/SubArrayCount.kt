package arrays.medium

/**
 * Count Subarray sum Equals K
 *
 * Link: https://takeuforward.org/arrays/count-subarray-sum-equals-k/
 */

private fun main() {
    val nums = intArrayOf(1, -1, 0)
    val k = 0
    val count = countSubArray(nums = nums, k = k)
    println(count)
}

private fun countSubArray(nums: IntArray, k: Int): Int {
    var count = 0
    var currSum = 0

    // Setting up lookup map <sum, occurrence>
    val lookUp = mutableMapOf<Int, Int>()
    lookUp += 0 to 1

    for (num in nums) {
        currSum += num
        val remainingSum = currSum - k
        lookUp[remainingSum]?.let {
            count += it
        }
        lookUp[currSum] = (lookUp[currSum] ?: 0) + 1
    }
    return count
}
