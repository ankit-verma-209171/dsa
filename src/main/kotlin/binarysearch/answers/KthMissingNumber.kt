package binarysearch.answers

/**
 * Kth Missing Positive Number
 *
 * Link: https://takeuforward.org/arrays/kth-missing-positive-number/
 */

private fun main() {
    val nums = intArrayOf(2, 4, 5)
    val k = 2
    val number = findMissingNumber(nums = nums, k = k)
    println(number)
}

private fun findMissingNumber(nums: IntArray, k: Int): Int {
    var low = 0
    var high = nums.size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        val offset = nums[mid] - 1 - mid
        if (offset < k) low = mid + 1
        else high = mid - 1
    }
    return if (high == -1) k else k + high + 1
}
