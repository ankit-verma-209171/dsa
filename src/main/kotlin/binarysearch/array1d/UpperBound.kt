package binarysearch.array1d

/**
 * Implement Upper Bound
 *
 * Link: https://takeuforward.org/arrays/implement-upper-bound/
 */

private fun main() {
    val nums = intArrayOf(3, 5, 8, 9, 15, 19)
    val target = 9
    val upperBound = findUpperBound(nums = nums, target = target)
    println(upperBound)
}

private fun findUpperBound(nums: IntArray, target: Int): Int {
    val n = nums.size
    var low = 0
    var high = n - 1

    while (low <= high) {
        val mid = low + (high - low) / 2
        if (nums[mid] > target) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }

    return low
}
