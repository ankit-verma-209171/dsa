package arrays.easy

/**
 * Longest Subarray with given Sum K(Positives)
 *
 * Link: https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/
 */

private fun main() {
    val nums = intArrayOf(-13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6)
    val k = 15
    val longest = findLongestSubArraySizeOfSumK(nums = nums, k = k)
    println(longest)
}

/**
 * Previous sum lookup using Hashmap - works on all arrays.
 *
 * If sum til now is x and if the portion contains k so, there must of some portion containing x-k
 *
 * Example:
 * currSum = 19
 * k = 9
 * remaining = 10
 * <----------19--------->
 *  6   0   4   4   2   3
 * <---10---> <----9----->
 */
private fun findLongestSubArraySizeOfSumK(nums: IntArray, k: Int): Int {
    var longest = 0
    var i = 0
    var currSum = 0
    val lookUp = mutableMapOf<Int, Int>()

    while (i < nums.size) {
        currSum += nums[i]

        // If it's a match, compare and update
        if (currSum == k) {
            longest = maxOf(longest, i + 1)
        }

        val remaining = currSum - k
        lookUp[remaining]?.let {
            // Found remaining in lookup, so compare and update
            longest = maxOf(longest, i - it)
        }

        if (lookUp[currSum] == null) {
            // Only add the first sum value
            lookUp[currSum] = i
        }

        ++i
    }

    return longest
}

/**
 * Greedy & 2 Pointers approach - works on non-negative arrays only.
 */
private fun findLongestSubArraySizeOfSumKInNonNegativeArray(nums: IntArray, k: Int): Int {
    var longest = 0
    var i = 0
    var j = 0
    var currSum = 0

    while (j < nums.size) {
        val newSum = currSum + nums[j]
        when {
            // It's a match, compare & update
            newSum == k -> {
                longest = maxOf(longest, j - i + 1)
                ++j
            }

            // sum is less, need to add more using right pointer
            newSum < k -> {
                currSum += nums[j]
                ++j
            }

            // sum is more, need to reduce using left pointer
            else -> {
                currSum -= nums[i]
                ++i
            }
        }
    }

    return longest
}