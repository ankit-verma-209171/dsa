package binarysearch.array1d

/**
 * Implement Lower Bound
 *
 * Link: https://takeuforward.org/arrays/implement-lower-bound-bs-2/
 */

private fun main() {
    val nums = intArrayOf(1, 2, 2, 3)
    val target = 2
    val lowerBound = findUpperBound(nums = nums, target = target)
    println(lowerBound)
}

private fun findUpperBound(nums: IntArray, target: Int): Int {
    val n = nums.size
    var low = 0
    var high = n - 1

    while (low <= high) {
        val mid = low + (high - low) / 2
        if (nums[mid] >= target) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }

    return low
}
