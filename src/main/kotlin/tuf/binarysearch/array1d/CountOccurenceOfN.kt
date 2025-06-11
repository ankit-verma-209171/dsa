package tuf.binarysearch.array1d

/**
 * Count Occurrences in Sorted Array
 *
 * Link: https://takeuforward.org/data-structure/count-occurrences-in-sorted-array/
 */

private fun main() {
    val nums = intArrayOf(1, 1, 3, 5, 5)
    val target = 5
    val count = findOccurenceOfN(nums = nums, target = target)
    println(count)
}

private fun findOccurenceOfN(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (nums[mid] < target) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    if (low == nums.size || nums[low] != target) return 0
    val lowerLimit = low

    low = 0
    high = nums.size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (nums[mid] <= target) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    val upperLimit = low
    return upperLimit - lowerLimit
}
