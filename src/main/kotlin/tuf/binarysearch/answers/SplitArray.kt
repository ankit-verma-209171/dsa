package tuf.binarysearch.answers

/**
 * Split Array - Largest Sum
 *
 * Link: https://takeuforward.org/arrays/split-array-largest-sum/
 */

private fun main() {
    val nums = intArrayOf(3, 5, 1)
    val k = 3
    val sum = findMaximumSumOfSubarray(nums, k)
    println(sum)
}

private fun findMaximumSumOfSubarray(nums: IntArray, k: Int): Int {
    if (k > nums.size) return 0
    if (k == nums.size) return nums.max()

    var low = nums.max()
    var high = nums.sum()

    while (low <= high) {
        val mid = (low + high) / 2
        if (isPossibleSplit(nums, k = k, split = mid)) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return low
}

private fun isPossibleSplit(nums: IntArray, k: Int, split: Int): Boolean {
    var subArrays = 1
    var currSum = 0
    for (num in nums) {
        if (currSum + num <= split) {
            currSum += num
        } else {
            subArrays++
            currSum = num
        }
    }
    return subArrays > k
}
