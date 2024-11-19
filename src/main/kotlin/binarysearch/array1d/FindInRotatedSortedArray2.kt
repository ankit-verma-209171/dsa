package binarysearch.array1d

/**
 * Search Element in Rotated Sorted Array II
 *
 * Link: https://takeuforward.org/arrays/search-element-in-rotated-sorted-array-ii/
 */

private fun main() {
    val nums = intArrayOf(3, 1, 2, 3, 3, 3, 3)
    val target = 20
    val found = find(nums = nums, target = target)
    println(found)
}

private fun find(nums: IntArray, target: Int): Boolean {
    var low = 0
    var high = nums.lastIndex

    while (low <= high) {
        val mid = low + (high - low) / 2
        if (nums[mid] == target) {
            return true
        } else if (nums[low] == nums[high] && nums[mid] == nums[high]) {
            ++low
            --high
        } else if (nums[low] <= nums[mid]) {
            if (nums[low] <= target && target < nums[mid]) high = mid - 1
            else low = mid + 1
        } else {
            if (nums[mid] < target && target <= nums[high]) low = mid + 1
            else high = mid - 1
        }
    }
    return false
}
