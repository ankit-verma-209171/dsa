package tuf.binarysearch.array1d

/**
 * Search Insert Position
 *
 * Link: https://takeuforward.org/arrays/search-insert-position/
 */

private fun main() {
    val nums = intArrayOf(1, 2, 4, 7)
    val x = 2
    val position = findSearchInsertPosition(nums = nums, x = x)
    println(position)
}

private fun findSearchInsertPosition(nums: IntArray, x: Int): Int {
    var low = 0
    var high = nums.size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (nums[mid] < x) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return low
}
