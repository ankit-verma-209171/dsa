package binarysearch.array1d

/**
 * Search Element in a Rotated Sorted Array
 *
 * Link: https://takeuforward.org/data-structure/search-element-in-a-rotated-sorted-array/
 */

private fun main() {
    val nums = intArrayOf(5, 1, 2, 3, 4)
    val target = 1
    val index = find(nums = nums, target = target)
    println(index)
}

private fun find(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.lastIndex

    while (low <= high) {
        val mid = low + (high - low) / 2
        if (nums[mid] == target) {
            return mid
        } else if (nums[low] <= nums[mid]) {
            if (nums[low] <= target && target < nums[mid]) high = mid - 1
            else low = mid + 1
        } else {
            if (nums[mid] < target && target <= nums[high]) low = mid + 1
            else high = mid - 1
        }
    }
    return -1
}
