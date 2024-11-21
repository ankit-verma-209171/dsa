package binarysearch.array1d

/**
 * Search Single Element in a sorted array
 *
 * Link: https://takeuforward.org/data-structure/search-single-element-in-a-sorted-array/
 */

private fun main() {
    val nums = intArrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 9, 10, 10)
    val single = findSingleElement(nums = nums)
    println("Single: $single")
}

private fun findSingleElement(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    var low = 0
    var high = nums.size - 1
    while (low < high) {
        val mid = low + (high - low) / 2
        val diff = mid - low
        if (nums[mid] == nums[mid - 1]) {
            if (diff % 2 == 0) high = mid - 2
            else low = mid + 1
        } else if (nums[mid] == nums[mid + 1]) {
            if (diff % 2 == 0) low = mid + 2
            else high = mid - 1
        } else {
            return nums[mid]
        }
    }
    return nums[low]
}
